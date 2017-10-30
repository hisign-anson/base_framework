
package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《专案组归档记录》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "专案组归档记录")
public class GroupBackupModel implements Serializable {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "归档记录ID")
	private String id; //归档记录ID
	
    @ApiModelProperty(value = "专案组ID")
	private String groupid; //专案组ID

    @ApiModelProperty(value = "专案组名称")
	private String groupName; //专案组名称

    @ApiModelProperty(value = "归档时间")
	private Date backupTime; //归档时间
	
    @ApiModelProperty(value = "归档原因")
	private String backupReason; //归档原因

    @ApiModelProperty(value = "归档原因内容")
	private String backupReasonContent; //归档原因内容

    @ApiModelProperty(value = "创建人")
	private String creator; //创建人

    @ApiModelProperty(value = "创建人姓名")
	private String creatorName; //创建人姓名

    @ApiModelProperty(value = "创建时间")
	private Date createtime; //创建时间
	
    @ApiModelProperty(value = "创建人单位")
	private String deparmentcode; //创建人单位

    @ApiModelProperty(value = "创建人单位名称")
	private String deparmentName; //创建人单位

    @ApiModelProperty(value = "修改时间")
	private Date lastupdatetime; //修改时间
	
    @ApiModelProperty(value = "删除标识")
	private String deleteflag; //删除标识

	@ApiModelProperty(value = "警号")
	private String policeId; //警号
	
    
	/**
	 *默认空构造函数
	 */
	public GroupBackupModel() {
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
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}

	public String getPoliceId() {
		return policeId;
	}

	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getDeparmentName() {
		return deparmentName;
	}

	public void setDeparmentName(String deparmentName) {
		this.deparmentName = deparmentName;
	}

	public String getBackupReasonContent() {
		return backupReasonContent;
	}

	public void setBackupReasonContent(String backupReasonContent) {
		this.backupReasonContent = backupReasonContent;
	}
}
