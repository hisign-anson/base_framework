package com.hisign.xingzhen.sys.api.param;

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

    @ApiModelProperty("是否组内")
    private boolean isInGroup=true;

    @ApiModelProperty("全局搜索值-app专用")
    private String searchValue;

    @ApiModelProperty("分页参数")
    private int begin;

    @ApiModelProperty("分页参数")
    private int end;

    @ApiModelProperty(value = "排序字段")
    private String orderBy; //排序字段

    @ApiModelProperty(value = "排序规则 desc ")
    private boolean isDesc=false; //排序规则 desc

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

    public boolean isInGroup() {
        return isInGroup;
    }

    public void setInGroup(boolean inGroup) {
        isInGroup = inGroup;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
