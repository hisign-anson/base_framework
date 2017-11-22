package com.hisign.xingzhen.nt.api.model;


import com.alibaba.fastjson.JSON;
import com.hisign.xingzhen.xz.api.entity.IMessage;

/**
 * @Author : 何建辉
 * @Description :
 * @Date : Created in 10:30 2017/11/17
 */
public class JMessage {

    private String uid;
    private String from_name;
    private String msgid;
    private String msg_type;
    private String msg_level;
    private String target;
    private String target_name;
    private String sdk_version;
    private String target_count;
    private String juid;
    private String platform;
    private String appkey;
    private Long itime;
    private IMessage content;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFrom_name() {
        return from_name;
    }

    public void setFrom_name(String from_name) {
        this.from_name = from_name;
    }

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_level() {
        return msg_level;
    }

    public void setMsg_level(String msg_level) {
        this.msg_level = msg_level;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget_name() {
        return target_name;
    }

    public void setTarget_name(String target_name) {
        this.target_name = target_name;
    }

    public String getSdk_version() {
        return sdk_version;
    }

    public void setSdk_version(String sdk_version) {
        this.sdk_version = sdk_version;
    }

    public String getTarget_count() {
        return target_count;
    }

    public void setTarget_count(String target_count) {
        this.target_count = target_count;
    }

    public String getJuid() {
        return juid;
    }

    public void setJuid(String juid) {
        this.juid = juid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public Long getItime() {
        return itime;
    }

    public void setItime(Long itime) {
        this.itime = itime;
    }

    public IMessage getContent() {
        return content;
    }

    public void setContent(IMessage content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
