
package com.hisign.framework.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;

/**
 * 《专案组》 实体
 * @author xhh
 *
 */
@Table(value="t_group")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PK(value="ID")
	private String id; //专案组ID
	
	@Column(value="PGROUPID")
	private String pgroupid; //父专案组ID
	
	@Column(value="GROUPNUM")
	private String groupnum; //专案组编号
	
	@Column(value="GROUPNAME")
	private String groupname; //专案组名称
	
	@Column(value="GROUPTYPE")
	private String grouptype; //专案组类别
	
	@Column(value="BACKUP_STATU")
	private String backupStatu; //归档状态
	
	@Column(value="BACKUP_TIME")
	private Date backupTime; //归档时间
	
	@Column(value="BACKUP_REASON")
	private String backupReason; //归档原因
	
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
	public Group() {
		super();
	}
	 
	/**
	 * @return ID 专案组ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 专案组ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return PGROUPID 父专案组ID
	 */
	public String getPgroupid(){
		return this.pgroupid;
	}
	/**
	 * @param PGROUPID 父专案组ID
	 */
	public void setPgroupid(String pgroupid){
		this.pgroupid = pgroupid;
	}
	/**
	 * @return GROUPNUM 专案组编号
	 */
	public String getGroupnum(){
		return this.groupnum;
	}
	/**
	 * @param GROUPNUM 专案组编号
	 */
	public void setGroupnum(String groupnum){
		this.groupnum = groupnum;
	}
	/**
	 * @return GROUPNAME 专案组名称
	 */
	public String getGroupname(){
		return this.groupname;
	}
	/**
	 * @param GROUPNAME 专案组名称
	 */
	public void setGroupname(String groupname){
		this.groupname = groupname;
	}
	/**
	 * @return GROUPTYPE 专案组类别
	 */
	public String getGrouptype(){
		return this.grouptype;
	}
	/**
	 * @param GROUPTYPE 专案组类别
	 */
	public void setGrouptype(String grouptype){
		this.grouptype = grouptype;
	}
	/**
	 * @return BACKUP_STATU 归档状态
	 */
	public String getBackupStatu(){
		return this.backupStatu;
	}
	/**
	 * @param BACKUP_STATU 归档状态
	 */
	public void setBackupStatu(String backupStatu){
		this.backupStatu = backupStatu;
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
		return "t_group";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Group [")
		.append("id=").append(this.getId())
		.append(",pgroupid=").append(this.getPgroupid())
		.append(",groupnum=").append(this.getGroupnum())
		.append(",groupname=").append(this.getGroupname())
		.append(",grouptype=").append(this.getGrouptype())
		.append(",backupStatu=").append(this.getBackupStatu())
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
	
	public static enum GroupEnum{
		id("ID","专案组ID"),
		pgroupid("PGROUPID","父专案组ID"),
		groupnum("GROUPNUM","专案组编号"),
		groupname("GROUPNAME","专案组名称"),
		grouptype("GROUPTYPE","专案组类别"),
		backupStatu("BACKUP_STATU","归档状态"),
		backupTime("BACKUP_TIME","归档时间"),
		backupReason("BACKUP_REASON","归档原因"),
		creator("CREATOR","创建人"),
		createtime("CREATETIME","创建时间"),
		deparmentcode("DEPARMENTCODE","创建人单位"),
		lastupdatetime("LASTUPDATETIME","修改时间"),
		deleteflag("DELETEFLAG","删除标识");
		
		private String fieldName;
		private String remark;
		
		GroupEnum(String fieldName,String remark){
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
