package com.hisign.xingzhen.nt.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 9:13 2017/11/3
 */
public class JMBean implements Serializable{

    private String msgId;//唯一id

    private String version="1";

    private String msgType;//消息类型key Constants

    private String target_type;//single个人 group群组

    private String msg_type;//reference MessageType

    private String from_id;//发送用户id

    private String from_type;//发送消息者身份 当前只限admin用户

    private String target_id;//目标用户id

    private String msg_body;

    public JMBean() {
    }

    public JMBean(String msgId, String msgType,String fromType, String targetType, String messageType, String fromId, String targetId) {
        this.msgId = msgId;
        this.msgType = msgType;
        this.target_type = targetType;
        this.msg_type = messageType;
        this.from_id = fromId;
        this.from_type= fromType;
        this.target_id = targetId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getFrom_type() {
        return from_type;
    }

    public void setFrom_type(String from_type) {
        this.from_type = from_type;
    }

    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getMsg_body() {
        return msg_body;
    }

    public void setMsg_body(String msg_body) {
        this.msg_body = msg_body;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
