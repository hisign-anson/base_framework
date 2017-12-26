package com.hisign.xingzhen.nt;

import cn.jmessage.api.message.MessageType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hisign.xingzhen.common.util.StringUtils;
import com.hisign.xingzhen.nt.api.common.RespCode;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.api.model.JMessage;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.model.NoteBean;
import com.hisign.xingzhen.nt.service.SendService;
import com.hisign.xingzhen.xz.api.entity.IMessage;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class IMRabbitMQConfig {
	private static final Logger logger = LoggerFactory.getLogger(IMRabbitMQConfig.class);

	public static final String IM_EXCHANGE = "ex-im-appmsgcallback";
	public static final String IM_ROUTINGKEY = "rkey-im-appmsgcallback";
	public static final String IM_QUEUE = "queue.im.appmsgcallback";

	@Value("${im.rabbitmq.addresses}")
	private String addresses;

	@Value("${im.rabbitmq.username}")
	private String username;

	@Value("${im.rabbitmq.password}")
	private String password;

	@Value("${im.rabbitmq.virtual-host}")
	private String virtualHost;

	@Value("${im.rabbitmq.publisher-confirms}")
	private boolean publisherConfirms;

	@Value("${spring.rabbitmq.retryCount}")
	private int retryCount;

	@Autowired
	private SendService sendService;

    @Bean("IMConnectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses.trim());
        connectionFactory.setUsername(username.trim());
        connectionFactory.setPassword(password.trim());
        connectionFactory.setVirtualHost(virtualHost.trim());
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(publisherConfirms);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        return template;
    }

    @Bean
    public DirectExchange imExchange() {
        return new DirectExchange(IM_EXCHANGE, true, false);
    }

	@Bean
    public Queue imQueue() {
       return new Queue(IM_QUEUE, true);
    }

    @Bean
    public Binding imBinding() {
        return BindingBuilder.bind(imQueue()).to(imExchange()).with(IM_ROUTINGKEY);
    }

    private static ConcurrentHashMap<String, Integer> cacheMap = new ConcurrentHashMap<String, Integer>();

    /**
     * 接受消息的监听
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer imMessageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(imQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            @Override
            public void onMessage(Message message, Channel channel) throws Exception {
                String msg = new String(message.getBody());
                logger.info("收到消息=[{}]", msg);
                JSONObject jsonObject = JSON.parseObject(msg);
                jsonObject.put("msgId", StringUtils.getUUID());
                JSONArray rows = jsonObject.getJSONArray("rows");

                if (rows!=null && rows.size()>0){
                    List<IMessage> list = new ArrayList<>(rows.size());
                    for (int i = 0; i < rows.size(); i++) {
                        JSONObject json = rows.getJSONObject(i);
                        JMessage jMessage = JSON.parseObject(json.toJSONString(), JMessage.class);
                        IMessage noteBean = JSON.parseObject(json.getString("content"), IMessage.class);

                        noteBean.setMsgid(jMessage.getMsgid());
                        noteBean.setFrom_name(jMessage.getFrom_name());
                        noteBean.setTarget_name(jMessage.getTarget_name());
                        noteBean.setMsg_ctime(jMessage.getItime());
                        if (noteBean.getMsg_type().equals(MessageType.CUSTOM.getValue()) || noteBean.getMsg_type().equals(MessageType.TEXT.getValue())){
                            String msg_body = noteBean.getMsg_body();
                            JSONObject body = JSON.parseObject(msg_body);
                            String text = (String) body.get("text");
                            if (StringUtils.isNotBlank(text)){
                                noteBean.setMsgText(text);
                            }
                        }

                        list.add(noteBean);

                        logger.info("收到消息JMessage=[{}]", jMessage);
                        logger.info("收到消息IMessage=[{}]", noteBean);
                    }

                    try {
                        String ret = sendService.sendIMMsg(list);
                        if(RespCode.SUCCESS.name().equals(ret)){//发送成功
                            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                            if(cacheMap.containsKey(jsonObject.getString("msgId"))){
                                cacheMap.remove(jsonObject.getString("msgId"));
                            }
                        }else{//发送失败，重新发送
                            reTry(message, channel, jsonObject.getString("msgId"));
                        }
                    } catch (NoticeException e) {
                        //重发消息
                        reTry(message, channel, jsonObject.getString("msgId"));
                    }
                }
            }

			private void reTry(Message message, Channel channel, String msgId) throws IOException {
				if(!cacheMap.isEmpty() && cacheMap.containsKey(msgId)){
                    Integer count = cacheMap.get(msgId);
                    if(count.intValue() <= retryCount){
                        //重发消息
                        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                        count++;
                        cacheMap.put(msgId, count);
                    }else{
                        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                        cacheMap.remove(msgId);
                    }
                }else{
                    Integer count = 0;
                    //重发消息
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                    count++;
                    cacheMap.put(msgId, count);
                }
			}
		});
        return container;
    }
}
