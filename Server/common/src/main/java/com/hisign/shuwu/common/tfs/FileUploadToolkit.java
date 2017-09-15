package com.hisign.shuwu.common.tfs;

import com.hisign.shuwu.common.model.UploadFile;

/**
 * 文件上传工具箱接口定义
 * 
 * @author Administrator
 */
public interface FileUploadToolkit {
	/**
	 * 上传文件
	 * 
	 * @param file
	 * @param request
	 */
	public UploadFile upload(UploadFile file) throws FileUploadException;

	/**
	 * 删除文件
	 * 
	 * @param file
	 */
	public void delete(UploadFile file);

}
