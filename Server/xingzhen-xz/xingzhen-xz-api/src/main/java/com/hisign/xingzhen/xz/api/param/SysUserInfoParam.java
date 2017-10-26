package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by hisign on 2017/10/26.
 */
public class SysUserInfoParam implements Serializable{

    @ApiModelProperty("警号")
    private String policeId;

    @ApiModelProperty("机构id")
    private String orgId;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("专案组id")
    private String groupId;

    @ApiModelProperty("分页参数")
    private int begin;

    @ApiModelProperty("分页参数")
    private int end;

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
