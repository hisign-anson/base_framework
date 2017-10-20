
package com.hisign.xingzhen.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《专案组》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "专案组")
@Table(value="t_group")
public class Group extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@PK(value="ID")
	@ApiModelProperty(value = "专案组ID")
	private String id; //专案组ID

	@Column(value="PGROUPID")
	@ApiModelProperty(value = "父专案组ID")
	private String pgroupid; //父专案组ID

	@Column(value="GROUPNUM")
	@ApiModelProperty(value = "专案组编号")
	private String groupnum; //专案组编号

	@Column(value="GROUPNAME")
	@ApiModelProperty(value = "专案组名称")
	private String groupname; //专案组名称

	@Column(value="GROUPTYPE")
	@ApiModelProperty(value = "专案组类别")
	private String grouptype; //专案组类别

	@Column(value="BACKUP_STATU")
	@ApiModelProperty(value = "归档状态")
	private String backupStatu; //归档状态

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

	//-------------------------------------- 返回字段
	@ApiModelProperty(value = "返回字段-成员数")
	private int num;//成员数

	@ApiModelProperty(value = "返回字段-涉及案件数")
	private int caseNum;//涉及案件数


	//--------------------------------------- 接收字段
	@ApiModelProperty(value = "接收字段-关联案件")
	private String ajbh;//关联案件

	@ApiModelProperty(value = "接收字段-人员名称")
	private String userId;//人员名称

	@ApiModelProperty(value = "接收字段-是否是父专案组")
	private boolean isParent;//是否是父专案组


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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(int caseNum) {
		this.caseNum = caseNum;
	}

	public String getAjbh() {
		return ajbh;
	}

	public void setAjbh(String ajbh) {
		this.ajbh = ajbh;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
