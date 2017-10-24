
package com.hisign.xingzhen.xz.api.param;

import com.hisign.bfun.bannotation.Column;
import com.hisign.bfun.bannotation.Table;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 《任务反馈文件表》 实体
 * @author 何建辉
 *
 */
@ApiModel(value = "任务反馈文件表")
@Table(value="t_taskfk_file")
public class TaskfkFileAddParam{
	private static final long serialVersionUID = 1L;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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
