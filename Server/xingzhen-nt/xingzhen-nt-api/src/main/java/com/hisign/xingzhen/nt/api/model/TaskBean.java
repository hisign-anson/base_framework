package com.hisign.xingzhen.nt.api.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 16:24 2017/11/2
 */
public class TaskBean implements Serializable{

    private String msgId;

    private String msgType;

    private String id; //任务ID

    private String groupid; //专案组ID

    private String taskContent; //任务内容

    private String creator; //创建人

    private String createname; //创建人姓名

    private String fkxs; //反馈线索

    private Date fkTime; //反馈时间

    private Date fkjzTime; //反馈截止时间

    private String jsr; //接收人

    private String jsrname; //接收人姓名

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getFkxs() {
        return fkxs;
    }

    public void setFkxs(String fkxs) {
        this.fkxs = fkxs;
    }

    public Date getFkTime() {
        return fkTime;
    }

    public void setFkTime(Date fkTime) {
        this.fkTime = fkTime;
    }

    public Date getFkjzTime() {
        return fkjzTime;
    }

    public void setFkjzTime(Date fkjzTime) {
        this.fkjzTime = fkjzTime;
    }

    public String getJsr() {
        return jsr;
    }

    public void setJsr(String jsr) {
        this.jsr = jsr;
    }

    public String getJsrname() {
        return jsrname;
    }

    public void setJsrname(String jsrname) {
        this.jsrname = jsrname;
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
}
