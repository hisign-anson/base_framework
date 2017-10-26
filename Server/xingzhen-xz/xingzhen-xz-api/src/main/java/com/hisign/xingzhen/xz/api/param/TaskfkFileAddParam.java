
package com.hisign.xingzhen.xz.api.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 《任务反馈文件表》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "任务反馈文件表")
public class TaskfkFileAddParam implements Serializable {
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "新文件名",required = true)
	private String fileName; //新文件名

    @ApiModelProperty(value = "原文件名",required = true)
	private String fileOldName; //原文件名

    @ApiModelProperty(value = "文件路径",required = true)
	private String filePath; //文件路径

    @ApiModelProperty(value = "文件类型",required = true)
	private String fileType; //文件类型

    @ApiModelProperty(value = "文件大小 单位K",required = true)
	private Double fileSize; //文件大小 单位K

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileOldName() {
        return fileOldName;
    }

    public void setFileOldName(String fileOldName) {
        this.fileOldName = fileOldName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Double getFileSize() {
        return fileSize;
    }

    public void setFileSize(Double fileSize) {
        this.fileSize = fileSize;
    }
}
