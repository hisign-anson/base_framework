
package com.hisign.framework.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《催办记录》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "催办记录")
public class CbModel implements Serializable {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "催办ID")
	private String id; //催办ID
	
    @ApiModelProperty(value = "催办时间")
	private Date cbTime; //催办时间
	
    @ApiModelProperty(value = "任务ID")
	private String taskid; //任务ID
	
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
	public CbModel() {
		super();
	}
	 
	/**
	 * @return ID 催办ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 催办ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return CB_TIME 催办时间
	 */
	public Date getCbTime(){
		return this.cbTime;
	}
	/**
	 * @param CB_TIME 催办时间
	 */
	public void setCbTime(Date cbTime){
		this.cbTime = cbTime;
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
