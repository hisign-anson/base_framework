
package com.hisign.framework.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.framework.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《任务》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "任务")
@Table(value="t_task")
public class Task extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@PK(value="ID")
	@ApiModelProperty(value = "任务ID")
	private String id; //任务ID

	@Column(value="TASK_NO")
	@ApiModelProperty(value = "")
	private String taskNo; //

	@Column(value="TASK_NAME")
	@ApiModelProperty(value = "任务名称")
	private String taskName; //任务名称

	@Column(value="TASK_CONTENT")
	@ApiModelProperty(value = "任务内容")
	private String taskContent; //任务内容

	@Column(value="GROUPID")
	@ApiModelProperty(value = "专案组ID")
	private String groupid; //专案组ID

	@Column(value="PGROUPID")
	@ApiModelProperty(value = "父专案组ID")
	private String pgroupid; //父专案组ID

	@Column(value="BCRWID")
	@ApiModelProperty(value = "补充任务ID")
	private String bcrwid; //补充任务ID

	@Column(value="YJRWID")
	@ApiModelProperty(value = "移交父任务ID")
	private String yjrwid; //移交父任务ID

	@Column(value="FQR")
	@ApiModelProperty(value = "发起人")
	private String fqr; //发起人

	@Column(value="JSR_LXFS")
	@ApiModelProperty(value = "接收联系方式")
	private String jsrLxfs; //接收联系方式

	@Column(value="JSR")
	@ApiModelProperty(value = "接收人")
	private String jsr; //接收人

	@Column(value="FQ_TIME")
	@ApiModelProperty(value = "发起时间")
	private Date fqTime; //发起时间

	@Column(value="FKJZ_TIME")
	@ApiModelProperty(value = "反馈截止时间")
	private Date fkjzTime; //反馈截止时间

	@Column(value="LXFS")
	@ApiModelProperty(value = "联系方式")
	private String lxfs; //联系方式

	@Column(value="FKZT")
	@ApiModelProperty(value = "反馈状态")
	private String fkzt; //反馈状态

	@Column(value="FK_TIME")
	@ApiModelProperty(value = "反馈时间")
	private Date fkTime; //反馈时间

	@Column(value="CBZT")
	@ApiModelProperty(value = "催办状态")
	private String cbzt; //催办状态

	@Column(value="QSZT")
	@ApiModelProperty(value = "签收状态")
	private String qszt; //签收状态

	@Column(value="QS_TIME")
	@ApiModelProperty(value = "签收时间")
	private Date qsTime; //签收时间

	@Column(value="YJZT")
	@ApiModelProperty(value = "移交状态")
	private String yjzt; //移交状态

	@Column(value="YJ_TIME")
	@ApiModelProperty(value = "移交时间")
	private Date yjTime; //移交时间

	@Column(value="QRZT")
	@ApiModelProperty(value = "确认状态")
	private String qrzt; //确认状态

	@Column(value="QR_TIME")
	@ApiModelProperty(value = "确认时间")
	private Date qrTime; //确认时间

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
	public Task() {
		super();
	}
	 
	/**
	 * @return ID 任务ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 任务ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return TASK_NO 
	 */
	public String getTaskNo(){
		return this.taskNo;
	}
	/**
	 * @param TASK_NO 
	 */
	public void setTaskNo(String taskNo){
		this.taskNo = taskNo;
	}
	/**
	 * @return TASK_NAME 任务名称
	 */
	public String getTaskName(){
		return this.taskName;
	}
	/**
	 * @param TASK_NAME 任务名称
	 */
	public void setTaskName(String taskName){
		this.taskName = taskName;
	}
	/**
	 * @return TASK_CONTENT 任务内容
	 */
	public String getTaskContent(){
		return this.taskContent;
	}
	/**
	 * @param TASK_CONTENT 任务内容
	 */
	public void setTaskContent(String taskContent){
		this.taskContent = taskContent;
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
	 * @return BCRWID 补充任务ID
	 */
	public String getBcrwid(){
		return this.bcrwid;
	}
	/**
	 * @param BCRWID 补充任务ID
	 */
	public void setBcrwid(String bcrwid){
		this.bcrwid = bcrwid;
	}
	/**
	 * @return YJRWID 移交父任务ID
	 */
	public String getYjrwid(){
		return this.yjrwid;
	}
	/**
	 * @param YJRWID 移交父任务ID
	 */
	public void setYjrwid(String yjrwid){
		this.yjrwid = yjrwid;
	}
	/**
	 * @return FQR 发起人
	 */
	public String getFqr(){
		return this.fqr;
	}
	/**
	 * @param FQR 发起人
	 */
	public void setFqr(String fqr){
		this.fqr = fqr;
	}
	/**
	 * @return JSR_LXFS 接收联系方式
	 */
	public String getJsrLxfs(){
		return this.jsrLxfs;
	}
	/**
	 * @param JSR_LXFS 接收联系方式
	 */
	public void setJsrLxfs(String jsrLxfs){
		this.jsrLxfs = jsrLxfs;
	}
	/**
	 * @return JSR 接收人
	 */
	public String getJsr(){
		return this.jsr;
	}
	/**
	 * @param JSR 接收人
	 */
	public void setJsr(String jsr){
		this.jsr = jsr;
	}
	/**
	 * @return FQ_TIME 发起时间
	 */
	public Date getFqTime(){
		return this.fqTime;
	}
	/**
	 * @param FQ_TIME 发起时间
	 */
	public void setFqTime(Date fqTime){
		this.fqTime = fqTime;
	}
	/**
	 * @return FKJZ_TIME 反馈截止时间
	 */
	public Date getFkjzTime(){
		return this.fkjzTime;
	}
	/**
	 * @param FKJZ_TIME 反馈截止时间
	 */
	public void setFkjzTime(Date fkjzTime){
		this.fkjzTime = fkjzTime;
	}
	/**
	 * @return LXFS 联系方式
	 */
	public String getLxfs(){
		return this.lxfs;
	}
	/**
	 * @param LXFS 联系方式
	 */
	public void setLxfs(String lxfs){
		this.lxfs = lxfs;
	}
	/**
	 * @return FKZT 反馈状态
	 */
	public String getFkzt(){
		return this.fkzt;
	}
	/**
	 * @param FKZT 反馈状态
	 */
	public void setFkzt(String fkzt){
		this.fkzt = fkzt;
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
	 * @return CBZT 催办状态
	 */
	public String getCbzt(){
		return this.cbzt;
	}
	/**
	 * @param CBZT 催办状态
	 */
	public void setCbzt(String cbzt){
		this.cbzt = cbzt;
	}
	/**
	 * @return QSZT 签收状态
	 */
	public String getQszt(){
		return this.qszt;
	}
	/**
	 * @param QSZT 签收状态
	 */
	public void setQszt(String qszt){
		this.qszt = qszt;
	}
	/**
	 * @return QS_TIME 签收时间
	 */
	public Date getQsTime(){
		return this.qsTime;
	}
	/**
	 * @param QS_TIME 签收时间
	 */
	public void setQsTime(Date qsTime){
		this.qsTime = qsTime;
	}
	/**
	 * @return YJZT 移交状态
	 */
	public String getYjzt(){
		return this.yjzt;
	}
	/**
	 * @param YJZT 移交状态
	 */
	public void setYjzt(String yjzt){
		this.yjzt = yjzt;
	}
	/**
	 * @return YJ_TIME 移交时间
	 */
	public Date getYjTime(){
		return this.yjTime;
	}
	/**
	 * @param YJ_TIME 移交时间
	 */
	public void setYjTime(Date yjTime){
		this.yjTime = yjTime;
	}
	/**
	 * @return QRZT 确认状态
	 */
	public String getQrzt(){
		return this.qrzt;
	}
	/**
	 * @param QRZT 确认状态
	 */
	public void setQrzt(String qrzt){
		this.qrzt = qrzt;
	}
	/**
	 * @return QR_TIME 确认时间
	 */
	public Date getQrTime(){
		return this.qrTime;
	}
	/**
	 * @param QR_TIME 确认时间
	 */
	public void setQrTime(Date qrTime){
		this.qrTime = qrTime;
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
		return "t_task";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Task [")
		.append("id=").append(this.getId())
		.append(",taskNo=").append(this.getTaskNo())
		.append(",taskName=").append(this.getTaskName())
		.append(",taskContent=").append(this.getTaskContent())
		.append(",groupid=").append(this.getGroupid())
		.append(",pgroupid=").append(this.getPgroupid())
		.append(",bcrwid=").append(this.getBcrwid())
		.append(",yjrwid=").append(this.getYjrwid())
		.append(",fqr=").append(this.getFqr())
		.append(",jsrLxfs=").append(this.getJsrLxfs())
		.append(",jsr=").append(this.getJsr())
		.append(",fqTime=").append(this.getFqTime())
		.append(",fkjzTime=").append(this.getFkjzTime())
		.append(",lxfs=").append(this.getLxfs())
		.append(",fkzt=").append(this.getFkzt())
		.append(",fkTime=").append(this.getFkTime())
		.append(",cbzt=").append(this.getCbzt())
		.append(",qszt=").append(this.getQszt())
		.append(",qsTime=").append(this.getQsTime())
		.append(",yjzt=").append(this.getYjzt())
		.append(",yjTime=").append(this.getYjTime())
		.append(",qrzt=").append(this.getQrzt())
		.append(",qrTime=").append(this.getQrTime())
		.append(",creator=").append(this.getCreator())
		.append(",createtime=").append(this.getCreatetime())
		.append(",deparmentcode=").append(this.getDeparmentcode())
		.append(",lastupdatetime=").append(this.getLastupdatetime())
		.append(",deleteflag=").append(this.getDeleteflag())
		.append("]");
		return builder.toString();
	}
	
	public static enum TaskEnum{
		id("ID","任务ID"),
		taskNo("TASK_NO",""),
		taskName("TASK_NAME","任务名称"),
		taskContent("TASK_CONTENT","任务内容"),
		groupid("GROUPID","专案组ID"),
		pgroupid("PGROUPID","父专案组ID"),
		bcrwid("BCRWID","补充任务ID"),
		yjrwid("YJRWID","移交父任务ID"),
		fqr("FQR","发起人"),
		jsrLxfs("JSR_LXFS","接收联系方式"),
		jsr("JSR","接收人"),
		fqTime("FQ_TIME","发起时间"),
		fkjzTime("FKJZ_TIME","反馈截止时间"),
		lxfs("LXFS","联系方式"),
		fkzt("FKZT","反馈状态"),
		fkTime("FK_TIME","反馈时间"),
		cbzt("CBZT","催办状态"),
		qszt("QSZT","签收状态"),
		qsTime("QS_TIME","签收时间"),
		yjzt("YJZT","移交状态"),
		yjTime("YJ_TIME","移交时间"),
		qrzt("QRZT","确认状态"),
		qrTime("QR_TIME","确认时间"),
		creator("CREATOR","创建人"),
		createtime("CREATETIME","创建时间"),
		deparmentcode("DEPARMENTCODE","创建人单位"),
		lastupdatetime("LASTUPDATETIME","修改时间"),
		deleteflag("DELETEFLAG","删除标识");
		
		private String fieldName;
		private String remark;
		
		TaskEnum(String fieldName,String remark){
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
