package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * 《任务反馈》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "新增任务反馈")
public class TaskFkAddParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "任务ID不能为空")
    @ApiModelProperty(value = "任务ID",required = true)
    private String taskid; //任务ID

    @ApiModelProperty(value = "反馈线索")
    private String fkxs; //反馈线索

    @NotEmpty(message = "创建人不能为空")
    @ApiModelProperty(value = "创建人",required = true)
    private String creator; //创建人

    @NotEmpty(message = "创建人姓名不能为空")
    @ApiModelProperty(value = "创建人姓名",required = true)
    private String createname; //创建人姓名

    @NotEmpty(message = "创建人单位不能为空")
    @ApiModelProperty(value = "创建人单位",required = true)
    private String deparmentcode; //创建人单位

    @ApiModelProperty(value = "反馈附件信息")
    private List<TaskfkFileAddParam> taskfkFileAddParams;

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid;
    }

    public String getFkxs() {
        return fkxs;
    }

    public void setFkxs(String fkxs) {
        this.fkxs = fkxs;
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

    public List<TaskfkFileAddParam> getTaskfkFileAddParams() {
        return taskfkFileAddParams;
    }

    public void setTaskfkFileAddParams(List<TaskfkFileAddParam> taskfkFileAddParams) {
        this.taskfkFileAddParams = taskfkFileAddParams;
    }
}