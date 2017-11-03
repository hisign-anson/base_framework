package com.hisign.xingzhen.nt.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class MsgBase implements Serializable {

	/** **/
	private static final long serialVersionUID = -5717322895409279444L;
	@NotEmpty(message = "消息ID不能为空")
	private String msgId;

	/**
	 * 发送内容
	 */
	private String msgContent;
	/**
	 * 接收人列表
	 */
	@NotNull(message = "接收人列表不能为空")
	private String[] msgReceiver;
	
	/**
	 * 发送人
	 */
	@NotEmpty(message = "发送人不能为空")
	private String sender;
	
	/**
	 * 发送时间
	 */
	private Date sendDate = new Date();

	//发送类型
	private String sendType;

	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}

	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	

	/**
	 * @return the msgContent
	 */
	public String getMsgContent() {
		return msgContent;
	}

	/**
	 * @param msgContent the msgContent to set
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	/**
	 * @return the msgReceiver
	 */
	public String[] getMsgReceiver() {
		return msgReceiver;
	}

	/**
	 * @param msgReceiver the msgReceiver to set
	 */
	public void setMsgReceiver(String[] msgReceiver) {
		this.msgReceiver = msgReceiver;
	}

	

	/**
	 * @return the sender
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * @param sender the sender to set
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * @return the sendDate
	 */
	public Date getSendDate() {
		return sendDate;
	}

	/**
	 * @param sendDate the sendDate to set
	 */
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
}
