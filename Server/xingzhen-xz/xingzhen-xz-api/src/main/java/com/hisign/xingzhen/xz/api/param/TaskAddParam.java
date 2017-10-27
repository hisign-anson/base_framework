package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 《任务》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务新增")
public class TaskAddParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务名称")
    private String taskName; //任务名称

    @NotEmpty(message = "任务内容不能为空")
    @ApiModelProperty(value = "任务内容",required = true)
    private String taskContent; //任务内容

    @NotEmpty(message = "专案组不能为空")
    @ApiModelProperty(value = "专案组ID",required = true)
    private String groupid; //专案组ID

    @ApiModelProperty(value = "接收人联系方式")
    private String jsrLxfs; //接收联系方式

    @NotEmpty(message = "接收人不能为空")
    @ApiModelProperty(value = "接收人",required = true)
    private String jsr; //接收人

    @NotEmpty(message = "接收人姓名不能为空")
    @ApiModelProperty(value = "接收人姓名",required = true)
    private String jsrname; //接收人

    @NotNull(message = "反馈截止时间不能为空")
    @ApiModelProperty(value = "反馈截止时间",required = true)
    private Date fkjzTime; //反馈截止时间

    @NotEmpty(message = "创建人不能为空")
    @ApiModelProperty(value = "创建人",required = true)
    private String creator; //创建人

    @ApiModelProperty(value = "发起人联系方式")
    private String fqrLxfs; //发起人联系方式

    @NotEmpty(message = "创建人姓名不能为空")
    @ApiModelProperty(value = "创建人姓名",required = true)
    private String createname; //创建人

    @NotEmpty(message = "创建人单位不能为空")
    @ApiModelProperty(value = "创建人单位",required = true)
    private String deparmentcode; //创建人单位

    @NotEmpty(message = "创建人单位名称不能为空")
    @ApiModelProperty(value = "创建人单位名称",required = true)
    private String deparmentname; //创建人单位名称

    @ApiModelProperty(value = "补充任务ID")
    private String bcrwid; //补充任务ID

    @ApiModelProperty(value = "反馈ID")
    private String fkid; //反馈ID

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getJsrLxfs() {
        return jsrLxfs;
    }

    public void setJsrLxfs(String jsrLxfs) {
        this.jsrLxfs = jsrLxfs;
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

    public Date getFkjzTime() {
        return fkjzTime;
    }

    public void setFkjzTime(Date fkjzTime) {
        this.fkjzTime = fkjzTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getFqrLxfs() {
        return fqrLxfs;
    }

    public void setFqrLxfs(String fqrLxfs) {
        this.fqrLxfs = fqrLxfs;
    }

    public String getCreatename() {
        return createname;
    }

    public void setCreatename(String createname) {
        this.createname = createname;
    }

    public String getDeparmentcode() {
        return deparmentcode;
    }

    public void setDeparmentcode(String deparmentcode) {
        this.deparmentcode = deparmentcode;
    }

    public String getDeparmentname() {
        return deparmentname;
    }

    public void setDeparmentname(String deparmentname) {
        this.deparmentname = deparmentname;
    }

    public String getBcrwid() {
        return bcrwid;
    }

    public void setBcrwid(String bcrwid) {
        this.bcrwid = bcrwid;
    }

    public String getFkid() {
        return fkid;
    }

    public void setFkid(String fkid) {
        this.fkid = fkid;
    }
}