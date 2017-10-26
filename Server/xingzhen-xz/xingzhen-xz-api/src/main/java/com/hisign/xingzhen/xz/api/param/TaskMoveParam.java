package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * 《任务》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务移交")
public class TaskMoveParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "任务ID不能为空")
    @ApiModelProperty(value = "任务ID",required = true)
    private String id; //任务ID

    @NotEmpty(message = "接收人不能为空")
    @ApiModelProperty(value = "接收人",required = true)
    private String jsr; //接收人

    @NotEmpty(message = "接收人姓名不能为空")
    @ApiModelProperty(value = "接收人姓名",required = true)
    private String jsrname; //接收人

    @ApiModelProperty(value = "接收人联系方式")
    private String jsrLxfs; //接收人

    @NotEmpty(message = "创建人不能为空")
    @ApiModelProperty(value = "创建人",required = true)
    private String creator; //创建人

    @NotEmpty(message = "创建人姓名不能为空")
    @ApiModelProperty(value = "创建人姓名",required = true)
    private String createname; //创建人

    @NotEmpty(message = "创建人单位不能为空")
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

    public String getJsrname() {
        return jsrname;
    }

    public void setJsrname(String jsrname) {
        this.jsrname = jsrname;
    }

    public String getJsrLxfs() {
        return jsrLxfs;
    }

    public void setJsrLxfs(String jsrLxfs) {
        this.jsrLxfs = jsrLxfs;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
}