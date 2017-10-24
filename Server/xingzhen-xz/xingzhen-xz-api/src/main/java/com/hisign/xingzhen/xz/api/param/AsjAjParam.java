package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hisign on 2017/10/23.
 */
public class AsjAjParam implements Serializable{

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
}
