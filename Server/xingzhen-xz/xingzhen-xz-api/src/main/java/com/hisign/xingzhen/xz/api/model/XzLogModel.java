
package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《日志》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "日志")
public class XzLogModel implements Serializable {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
	private String id; //主键ID
	
    @ApiModelProperty(value = "日志类型（专案组，任务等）")
	private String logType; //日志类型（专案组，任务，登录等）
	
    @ApiModelProperty(value = "日志内容")
	private String content; //日志内容
	
    @ApiModelProperty(value = "日志级别")
	private String logLevel; //日志级别
	
    @ApiModelProperty(value = "创建人")
	private String creator; //创建人
	
    @ApiModelProperty(value = "创建时间")
	private Date createTime; //创建时间
	
    @ApiModelProperty(value = "ip")
	private String ip; //ip
	
    @ApiModelProperty(value = "删除标识")
	private String deleteFlag; //删除标识
	
    @ApiModelProperty(value = "预留字段1")
	private String reserveField1; //预留字段1
	
    @ApiModelProperty(value = "预留字段2")
	private String reserveField2; //预留字段2
	
    @ApiModelProperty(value = "备注")
	private String remark; //备注
	
    
	/**
	 *默认空构造函数
	 */
	public XzLogModel() {
		super();
	}
	 
	/**
	 * @return ID 主键ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 主键ID
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
	 * @param LOG_TYPE 日志类型（专案组，任务等）
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
	 * @param CONTENT 日志内容
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
	 * @param LOG_LEVEL 日志级别
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
	 * @param CREATOR 创建人
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
	 * @param CREATE_TIME 创建时间
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
	 * @param IP ip
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
	 * @param DELETE_FLAG 删除标识
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
	 * @param RESERVE_FIELD1 预留字段1
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
	 * @param RESERVE_FIELD2 预留字段2
	 */
	public void setReserveField2(String reserveField2){
		this.reserveField2 = reserveField2;
	}
	/**
	 * @return REMARK 备注
	 */
	public String getRemark(){
		return this.remark;
	}
	/**
	 * @param REMARK 备注
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
}
