package com.hisign.xingzhen.nt;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.fastjson.JSONObject;
import com.hisign.xingzhen.nt.api.model.JMBean;
import com.hisign.xingzhen.nt.service.SendService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
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

import com.alibaba.fastjson.JSON;
import com.hisign.xingzhen.nt.api.common.RespCode;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.model.NoteBean;

@Configuration
public class RabbitMQConfig {
	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConfig.class);

	public static final String NOTE_EXCHANGE = "exchange.note";
	public static final String NOTE_ROUTINGKEY = "routingkey.note";
	public static final String NOTE_QUEUE = "queue.note";
	
	public static final String MSG_EXCHANGE = "exchange.msg";
	public static final String MSG_ROUTINGKEY = "routingkey.msg";
	public static final String MSG_QUEUE = "queue.msg";

	public static final String JM_EXCHANGE = "exchange.jm";
	public static final String JM_ROUTINGKEY = "routingkey.jm";
	public static final String JM_QUEUE = "queue.jm";

	public static final String JM_OPERATE_EXCHANGE = "exchange.jm.operate";
	public static final String JM_OPERATE_ROUTINGKEY = "routingkey.jm.operate";
	public static final String JM_OPERATE_QUEUE = "queue.jm.operate";

	@Value("${spring.rabbitmq.addresses}")
	private String addresses;
	@Value("${spring.rabbitmq.username}")
	private String username;
	@Value("${spring.rabbitmq.password}")
	private String password;
	@Value("${spring.rabbitmq.virtual-host}")
	private String virtualHost;
	@Value("${spring.rabbitmq.publisher-confirms}")
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
    public DirectExchange noteExchange() {  
        return new DirectExchange(NOTE_EXCHANGE, true, false);
    } 
    
    @Bean  
    public DirectExchange msgExchange() {  
        return new DirectExchange(MSG_EXCHANGE, true, false);
    }

	@Bean
	public DirectExchange jmExchange() {
		return new DirectExchange(JM_EXCHANGE, true, false);
	}

	@Bean
	public DirectExchange jmOperateExchange() {
		return new DirectExchange(JM_OPERATE_EXCHANGE, true, false);
	}

	@Bean
    public Queue noteQueue() {  
       return new Queue(NOTE_QUEUE, true); 
    }
    @Bean  
    public Queue msgQueue() {  
       return new Queue(MSG_QUEUE, true); 
    }

	@Bean
	public Queue jmQueue() {
		return new Queue(JM_QUEUE, true);
	}
    
	@Bean
	public Queue jmOperateQueue() {
		return new Queue(JM_OPERATE_QUEUE, true);
	}

    @Bean
    public Binding noteBinding() {  
        return BindingBuilder.bind(noteQueue()).to(noteExchange()).with(NOTE_ROUTINGKEY);  
    } 
    @Bean  
    public Binding msgBinding() {  
        return BindingBuilder.bind(msgQueue()).to(msgExchange()).with(MSG_ROUTINGKEY);  
    }

	@Bean
	public Binding jmBinding() {
		return BindingBuilder.bind(jmQueue()).to(jmExchange()).with(JM_ROUTINGKEY);
	}

	@Bean
	public Binding jmOperateBinding() {
		return BindingBuilder.bind(jmQueue()).to(jmExchange()).with(JM_OPERATE_ROUTINGKEY);
	}

    private static ConcurrentHashMap<String, Integer> cacheMap = new ConcurrentHashMap<String, Integer>();

    /**
     * 接受消息的监听
     * @return
     */
    @Bean  
    public SimpleMessageListenerContainer noteMessageContainer() {  
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());  
        container.setQueues(noteQueue());  
        container.setExposeListenerChannel(true);  
        container.setMaxConcurrentConsumers(1);  
        container.setConcurrentConsumers(1);  
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认  
        container.setMessageListener(new ChannelAwareMessageListener() {
            public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
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
				} catch (NoticeException e) {
					//重发消息
					if(!cacheMap.isEmpty() &&cacheMap.containsKey(noteBean.getMsgId())){
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
            }
        });
        return container;  
    }

    /**
     * 接受消息的监听
     * @return
     */
    @Bean  
    public SimpleMessageListenerContainer msgMessageContainer() {  
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());  
        container.setQueues(msgQueue());  
        container.setExposeListenerChannel(true);  
        container.setMaxConcurrentConsumers(1);  
        container.setConcurrentConsumers(1);  
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认  
        container.setMessageListener(new ChannelAwareMessageListener() {
            public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
                String msg = new String(message.getBody());  
                logger.info("收到消息={0}", msg);
                MsgBean msgBean = JSON.parseObject(msg, MsgBean.class);
                try {
					String ret = sendService.sendMsg(msgBean);
					if(RespCode.SUCCESS.name().equals(ret)){//发送成功
						channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
						if(cacheMap.containsKey(msgBean.getMsgId())){
							cacheMap.remove(msgBean.getMsgId());
						}
					}else{//发送失败，重新发送
						//重发消息
						if(cacheMap.containsKey(msgBean.getMsgId())){
							Integer count = cacheMap.get(msgBean.getMsgId());
							if(count.intValue() <= retryCount){
								//重发消息
								channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
								count++;
								cacheMap.put(msgBean.getMsgId(), count);
							}else{
								channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
								cacheMap.remove(msgBean.getMsgId());
							}
						}else{
							Integer count = 0;
							//重发消息
							channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
							count++;
							cacheMap.put(msgBean.getMsgId(), count);
						}
					}

				} catch (NoticeException e) {
					//重发消息
					if(cacheMap.containsKey(msgBean.getMsgId())){
						Integer count = cacheMap.get(msgBean.getMsgId());
						if(count.intValue() <= retryCount){
							//重发消息
							channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
							count++;
							cacheMap.put(msgBean.getMsgId(), count);
						}else{
							channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
							cacheMap.remove(msgBean.getMsgId());
						}
					}else{
						Integer count = 0;
						//重发消息
						channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
						count++;
						cacheMap.put(msgBean.getMsgId(), count);
					}
				}
            }  
        });  
        return container;  
    }

	/**
	 * 接受消息的监听
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer jmMessageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
		container.setQueues(jmQueue());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
				String msg = new String(message.getBody());
				logger.info("收到消息={0}", msg);
				JMBean msgBean = JSON.parseObject(msg, JMBean.class);
				try {
					String ret = sendService.sendJM(msgBean);
					if(RespCode.SUCCESS.name().equals(ret)){//发送成功
						channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
						if(cacheMap.containsKey(msgBean.getMsgId())){
							cacheMap.remove(msgBean.getMsgId());
						}
					}else{//发送失败，重新发送
						//重发消息
						if(cacheMap.containsKey(msgBean.getMsgId())){
							Integer count = cacheMap.get(msgBean.getMsgId());
							if(count.intValue() <= retryCount){
								//重发消息
								channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
								count++;
								cacheMap.put(msgBean.getMsgId(), count);
							}else{
								channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
								cacheMap.remove(msgBean.getMsgId());
							}
						}else{
							Integer count = 0;
							//重发消息
							channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
							count++;
							cacheMap.put(msgBean.getMsgId(), count);
						}
					}

				} catch (NoticeException e) {
					//重发消息
					if(cacheMap.containsKey(msgBean.getMsgId())){
						Integer count = cacheMap.get(msgBean.getMsgId());
						if(count.intValue() <= retryCount){
							//重发消息
							channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
							count++;
							cacheMap.put(msgBean.getMsgId(), count);
						}else{
							channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
							cacheMap.remove(msgBean.getMsgId());
						}
					}else{
						Integer count = 0;
						//重发消息
						channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
						count++;
						cacheMap.put(msgBean.getMsgId(), count);
					}
				}
			}
		});
		return container;
	}

	/**
	 * 接受消息的监听
	 * @return
	 */
	@Bean
	public SimpleMessageListenerContainer jmOperateMessageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
		container.setQueues(jmOperateQueue());
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
		container.setMessageListener(new ChannelAwareMessageListener() {
			public void onMessage(Message message, Channel channel) throws Exception {
				String msg = new String(message.getBody());
				logger.info("收到消息={0}", msg);
				Map<String,Object> msgBean = JSON.parseObject(msg, Map.class);
				try {
					String ret = sendService.sendJMOperate(msgBean);

					if(RespCode.SUCCESS.name().equals(ret)){//发送成功
						channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
						if(cacheMap.containsKey(msgBean.get("msgId"))){
							cacheMap.remove(msgBean.get("msgId"));
						}
					}else{//发送失败，重新发送
						//重发消息
						if(cacheMap.containsKey(msgBean.get("msgId"))){
							Integer count = cacheMap.get(msgBean.get("msgId"));
							if(count.intValue() <= retryCount){
								//重发消息
								channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
								count++;
								cacheMap.put((String) msgBean.get("msgId"), count);
							}else{
								channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
								cacheMap.remove(msgBean.get("msgId"));
							}
						}else{
							Integer count = 0;
							//重发消息
							channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
							count++;
							cacheMap.put((String) msgBean.get("msgId"), count);
						}
					}

				} catch (NoticeException e) {
					//重发消息
					if(cacheMap.containsKey(msgBean.get("msgId"))){
						Integer count = cacheMap.get(msgBean.get("msgId"));
						if(count.intValue() <= retryCount){
							//重发消息
							channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
							count++;
							cacheMap.put((String) msgBean.get("msgId"), count);
						}else{
							channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
							cacheMap.remove(msgBean.get("msgId"));
						}
					}else{
						Integer count = 0;
						//重发消息
						channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
						count++;
						cacheMap.put((String) msgBean.get("msgId"), count);
					}
				}
			}
		});
		return container;
	}
}
