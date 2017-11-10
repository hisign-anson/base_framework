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
	private ThreadLocal<StringBuffer> sb = new ThreadLocal<StringBuffer>();

	@Pointcut("execution(public * com.hisign.xingzhen.*.controller..*.*(..))")
	public void webLog() {
	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {
		startTimie = System.currentTimeMillis();
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		// 记录下请求内容
		url = request.getRequestURL().toString();
		StringBuffer stringBuffer = sb.get();
		stringBuffer.append("\r\n[start]");
		stringBuffer.append("\r\n请求地址 : " + url);
		stringBuffer.append("\r\n请求方法 : " + request.getMethod());
		stringBuffer.append("\r\n请求IP : " + request.getRemoteAddr());
		stringBuffer.append("\r\n目标方法 : "
				+ joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		stringBuffer.append("\r\n请求参数 : " + Arrays.toString(joinPoint.getArgs()));

		sb.set(stringBuffer);
	}

	@After("webLog()")
	public void doAfter(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		StringBuffer stringBuffer = sb.get();
		if (result!=null) {
			stringBuffer.append("\r\n返回结果："+result);
			stringBuffer.append("\r\n运行方法："+url);
			stringBuffer.append("\r\n消耗时间："+(System.currentTimeMillis()-startTimie)+"毫秒");
			stringBuffer.append("\r\n[end]\r\n");
		}
		logger.debug(stringBuffer.toString());
	}
	
	@Around(value = "webLog()")
	public Object doAround(ProceedingJoinPoint pj) throws Throwable {
		Object result = pj.proceed();// result的值就是被拦截方法的返回值
		this.result = result;
		return result;
	}
}
