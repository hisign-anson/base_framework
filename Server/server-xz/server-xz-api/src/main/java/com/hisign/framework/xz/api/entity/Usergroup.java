
package com.hisign.framework.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.framework.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《人员专案组关联》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "人员专案组关联")
@Table(value="t_usergroup")
public class Usergroup extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@PK(value="ID")
	@ApiModelProperty(value = "人员关联ID")
	private String id; //人员关联ID

	@Column(value="USERID")
	@ApiModelProperty(value = "人员ID")
	private String userid; //人员ID

	@Column(value="JH")
	@ApiModelProperty(value = "警号")
	private String jh; //警号

	@Column(value="GROUPID")
	@ApiModelProperty(value = "专案组ID")
	private String groupid; //专案组ID

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
	public Usergroup() {
		super();
	}
	 
	/**
	 * @return ID 人员关联ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 人员关联ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return USERID 人员ID
	 */
	public String getUserid(){
		return this.userid;
	}
	/**
	 * @param USERID 人员ID
	 */
	public void setUserid(String userid){
		this.userid = userid;
	}
	/**
	 * @return JH 警号
	 */
	public String getJh(){
		return this.jh;
	}
	/**
	 * @param JH 警号
	 */
	public void setJh(String jh){
		this.jh = jh;
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
		return "t_usergroup";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Usergroup [")
		.append("id=").append(this.getId())
		.append(",userid=").append(this.getUserid())
		.append(",jh=").append(this.getJh())
		.append(",groupid=").append(this.getGroupid())
		.append(",creator=").append(this.getCreator())
		.append(",createtime=").append(this.getCreatetime())
		.append(",deparmentcode=").append(this.getDeparmentcode())
		.append(",lastupdatetime=").append(this.getLastupdatetime())
		.append(",deleteflag=").append(this.getDeleteflag())
		.append("]");
		return builder.toString();
	}
	
	public static enum UsergroupEnum{
		id("ID","人员关联ID"),
		userid("USERID","人员ID"),
		jh("JH","警号"),
		groupid("GROUPID","专案组ID"),
		creator("CREATOR","创建人"),
		createtime("CREATETIME","创建时间"),
		deparmentcode("DEPARMENTCODE","创建人单位"),
		lastupdatetime("LASTUPDATETIME","修改时间"),
		deleteflag("DELETEFLAG","删除标识");
		
		private String fieldName;
		private String remark;
		
		UsergroupEnum(String fieldName,String remark){
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
