package com.hisign.xingzhen.xz.api.param;

import cn.jmessage.api.common.model.message.MessageBody;

import java.io.Serializable;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:19 2017/11/16
 */
public class IMessageParam implements Serializable {

    private String id;
    private Integer version;
    private String target_type;
    private String target_name;
    private String target_id;
    private String from_type;
    private String from_name;
    private String from_id;
    private String msg_type;
    private String msg_body;
    private String create_time;//秒
    private String msg_ctime;// 服务器接收到消息的时间，单位毫秒
    private String msgid;//群组id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTarget_type() {
        return target_type;
    }

    public void setTarget_type(String target_type) {
        this.target_type = target_type;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }

    public String getTarget_id() {
        return target_id;
    }

    public void setTarget_id(String target_id) {
        this.target_id = target_id;
    }

    public String getFrom_type() {
        return from_type;
    }

    public void setFrom_type(String from_type) {
        this.from_type = from_type;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getFrom_id() {
        return from_id;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_body() {
        return msg_body;
    }

    public void setMsg_body(String msg_body) {
        this.msg_body = msg_body;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getMsg_ctime() {
        return msg_ctime;
    }

    public void setMsg_ctime(String msg_ctime) {
        this.msg_ctime = msg_ctime;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
}
