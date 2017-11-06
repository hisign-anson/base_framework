package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * Created by hisign on 2017/10/23.
 */
public class GroupBackupParam implements Serializable{

    @ApiModelProperty(value = "专案组ID")
    @NotEmpty(message = "专案组ID不能为空")
    private String groupid; //专案组ID

    @ApiModelProperty(value = "归档原因")
    private String backupReason; //归档原因

    @ApiModelProperty(value = "归档状态 0撤销归档 1归档")
    private String backupStatus; //归档状态

    @ApiModelProperty(value = "创建人")
    @NotEmpty(message = "归档人不能为空")
    private String creator; //创建人

    @ApiModelProperty(value = "创建人单位")
    @NotEmpty(message = "归档人单位不能为空")
    private String deparmentcode; //创建人单位

    @ApiModelProperty(value = "警号")
    private String policeId; //警号

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getBackupReason() {
        return backupReason;
    }

    public void setBackupReason(String backupReason) {
        this.backupReason = backupReason;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDeparmentcode() {
        return deparmentcode;
    }

    public void setDeparmentcode(String deparmentcode) {
        this.deparmentcode = deparmentcode;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getBackupStatus() {
        return backupStatus;
    }

    public void setBackupStatus(String backupStatus) {
        this.backupStatus = backupStatus;
    }

    @Override
    public String toString() {
        return "GroupBackupParam{" +
                "groupid='" + groupid + '\'' +
                ", backupReason='" + backupReason + '\'' +
                ", backupStatus='" + backupStatus + '\'' +
                ", creator='" + creator + '\'' +
                ", deparmentcode='" + deparmentcode + '\'' +
                ", policeId='" + policeId + '\'' +
                '}';
    }
}
