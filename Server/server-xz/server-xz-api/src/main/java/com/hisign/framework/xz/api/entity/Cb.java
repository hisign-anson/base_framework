
package com.hisign.framework.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;

/**
 * 《催办记录》 实体
 * @author xhh
 *
 */
@Table(value="t_cb")
public class Cb implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PK(value="ID")
	private String id; //催办ID
	
	@Column(value="CB_TIME")
	private Date cbTime; //催办时间
	
	@Column(value="TASKID")
	private String taskid; //任务ID
	
	@Column(value="CREATOR")
	private String creator; //创建人
	
	@Column(value="CREATETIME")
	private Date createtime; //创建时间
	
	@Column(value="DEPARMENTCODE")
	private String deparmentcode; //创建人单位
	
	@Column(value="LASTUPDATETIME")
	private Date lastupdatetime; //修改时间
	
	@Column(value="DELETEFLAG")
	private String deleteflag; //删除标识
	
    
	/**
	 *默认空构造函数
	 */
	public Cb() {
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
	
	public static String getTbName() {
		return "t_cb";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Cb [")
		.append("id=").append(this.getId())
		.append(",cbTime=").append(this.getCbTime())
		.append(",taskid=").append(this.getTaskid())
		.append(",creator=").append(this.getCreator())
		.append(",createtime=").append(this.getCreatetime())
		.append(",deparmentcode=").append(this.getDeparmentcode())
		.append(",lastupdatetime=").append(this.getLastupdatetime())
		.append(",deleteflag=").append(this.getDeleteflag())
		.append("]");
		return builder.toString();
	}
	
	public static enum CbEnum{
		id("ID","催办ID"),
		cbTime("CB_TIME","催办时间"),
		taskid("TASKID","任务ID"),
		creator("CREATOR","创建人"),
		createtime("CREATETIME","创建时间"),
		deparmentcode("DEPARMENTCODE","创建人单位"),
		lastupdatetime("LASTUPDATETIME","修改时间"),
		deleteflag("DELETEFLAG","删除标识");
		
		private String fieldName;
		private String remark;
		
		CbEnum(String fieldName,String remark){
			this.fieldName = fieldName;
			this.remark = remark;
		}
		
		public String get(){
			return this.fieldName;
		}
		
		public String getRemark(){
			return this.remark;
		}
	}
}
