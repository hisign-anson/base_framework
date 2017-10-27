package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 《任务》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务查询")
public class TaskSelectParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "登陆用户ID",required = true)
    private String userId;

    @ApiModelProperty(value = "任务编号")
    private String taskNo; //任务编号

    @ApiModelProperty(value = "任务名称")
    private String taskName; //任务名称

    @ApiModelProperty(value = "专案组ID")
    private String groupid; //专案组ID

    @ApiModelProperty(value = "接收人")
    private String jsr; //接收人

    @ApiModelProperty(value = "反馈状态，0未反馈，1已反馈")
    private String fkzt; //反馈状态

    @ApiModelProperty(value = "移交状态，0未移交，1已移交")
    private String yjzt; //移交状态

    @ApiModelProperty(value = "创建人")
    private String creator; //创建人

    @ApiModelProperty(value = "创建开始时间")
    private Date startTime;

    @ApiModelProperty(value = "创建结束时间")
    private Date endTime;

    @ApiModelProperty(value = "创建人单位")
    private String deparmentcode; //创建人单位

    @ApiModelProperty(value = "接受字段-超期标示 1表示超期")
    private String  overdue;//1表示超期

    @ApiModelProperty(value = "接受字段-任务类型 1表示本人接收，2表示本人下发，全部传空")
    private String taskType;//1表示本人接收，2表示本人下发

    @ApiModelProperty(value = "反馈截止开始时间")
    private Date fkjzstartTime;

    @ApiModelProperty(value = "反馈截止结束时间")
    private Date fkjzendTime;

    @ApiModelProperty(value = "反馈确认状态，0未确认，1已确认")
    private String fkqrzt;

    @ApiModelProperty(value = "分页开始")
    private int begin = 0;

    @ApiModelProperty(value = "分页结束")
    private int end = 0;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getJsr() {
        return jsr;
    }

    public void setJsr(String jsr) {
        this.jsr = jsr;
    }

    public String getFkzt() {
        return fkzt;
    }

    public void setFkzt(String fkzt) {
        this.fkzt = fkzt;
    }

    public String getYjzt() {
        return yjzt;
    }

    public void setYjzt(String yjzt) {
        this.yjzt = yjzt;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDeparmentcode() {
        return deparmentcode;
    }

    public void setDeparmentcode(String deparmentcode) {
        this.deparmentcode = deparmentcode;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Date getFkjzstartTime() {
        return fkjzstartTime;
    }

    public void setFkjzstartTime(Date fkjzstartTime) {
        this.fkjzstartTime = fkjzstartTime;
    }

    public Date getFkjzendTime() {
        return fkjzendTime;
    }

    public void setFkjzendTime(Date fkjzendTime) {
        this.fkjzendTime = fkjzendTime;
    }

    public String getFkqrzt() {
        return fkqrzt;
    }

    public void setFkqrzt(String fkqrzt) {
        this.fkqrzt = fkqrzt;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}