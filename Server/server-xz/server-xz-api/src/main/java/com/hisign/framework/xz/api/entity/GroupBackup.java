
package com.hisign.framework.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.framework.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《专案组归档记录》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "专案组归档记录")
@Table(value="t_group_backup")
public class GroupBackup extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@PK(value="ID")
	@ApiModelProperty(value = "归档记录ID")
	private String id; //归档记录ID

	@Column(value="GROUPID")
	@ApiModelProperty(value = "专案组ID")
	private String groupid; //专案组ID

	@Column(value="BACKUP_TIME")
	@ApiModelProperty(value = "归档时间")
	private Date backupTime; //归档时间

	@Column(value="BACKUP_REASON")
	@ApiModelProperty(value = "归档原因")
	private String backupReason; //归档原因

	@Column(value="CREATOR")
	@ApiModelProperty(value = "创建人")
	private String creator; //创建人

	@Column(value="CREATETIME")
	@ApiModelProperty(value = "创建时间")
	private Date createtime; //创建时间

	@Column(value="DEPARMENTCODE")
	@ApiModelProperty(value = "创建人单位")
	private String deparmentcode; //创建人单位

	@Column(value="LASTUPDATETIME")
	@ApiModelProperty(value = "修改时间")
	private Date lastupdatetime; //修改时间

	@Column(value="DELETEFLAG")
	@ApiModelProperty(value = "删除标识")
	private String deleteflag; //删除标识
	
    
	/**
	 *默认空构造函数
	 */
	public GroupBackup() {
		super();
	}
	 
	/**
	 * @return ID 归档记录ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 归档记录ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return GROUPID 专案组ID
	 */
	public String getGroupid(){
		return this.groupid;
	}
	/**
	 * @param GROUPID 专案组ID
	 */
	public void setGroupid(String groupid){
		this.groupid = groupid;
	}
	/**
	 * @return BACKUP_TIME 归档时间
	 */
	public Date getBackupTime(){
		return this.backupTime;
	}
	/**
	 * @param BACKUP_TIME 归档时间
	 */
	public void setBackupTime(Date backupTime){
		this.backupTime = backupTime;
	}
	/**
	 * @return BACKUP_REASON 归档原因
	 */
	public String getBackupReason(){
		return this.backupReason;
	}
	/**
	 * @param BACKUP_REASON 归档原因
	 */
	public void setBackupReason(String backupReason){
		this.backupReason = backupReason;
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
		return "t_group_backup";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("GroupBackup [")
		.append("id=").append(this.getId())
		.append(",groupid=").append(this.getGroupid())
		.append(",backupTime=").append(this.getBackupTime())
		.append(",backupReason=").append(this.getBackupReason())
		.append(",creator=").append(this.getCreator())
		.append(",createtime=").append(this.getCreatetime())
		.append(",deparmentcode=").append(this.getDeparmentcode())
		.append(",lastupdatetime=").append(this.getLastupdatetime())
		.append(",deleteflag=").append(this.getDeleteflag())
		.append("]");
		return builder.toString();
	}
	
	public static enum GroupBackupEnum{
		id("ID","归档记录ID"),
		groupid("GROUPID","专案组ID"),
		backupTime("BACKUP_TIME","归档时间"),
		backupReason("BACKUP_REASON","归档原因"),
		creator("CREATOR","创建人"),
		createtime("CREATETIME","创建时间"),
		deparmentcode("DEPARMENTCODE","创建人单位"),
		lastupdatetime("LASTUPDATETIME","修改时间"),
		deleteflag("DELETEFLAG","删除标识");
		
		private String fieldName;
		private String remark;
		
		GroupBackupEnum(String fieldName,String remark){
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
