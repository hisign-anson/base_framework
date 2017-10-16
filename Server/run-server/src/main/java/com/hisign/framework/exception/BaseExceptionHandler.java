package com.hisign.framework.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hisign.bfun.bexception.BusinessException;
import com.hisign.framework.common.model.JsonResult;
import com.hisign.framework.common.util.JsonResultUtil;

@ControllerAdvice
public class BaseExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public JsonResult exceptionHandler(BusinessException e,HttpServletResponse response) {
		StringWriter sw = new StringWriter(); 
        e.getOrgException().printStackTrace(new PrintWriter(sw, true)); 
		logger.error(sw.toString());
		JsonResult result = JsonResultUtil.error(e.getMsg());
		return result;
	}

}
