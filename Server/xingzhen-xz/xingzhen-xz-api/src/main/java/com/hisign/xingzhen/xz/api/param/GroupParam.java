package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by hisign on 2017/10/23.
 */
public class GroupParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前登陆人id")
    private String userId; //当前登陆人id

    @ApiModelProperty(value = "专案组名称")
    private String groupname; //专案组名称

    @ApiModelProperty(value = "专案组编号")
    private String groupnum; //专案组编号

    @ApiModelProperty(value = "创建人id")
    private String creator; //创建人id

    @ApiModelProperty(value = "创建开始时间")
    private Date startTime;//创建开始时间

    @ApiModelProperty(value = "创建结束时间")
    private Date endTime;

    @ApiModelProperty(value = "人员名称")
    private String memberId;//人员ID

    @ApiModelProperty(value = "所属单位")
    private String deparmentcode; //所属单位

    @ApiModelProperty(value = "关联案件编号")
    private String ajbh;//关联案件编号

    @ApiModelProperty(value = "归档状态")
    private String backupStatu; //归档状态

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public String getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(String groupnum) {
        this.groupnum = groupnum;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDeparmentcode() {
        return deparmentcode;
    }

    public void setDeparmentcode(String deparmentcode) {
        this.deparmentcode = deparmentcode;
    }

    public String getAjbh() {
        return ajbh;
    }

    public void setAjbh(String ajbh) {
        this.ajbh = ajbh;
    }

    public String getBackupStatu() {
        return backupStatu;
    }

    public void setBackupStatu(String backupStatu) {
        this.backupStatu = backupStatu;
    }
}
