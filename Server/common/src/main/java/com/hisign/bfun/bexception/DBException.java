package com.hisign.bfun.bexception;

import com.hisign.bfun.benum.BaseEnum.DBExceptionEnum;

@SuppressWarnings("serial")
public class DBException extends BaseException{

	public DBException() {
		super();
	}

	@SuppressWarnings("rawtypes")
	public DBException(DBExceptionEnum dbExceptionEnum, Class clazz) {
		this.code = dbExceptionEnum.Code();
		this.msg = dbExceptionEnum.Msg();
		this.clazz = clazz;
		this.className = clazz.getName();
	}

	public DBException(DBExceptionEnum dbExceptionEnum) {
		this.code = dbExceptionEnum.Code();
		this.msg = dbExceptionEnum.Msg();
	}

	@SuppressWarnings("rawtypes")
	public DBException(String msg, Class clazz) {
		super(msg, clazz);
	}

	public DBException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DBException(String arg0) {
		super(arg0);
	}

	public DBException(Throwable arg0) {
		super(arg0);
	}
	
	

}
