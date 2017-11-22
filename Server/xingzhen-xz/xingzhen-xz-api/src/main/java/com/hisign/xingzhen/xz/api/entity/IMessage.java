package com.hisign.xingzhen.xz.api.entity;

import org.springframework.data.annotation.Id;
import java.util.Date;

/**
 * @Author: 何建辉
 * @Description:极光消息
 * @Date: Created in 15:26 2017/11/16
 */
public class IMessage {

    public final static String INDEX="xingji";
    public final static String TYPE="imessage";

    private String msgid;//消息id
    private Integer version;
    private String target_type;
    private String target_name;
    private String target_id;
    private String from_type;
    private String from_name;
    private String from_id;
    private String msg_type;
    private String msg_body;
    private Long create_time;//秒
    private Long msg_ctime;// 服务器接收到消息的时间，单位毫秒
    private String msgText;//文本消息

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

    public static String getINDEX() {
        return INDEX;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getMsg_ctime() {
        return msg_ctime;
    }

    public void setMsg_ctime(Long msg_ctime) {
        this.msg_ctime = msg_ctime;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsgText() {
        return msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Override
    public String toString() {
        return "IMessage{" +
                "msgid='" + msgid + '\'' +
                ", version=" + version +
                ", target_type='" + target_type + '\'' +
                ", target_name='" + target_name + '\'' +
                ", target_id='" + target_id + '\'' +
                ", from_type='" + from_type + '\'' +
                ", from_name='" + from_name + '\'' +
                ", from_id='" + from_id + '\'' +
                ", msg_type='" + msg_type + '\'' +
                ", msg_body='" + msg_body + '\'' +
                ", create_time='" + create_time + '\'' +
                ", msg_ctime='" + msg_ctime + '\'' +
                ", msgText='" + msgText + '\'' +
                '}';
    }
}
