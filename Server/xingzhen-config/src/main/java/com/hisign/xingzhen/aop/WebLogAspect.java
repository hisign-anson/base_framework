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
	private long startTimie;
	private String url;
	private StringBuffer sb = new StringBuffer();

	@Pointcut("execution(public * com.hisign.xingzhen.*.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		startTimie = System.currentTimeMillis();
		// 接收到请求，记录请求内容
		logger.debug("\n\n---------------"+joinPoint.getSignature().getDeclaringTypeName()+"-->start---------------");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		url = request.getRequestURL().toString();
		sb.append("URL : " + url);
		sb.append("HTTP_METHOD : " + request.getMethod());
		sb.append("IP : " + request.getRemoteAddr());
		sb.append("CLASS_METHOD : "
				+ joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		sb.append("ARGS : " + Arrays.toString(joinPoint.getArgs()));
	}

	@After("webLog()")
	public void doAfter(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		if (result!=null) {
			sb.append("返回结果："+result);
			sb.append("运行方法："+url);
			sb.append("消耗时间："+(System.currentTimeMillis()-startTimie)+"毫秒");
		}
		logger.debug(sb.toString());
	}
	
	@Around(value = "webLog()")
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
		Object result = pj.proceed();// result的值就是被拦截方法的返回值
		this.result = result;
		return result;
	}
}
