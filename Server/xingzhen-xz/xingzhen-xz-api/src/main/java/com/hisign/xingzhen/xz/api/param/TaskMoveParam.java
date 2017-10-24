package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 《任务》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务移交")
public class TaskMoveParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务ID",required = true)
    private String id; //任务名称

    @ApiModelProperty(value = "接收人",required = true)
    private String jsr; //接收人

    @ApiModelProperty(value = "创建人",required = true)
    private String creator; //创建人

    @ApiModelProperty(value = "创建人单位",required = true)
    private String deparmentcode; //创建人单位

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsr() {
        return jsr;
    }

    public void setJsr(String jsr) {
        this.jsr = jsr;
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
}