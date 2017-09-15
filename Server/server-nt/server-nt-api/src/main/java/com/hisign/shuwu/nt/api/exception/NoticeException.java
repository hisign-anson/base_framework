package com.hisign.shuwu.nt.api.exception;

public class NoticeException extends Exception {

	/** **/
	private static final long serialVersionUID = -7766002300466981053L;
	/**
	 * 错误代码
	 */
	private int errorCode;

	public NoticeException()
	{
		super();
	}

	public NoticeException(String message)
	{
		super(message);
	}

	public NoticeException(String message, int errorCode)
	{
		super(message);
		this.errorCode = errorCode;
	}

	public NoticeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public int getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode(int errorCode)
	{
		this.errorCode = errorCode;
	}
}
