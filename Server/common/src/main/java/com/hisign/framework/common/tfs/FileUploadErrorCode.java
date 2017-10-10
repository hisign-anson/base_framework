package com.hisign.framework.common.tfs;

/**
 * 错误码实现接口
 * 
 * @author Administrator
 */
public interface FileUploadErrorCode {
	static final String SYSTEM_ERROR_CODE = "SYSTEM_ERROR";
	static final String SYSTEM_ERROR_DESC = "系统异常，请与系统管理员联系";

	static final String SAVE_UPLOAD_FILE_FAIL = "SAVE_UPLOAD_FILE_FAIL";
	static final String SAVE_UPLOAD_FILE_FAIL_DESC = "保存文件失败";

	/**
	 * 返回错误码描述
	 * 
	 * @return
	 */
	String getDescription();

	/**
	 * 返回错误码
	 * 
	 * @return
	 */
	String getCode();
}
