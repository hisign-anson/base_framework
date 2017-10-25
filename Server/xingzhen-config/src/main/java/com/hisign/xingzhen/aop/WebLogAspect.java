package com.hisign.xingzhen.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
public class WebLogAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private Object result;

	@Pointcut("execution(public * com.hisign.xingzhen.*.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {

		// 接收到请求，记录请求内容
		logger.debug("\n\n---------------"+joinPoint.getSignature().getDeclaringTypeName()+"-->start---------------");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		logger.debug("URL : " + request.getRequestURL().toString());
		logger.debug("HTTP_METHOD : " + request.getMethod());
		logger.debug("IP : " + request.getRemoteAddr());
		logger.debug("CLASS_METHOD : "
				+ joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.debug("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		// 获取所有参数方法一：
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			System.out
					.println(paraName + ": " + request.getParameter(paraName));
		}
	}

	@After("webLog()")
	public void doAfter(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		if (result!=null) {
			logger.debug("\n\n返回结果："+result);
			logger.debug("\n\n");
		}
		logger.debug("\n\n---------------"+joinPoint.getSignature().getDeclaringTypeName()+"-->end---------------");
	}
	
	@Around(value = "webLog()")
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
		Object result = pj.proceed();// result的值就是被拦截方法的返回值
		this.result = result;
		return result;
	}
}
