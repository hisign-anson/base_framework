
package com.hisign.xingzhen.xz.api.entity;

import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.PK;
import com.hisign.bfun.bannotation.Table;
import com.hisign.xingzhen.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 《日志》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "日志")
@Table(value="t_xz_log")
public class XzLog extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PK(value="ID")
    @ApiModelProperty(value = "主键ID")
	private String id; //主键ID
	
	@Column(value="LOG_TYPE")
    @ApiModelProperty(value = "日志类型（专案组，任务等）")
	private String logType; //日志类型（专案组，任务等）
	
	@Column(value="CONTENT")
    @ApiModelProperty(value = "日志内容")
	private String content; //日志内容
	
	@Column(value="LOG_LEVEL")
    @ApiModelProperty(value = "日志级别")
	private String logLevel; //日志级别
	
	@Column(value="CREATOR")
    @ApiModelProperty(value = "创建人")
	private String creator; //创建人
	
	@Column(value="CREATE_TIME")
    @ApiModelProperty(value = "创建时间")
	private Date createTime; //创建时间
	
	@Column(value="IP")
    @ApiModelProperty(value = "ip")
	private String ip; //ip
	
	@Column(value="DELETE_FLAG")
    @ApiModelProperty(value = "删除标识")
	private String deleteFlag; //删除标识
	
	@Column(value="RESERVE_FIELD1")
    @ApiModelProperty(value = "预留字段1")
	private String reserveField1; //预留字段1
	
	@Column(value="RESERVE_FIELD2")
    @ApiModelProperty(value = "预留字段2")
	private String reserveField2; //预留字段2
	

	/**
	 *默认空构造函数
	 */
	public XzLog() {
		super();
	}

	/**
	 *构造函数
	 */
	public XzLog(String ip,String logType,String content,String creator,Date createTime,String reserveField1) {
		this.ip = ip;
		this.id = UUID.randomUUID().toString();
		this.content = content;
		this.logType = logType;
		this.creator = creator;
		this.reserveField1 = reserveField1;
		this.createTime = createTime;
	}

	/**
	 * @return ID 主键ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param id 主键ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return LOG_TYPE 日志类型（专案组，任务等）
	 */
	public String getLogType(){
		return this.logType;
	}
	/**
	 * @param logType 日志类型（专案组，任务等）
	 */
	public void setLogType(String logType){
		this.logType = logType;
	}
	/**
	 * @return CONTENT 日志内容
	 */
	public String getContent(){
		return this.content;
	}
	/**
	 * @param content 日志内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * @return LOG_LEVEL 日志级别
	 */
	public String getLogLevel(){
		return this.logLevel;
	}
	/**
	 * @param logLevel 日志级别
	 */
	public void setLogLevel(String logLevel){
		this.logLevel = logLevel;
	}
	/**
	 * @return CREATOR 创建人
	 */
	public String getCreator(){
		return this.creator;
	}
	/**
	 * @param creator 创建人
	 */
	public void setCreator(String creator){
		this.creator = creator;
	}
	/**
	 * @return CREATE_TIME 创建时间
	 */
	public Date getCreateTime(){
		return this.createTime;
	}
	/**
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 * @return IP ip
	 */
	public String getIp(){
		return this.ip;
	}
	/**
	 * @param ip ip
	 */
	public void setIp(String ip){
		this.ip = ip;
	}
	/**
	 * @return DELETE_FLAG 删除标识
	 */
	public String getDeleteFlag(){
		return this.deleteFlag;
	}
	/**
	 * @param deleteFlag 删除标识
	 */
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	/**
	 * @return RESERVE_FIELD1 预留字段1
	 */
	public String getReserveField1(){
		return this.reserveField1;
	}
	/**
	 * @param reserveField1 预留字段1
	 */
	public void setReserveField1(String reserveField1){
		this.reserveField1 = reserveField1;
	}
	/**
	 * @return RESERVE_FIELD2 预留字段2
	 */
	public String getReserveField2(){
		return this.reserveField2;
	}
	/**
	 * @param reserveField2 预留字段2
	 */
	public void setReserveField2(String reserveField2){
		this.reserveField2 = reserveField2;
	}

	public static String getTbName() {
		return "t_xz_log";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("XzLog [")
		.append("id=").append(this.getId())
		.append(",logType=").append(this.getLogType())
		.append(",content=").append(this.getContent())
		.append(",logLevel=").append(this.getLogLevel())
		.append(",creator=").append(this.getCreator())
		.append(",createTime=").append(this.getCreateTime())
		.append(",ip=").append(this.getIp())
		.append(",deleteFlag=").append(this.getDeleteFlag())
		.append(",reserveField1=").append(this.getReserveField1())
		.append(",reserveField2=").append(this.getReserveField2())
		.append("]");
		return builder.toString();
	}
	
	public static enum XzLogEnum{
		id("ID","主键ID"),
		logType("LOG_TYPE","日志类型（专案组，任务等）"),
		content("CONTENT","日志内容"),
		logLevel("LOG_LEVEL","日志级别"),
		creator("CREATOR","创建人"),
		createTime("CREATE_TIME","创建时间"),
		ip("IP","ip"),
		deleteFlag("DELETE_FLAG","删除标识"),
		reserveField1("RESERVE_FIELD1","预留字段1"),
		reserveField2("RESERVE_FIELD2","预留字段2");

		private String fieldName;
		private String remark;
		
		XzLogEnum(String fieldName,String remark){
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
