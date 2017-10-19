
package com.hisign.xingzhen.xz.api.model;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;
import java.util.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《任务反馈文件表》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "任务反馈文件表")
public class TaskfkFileModel implements Serializable {

	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "附件ID")
	private String id; //附件ID
	
    @ApiModelProperty(value = "反馈任务ID")
	private String taskfkId; //反馈任务ID
	
    @ApiModelProperty(value = "新文件名")
	private String fileName; //新文件名
	
    @ApiModelProperty(value = "原文件名")
	private String fileOldName; //原文件名
	
    @ApiModelProperty(value = "文件路径")
	private String filePath; //文件路径
	
    @ApiModelProperty(value = "文件类型")
	private String fileType; //文件类型
	
    @ApiModelProperty(value = "文件大小 单位K")
	private Double fileSize; //文件大小 单位K
	
    @ApiModelProperty(value = "删除标志")
	private String deleteFlag; //删除标志
	
    @ApiModelProperty(value = "创建人")
	private String creator; //创建人
	
    @ApiModelProperty(value = "创建时间")
	private Date createtime; //创建时间
	
    
	/**
	 *默认空构造函数
	 */
	public TaskfkFileModel() {
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
	
	@Override
	public String toString(){
		return JSON.toJSONString(this);
	}
}
