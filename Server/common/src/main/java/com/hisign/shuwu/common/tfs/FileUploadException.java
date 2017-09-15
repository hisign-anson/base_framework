package com.hisign.shuwu.common.tfs;

import java.io.PrintWriter;
import java.text.MessageFormat;

/**
 * 
 * @author Administrator
 */
public class FileUploadException extends RuntimeException {
	/** UID */
	private static final long serialVersionUID = -6516492883954885141L;

	/* 错误码 */
	private FileUploadErrorCode errorCode;

	/**
	 * @param message
	 * @param cause
	 */
	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public FileUploadException(String message) {
		super(message);
	}

	/**
	 * 构造方法
	 * 
	 * @param errorCode
	 */
	public FileUploadException(FileUploadErrorCode errorCode) {
		super(errorCode.getDescription());
		this.errorCode = errorCode;
	}

	/**
	 * 构造方法
	 * 
	 * @param errorCode
	 * @param t
	 */
	public FileUploadException(FileUploadErrorCode errorCode, Throwable t) {
		super(errorCode.getDescription(), t);
		this.errorCode = errorCode;
	}

	/**
	 * 构造方法
	 * 
	 * @param errorCode
	 * @param args
	 */
	public FileUploadException(FileUploadErrorCode errorCode, Object... args) {
		super((new MessageFormat(errorCode.getDescription())).format(args));
		this.errorCode = errorCode;
	}

	/**
	 * 构造方法
	 * 
	 * @param errorCode
	 * @param args
	 */
	public FileUploadException(FileUploadErrorCode errorCode, Throwable t,
			Object... args) {
		super((new MessageFormat(errorCode.getDescription())).format(args), t);
		this.errorCode = errorCode;
	}

	/**
	 * Getter method for property <tt>errorCode</tt>.
	 * 
	 * @return property value of errorCode
	 */
	public String getErrorCode() {
		if (errorCode != null) {
			return errorCode.getCode();
		}
		return FileUploadErrorCode.SYSTEM_ERROR_CODE;
	}

	public String getErrorDesc() {
		if (errorCode != null) {
			return getMessage();
		}
		return FileUploadErrorCode.SYSTEM_ERROR_DESC;
	}

	/**
	 * 
	 * @see Throwable#printStackTrace(PrintWriter)
	 */
	@Override
	public void printStackTrace(PrintWriter writer) {
		if (errorCode != null) {
			writer.print("[" + errorCode.getCode() + "]" + getMessage());
		} else {
			writer.print(super.getLocalizedMessage());
		}
		super.printStackTrace(writer);

	}
}
