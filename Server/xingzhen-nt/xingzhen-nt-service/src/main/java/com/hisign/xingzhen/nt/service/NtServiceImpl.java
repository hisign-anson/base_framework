package com.hisign.xingzhen.nt.service;

import com.hisign.xingzhen.nt.api.model.JMBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.hisign.xingzhen.nt.RabbitMQConfig;
import com.hisign.xingzhen.nt.api.exception.NoticeException;
import com.hisign.xingzhen.nt.api.model.MsgBean;
import com.hisign.xingzhen.nt.api.model.NoteBean;
import com.hisign.xingzhen.nt.api.service.NtService;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service("ntService")
public class NtServiceImpl implements RabbitTemplate.ConfirmCallback,NtService{
	private static final Logger logger = LoggerFactory.getLogger(NtServiceImpl.class);
	private RabbitTemplate rabbitTemplate;  
	  
    @Autowired  
    public NtServiceImpl(RabbitTemplate rabbitTemplate) {  
        this.rabbitTemplate = rabbitTemplate;  
        this.rabbitTemplate.setConfirmCallback(this);  
    }  
    
	@Override
	public void sendNote(NoteBean bean) throws NoticeException {
		String msg = JSON.toJSONString(bean);
		logger.info("发送短信："+msg);
		CorrelationData correlationData = new CorrelationData(bean.getMsgId());  
		rabbitTemplate.convertAndSend(RabbitMQConfig.NOTE_EXCHANGE, RabbitMQConfig.NOTE_ROUTINGKEY, msg, correlationData);
	}

	@Override
	public void sendMsg(MsgBean bean) throws NoticeException {
		String msg = JSON.toJSONString(bean);
		logger.info("发送通知消息："+msg);
		CorrelationData correlationData = new CorrelationData(bean.getMsgId());  
		rabbitTemplate.convertAndSend(RabbitMQConfig.MSG_EXCHANGE, RabbitMQConfig.MSG_ROUTINGKEY, msg, correlationData);
	}

	@Override
	public void sendJM(@RequestBody JMBean bean) throws NoticeException {
		String msg = JSON.toJSONString(bean);
		logger.info("发送通知消息："+msg);
		CorrelationData correlationData = new CorrelationData(bean.getMsgId());
		rabbitTemplate.convertAndSend(RabbitMQConfig.JM_EXCHANGE, RabbitMQConfig.JM_ROUTINGKEY, msg, correlationData);
	}

	@Override
	public void sendJMOperate(Map<String, Object> bean) throws NoticeException {
		String msg = JSON.toJSONString(bean);
		logger.info("发送通知消息："+msg);
		CorrelationData correlationData = new CorrelationData((String) bean.get("msgId"));
		rabbitTemplate.convertAndSend(RabbitMQConfig.JM_OPERATE_EXCHANGE, RabbitMQConfig.JM_OPERATE_ROUTINGKEY, msg, correlationData);
	}

	@Override
	public void confirm(CorrelationData correlationData, boolean ack,
			String cause) {
		if(ack){//消息成功消费
			logger.info("消息成功消费id="+correlationData.getId());
		}else{//消息消费失败 重新发送
			logger.info("消息消费失败id="+correlationData.getId());
		}
	}

}
