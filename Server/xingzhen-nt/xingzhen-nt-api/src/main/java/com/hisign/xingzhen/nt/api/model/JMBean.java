package com.hisign.xingzhen.nt.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 9:13 2017/11/3
 */
public class JMBean implements Serializable{

    private String msgId;//唯一id

    private String msgType;//消息类型key Constants

    private String targetType;//single个人 group群组

    private String messageType;//reference MessageType

    private String fromId;//发送用户id

    private String targetId;//目标用户id

    private String messageBody;

    public JMBean(String msgId, String msgType, String targetType, String messageType, String fromId, String targetId) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.targetType = targetType;
        this.messageType = messageType;
        this.fromId = fromId;
        this.targetId = targetId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
