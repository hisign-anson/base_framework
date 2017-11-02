package com.hisign.xingzhen.common.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: 何建辉
 * @Description:
 * @Date: Created in 18:18 2017/11/1
 */
public class BaseParam implements Serializable{

    @ApiModelProperty(value = "分页参数 开始序号")
    private int begin; //开始序号

    @ApiModelProperty(value = "分页参数 结束序号")
    private int end; //结束序号

    @ApiModelProperty(value = "排序字段")
    private String orderBy; //排序字段

    @ApiModelProperty(value = "排序规则 desc ")
    private boolean isDesc=false; //排序规则 desc

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

