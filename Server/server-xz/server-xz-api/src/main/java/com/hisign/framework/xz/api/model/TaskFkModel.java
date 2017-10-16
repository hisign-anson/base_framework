
package com.hisign.framework.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《任务反馈》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "任务反馈")
public class TaskFkModel implements Serializable {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务反馈ID")
	private String id; //任务反馈ID
	
    @ApiModelProperty(value = "任务ID")
	private String taskid; //任务ID
	
    @ApiModelProperty(value = "反馈追加任务ID")
	private String fkzjTaskid; //反馈追加任务ID
	
    @ApiModelProperty(value = "反馈线索")
	private String fkxs; //反馈线索
	
    @ApiModelProperty(value = "反馈人")
	private String fkr; //反馈人
	
    @ApiModelProperty(value = "反馈时间")
	private Date fkTime; //反馈时间
	
    @ApiModelProperty(value = "备注")
	private String bz; //备注
	
    @ApiModelProperty(value = "创建人")
	private String creator; //创建人
	
    @ApiModelProperty(value = "创建时间")
	private Date createtime; //创建时间
	
    @ApiModelProperty(value = "创建人单位")
	private String deparmentcode; //创建人单位
	
    @ApiModelProperty(value = "修改时间")
	private Date lastupdatetime; //修改时间
	
    @ApiModelProperty(value = "删除标识")
	private String deleteflag; //删除标识
	
    
	/**
	 *默认空构造函数
	 */
	public TaskFkModel() {
		super();
	}
	 
	/**
	 * @return ID 任务反馈ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 任务反馈ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return TASKID 任务ID
	 */
	public String getTaskid(){
		return this.taskid;
	}
	/**
	 * @param TASKID 任务ID
	 */
	public void setTaskid(String taskid){
		this.taskid = taskid;
	}
	/**
	 * @return FKZJ_TASKID 反馈追加任务ID
	 */
	public String getFkzjTaskid(){
		return this.fkzjTaskid;
	}
	/**
	 * @param FKZJ_TASKID 反馈追加任务ID
	 */
	public void setFkzjTaskid(String fkzjTaskid){
		this.fkzjTaskid = fkzjTaskid;
	}
	/**
	 * @return FKXS 反馈线索
	 */
	public String getFkxs(){
		return this.fkxs;
	}
	/**
	 * @param FKXS 反馈线索
	 */
	public void setFkxs(String fkxs){
		this.fkxs = fkxs;
	}
	/**
	 * @return FKR 反馈人
	 */
	public String getFkr(){
		return this.fkr;
	}
	/**
	 * @param FKR 反馈人
	 */
	public void setFkr(String fkr){
		this.fkr = fkr;
	}
	/**
	 * @return FK_TIME 反馈时间
	 */
	public Date getFkTime(){
		return this.fkTime;
	}
	/**
	 * @param FK_TIME 反馈时间
	 */
	public void setFkTime(Date fkTime){
		this.fkTime = fkTime;
	}
	/**
	 * @return BZ 备注
	 */
	public String getBz(){
		return this.bz;
	}
	/**
	 * @param BZ 备注
	 */
	public void setBz(String bz){
		this.bz = bz;
	}
	/**
	 * @return CREATOR 创建人
	 */
	public String getCreator(){
		return this.creator;
	}
	/**
	 * @param CREATOR 创建人
	 */
	public void setCreator(String creator){
		this.creator = creator;
	}
	/**
	 * @return CREATETIME 创建时间
	 */
	public Date getCreatetime(){
		return this.createtime;
	}
	/**
	 * @param CREATETIME 创建时间
	 */
	public void setCreatetime(Date createtime){
		this.createtime = createtime;
	}
	/**
	 * @return DEPARMENTCODE 创建人单位
	 */
	public String getDeparmentcode(){
		return this.deparmentcode;
	}
	/**
	 * @param DEPARMENTCODE 创建人单位
	 */
	public void setDeparmentcode(String deparmentcode){
		this.deparmentcode = deparmentcode;
	}
	/**
	 * @return LASTUPDATETIME 修改时间
	 */
	public Date getLastupdatetime(){
		return this.lastupdatetime;
	}
	/**
	 * @param LASTUPDATETIME 修改时间
	 */
	public void setLastupdatetime(Date lastupdatetime){
		this.lastupdatetime = lastupdatetime;
	}
	/**
	 * @return DELETEFLAG 删除标识
	 */
	public String getDeleteflag(){
		return this.deleteflag;
	}
	/**
	 * @param DELETEFLAG 删除标识
	 */
	public void setDeleteflag(String deleteflag){
		this.deleteflag = deleteflag;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
}
