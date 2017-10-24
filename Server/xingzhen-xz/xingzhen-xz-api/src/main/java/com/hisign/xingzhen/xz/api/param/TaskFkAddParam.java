package com.hisign.xingzhen.xz.api.param;

import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 《任务反馈》 实体
 * @author 刘玉兰
 *
 */
@ApiModel(value = "任务反馈")
@Table(value="t_task_fk")
public class TaskFkAddParam implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(value="TASKID")
    @ApiModelProperty(value = "任务ID")
    private String taskid; //任务ID

    @Column(value="FKXS")
    @ApiModelProperty(value = "反馈线索")
    private String fkxs; //反馈线索

    @Column(value="CREATOR")
    @ApiModelProperty(value = "创建人")
    private String creator; //创建人

    @Column(value="DEPARMENTCODE")
    @ApiModelProperty(value = "创建人单位")
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