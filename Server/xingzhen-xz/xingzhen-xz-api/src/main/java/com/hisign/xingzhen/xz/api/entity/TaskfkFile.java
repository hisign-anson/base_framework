
package com.hisign.xingzhen.xz.api.entity;

import java.io.Serializable;
import java.util.*;
import com.hisign.bfun.bannotation.*;
import com.hisign.framework.common.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《任务反馈文件表》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "任务反馈文件表")
@Table(value="t_taskfk_file")
public class TaskfkFile extends BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@PK(value="ID")
    @ApiModelProperty(value = "附件ID")
	private String id; //附件ID
	
	@Column(value="TASKFK_ID")
    @ApiModelProperty(value = "反馈任务ID")
	private String taskfkId; //反馈任务ID
	
	@Column(value="FILE_NAME")
    @ApiModelProperty(value = "新文件名")
	private String fileName; //新文件名
	
	@Column(value="FILE_OLD_NAME")
    @ApiModelProperty(value = "原文件名")
	private String fileOldName; //原文件名
	
	@Column(value="FILE_PATH")
    @ApiModelProperty(value = "文件路径")
	private String filePath; //文件路径
	
	@Column(value="FILE_TYPE")
    @ApiModelProperty(value = "文件类型")
	private String fileType; //文件类型
	
	@Column(value="FILE_SIZE")
    @ApiModelProperty(value = "文件大小 单位K")
	private Double fileSize; //文件大小 单位K
	
	@Column(value="DELETE_FLAG")
    @ApiModelProperty(value = "删除标志")
	private String deleteFlag; //删除标志
	
	@Column(value="CREATOR")
    @ApiModelProperty(value = "创建人")
	private String creator; //创建人
	
	@Column(value="CREATETIME")
    @ApiModelProperty(value = "创建时间")
	private Date createtime; //创建时间
	
    
	/**
	 *默认空构造函数
	 */
	public TaskfkFile() {
		super();
	}
	 
	/**
	 * @return ID 附件ID
	 */
	public String getId(){
		return this.id;
	}
	/**
	 * @param ID 附件ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * @return TASKFK_ID 反馈任务ID
	 */
	public String getTaskfkId(){
		return this.taskfkId;
	}
	/**
	 * @param TASKFK_ID 反馈任务ID
	 */
	public void setTaskfkId(String taskfkId){
		this.taskfkId = taskfkId;
	}
	/**
	 * @return FILE_NAME 新文件名
	 */
	public String getFileName(){
		return this.fileName;
	}
	/**
	 * @param FILE_NAME 新文件名
	 */
	public void setFileName(String fileName){
		this.fileName = fileName;
	}
	/**
	 * @return FILE_OLD_NAME 原文件名
	 */
	public String getFileOldName(){
		return this.fileOldName;
	}
	/**
	 * @param FILE_OLD_NAME 原文件名
	 */
	public void setFileOldName(String fileOldName){
		this.fileOldName = fileOldName;
	}
	/**
	 * @return FILE_PATH 文件路径
	 */
	public String getFilePath(){
		return this.filePath;
	}
	/**
	 * @param FILE_PATH 文件路径
	 */
	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
	/**
	 * @return FILE_TYPE 文件类型
	 */
	public String getFileType(){
		return this.fileType;
	}
	/**
	 * @param FILE_TYPE 文件类型
	 */
	public void setFileType(String fileType){
		this.fileType = fileType;
	}
	/**
	 * @return FILE_SIZE 文件大小 单位K
	 */
	public Double getFileSize(){
		return this.fileSize;
	}
	/**
	 * @param FILE_SIZE 文件大小 单位K
	 */
	public void setFileSize(Double fileSize){
		this.fileSize = fileSize;
	}
	/**
	 * @return DELETE_FLAG 删除标志
	 */
	public String getDeleteFlag(){
		return this.deleteFlag;
	}
	/**
	 * @param DELETE_FLAG 删除标志
	 */
	public void setDeleteFlag(String deleteFlag){
		this.deleteFlag = deleteFlag;
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
	
	public static String getTbName() {
		return "t_taskfk_file";
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("TaskfkFile [")
		.append("id=").append(this.getId())
		.append(",taskfkId=").append(this.getTaskfkId())
		.append(",fileName=").append(this.getFileName())
		.append(",fileOldName=").append(this.getFileOldName())
		.append(",filePath=").append(this.getFilePath())
		.append(",fileType=").append(this.getFileType())
		.append(",fileSize=").append(this.getFileSize())
		.append(",deleteFlag=").append(this.getDeleteFlag())
		.append(",creator=").append(this.getCreator())
		.append(",createtime=").append(this.getCreatetime())
		.append("]");
		return builder.toString();
	}
	
	public static enum TaskfkFileEnum{
		id("ID","附件ID"),
		taskfkId("TASKFK_ID","反馈任务ID"),
		fileName("FILE_NAME","新文件名"),
		fileOldName("FILE_OLD_NAME","原文件名"),
		filePath("FILE_PATH","文件路径"),
		fileType("FILE_TYPE","文件类型"),
		fileSize("FILE_SIZE","文件大小 单位K"),
		deleteFlag("DELETE_FLAG","删除标志"),
		creator("CREATOR","创建人"),
		createtime("CREATETIME","创建时间");
		
		private String fieldName;
		private String remark;
		
		TaskfkFileEnum(String fieldName,String remark){
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
