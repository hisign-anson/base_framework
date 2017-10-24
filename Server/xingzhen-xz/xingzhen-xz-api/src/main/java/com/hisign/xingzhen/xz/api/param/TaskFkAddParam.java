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
}