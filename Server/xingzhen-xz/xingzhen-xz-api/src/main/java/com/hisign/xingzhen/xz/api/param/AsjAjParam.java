package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hisign on 2017/10/23.
 */
public class AsjAjParam implements Serializable{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "案件编号")
    private String ajbh; //案件编号

    @ApiModelProperty(value = "案件名称")
    private String ajmc; //案件名称

    @ApiModelProperty(value = "案别/案由-字典项＝24")
    private String ab; //案别/案由-字典项＝24

    @ApiModelProperty(value = "案件状态-字典项＝56")
    private String ajstate; //案件状态-字典项＝56

    @ApiModelProperty(value = "受理单位/接收单位-字典项＝06")
    private String sljsdw; //受理单位/接收单位-字典项＝06

    @ApiModelProperty(value = "发案地点详址")
    private String fadd; //发案地点详址

    @ApiModelProperty(value = "案发开始时间")
    private Date startTime;

    @ApiModelProperty(value = "案发结束时间")
    private Date endTime;

    @ApiModelProperty(value = "受理开始时间")
    private Date slStartTime;//受理开始时间

    @ApiModelProperty(value = "受理结束时间")
    private Date slEndTime;//受理结束时间

    @ApiModelProperty(value = "专案组id")
    private String groupId;//专案组id

    @ApiModelProperty(value = "分页参数")
    private int begin;

    @ApiModelProperty(value = "分页参数")
    private int end;

    @ApiModelProperty(value = "排序字段")
    private String orderBy; //排序字段

    @ApiModelProperty(value = "排序规则 desc ")
    private boolean isDesc=false; //排序规则 desc

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getAjmc() {
        return ajmc;
    }

    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    public String getAb() {
        return ab;
    }

    public void setAb(String ab) {
        this.ab = ab;
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

    public String getAjstate() {
        return ajstate;
    }

    public void setAjstate(String ajstate) {
        this.ajstate = ajstate;
    }

    public String getSljsdw() {
        return sljsdw;
    }

    public void setSljsdw(String sljsdw) {
        this.sljsdw = sljsdw;
    }

    public String getFadd() {
        return fadd;
    }

    public void setFadd(String fadd) {
        this.fadd = fadd;
    }

    public Date getSlStartTime() {
        return slStartTime;
    }

    public void setSlStartTime(Date slStartTime) {
        this.slStartTime = slStartTime;
    }

    public Date getSlEndTime() {
        return slEndTime;
    }

    public void setSlEndTime(Date slEndTime) {
        this.slEndTime = slEndTime;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isDesc() {
        return isDesc;
    }

    public void setDesc(boolean desc) {
        isDesc = desc;
    }
}
