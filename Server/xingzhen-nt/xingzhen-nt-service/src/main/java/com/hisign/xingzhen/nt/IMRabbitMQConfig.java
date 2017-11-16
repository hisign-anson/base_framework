package com.hisign.xingzhen.nt;

import com.alibaba.fastjson.JSON;
import com.hisign.xingzhen.nt.api.common.RespCode;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.model.NoteBean;
import com.hisign.xingzhen.nt.service.SendService;
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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class IMRabbitMQConfig {
	private static final Logger logger = LoggerFactory.getLogger(IMRabbitMQConfig.class);

	public static final String NOTE_EXCHANGE = "ex-im-appmsgcallback";
	public static final String NOTE_ROUTINGKEY = "rkey-im-appmsgcallback ";
	public static final String NOTE_QUEUE = "queue.im.appmsgcallback";

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

    @Bean
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
        return new DirectExchange(NOTE_EXCHANGE, true, false);
    }

	@Bean
    public Queue imQueue() {
       return new Queue(NOTE_QUEUE, true);
    }

    @Bean
    public Binding imBinding() {
        return BindingBuilder.bind(imQueue()).to(imExchange()).with(NOTE_ROUTINGKEY);
    }

    private static ConcurrentHashMap<String, Integer> cacheMap = new ConcurrentHashMap<String, Integer>();

    /**
     * 接受消息的监听
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer noteMessageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(imQueue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
            public void onMessage(Message message, Channel channel) throws Exception {
                String msg = new String(message.getBody());
                logger.info("收到消息={0}", msg);
                NoteBean noteBean = JSON.parseObject(msg, NoteBean.class);
                try {
					String ret = sendService.sendSms(noteBean);
					if(RespCode.SUCCESS.name().equals(ret)){//发送成功
						channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
						if(cacheMap.containsKey(noteBean.getMsgId())){
							cacheMap.remove(noteBean.getMsgId());
						}
					}else{//发送失败，重新发送
						reTry(message, channel, noteBean);
					}
				} catch (NoticeException e) {
					//重发消息
					reTry(message, channel, noteBean);
				}
            }

			private void reTry(Message message, Channel channel, NoteBean noteBean) throws IOException {
				if(!cacheMap.isEmpty() && cacheMap.containsKey(noteBean.getMsgId())){
                    Integer count = cacheMap.get(noteBean.getMsgId());
                    if(count.intValue() <= retryCount){
                        //重发消息
                        channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                        count++;
                        cacheMap.put(noteBean.getMsgId(), count);
                    }else{
                        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
                        cacheMap.remove(noteBean.getMsgId());
                    }
                }else{
                    Integer count = 0;
                    //重发消息
                    channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                    count++;
                    cacheMap.put(noteBean.getMsgId(), count);
                }
			}
		});
        return container;
    }
}
