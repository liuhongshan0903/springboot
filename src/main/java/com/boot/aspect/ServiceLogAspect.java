package com.boot.aspect;

import java.util.Arrays;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;

import org.aspectj.lang.annotation.AfterReturning;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;

import org.aspectj.lang.annotation.Pointcut;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.core.annotation.Order;

import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestContextHolder;

import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 
 * 实现Web层的日志切面
 * @author liuhs
 * @version v.0.1
 * 
 * 注解说明：
 * @Aspect 切面
 * @component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
 * 需要@Order(i)注解来标识切面的优先级。i的值越小，优先级越高。
 */

@Aspect
@Component
@Order(-5)
public class ServiceLogAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	long  time = 0;
	
	/**
	 * 定义切点
	 */
	@Pointcut("execution(public * com.boot.service.serviceImpl..*.*(..))")
	public void serviceLog() {
	}

	/**
	 * 定义切点的切入时机
	 * @param joinPoint
	 */
	@Before("serviceLog()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("=====before=======serviceLog====doBefore===");
		//ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		//HttpServletRequest request = attributes.getRequest();
		// 记录下请求开始时间
		time = System.currentTimeMillis();
		logger.info("=====steart time : " + time);
	}

	@AfterReturning("serviceLog()")
	public void doAfterReturning(JoinPoint joinPoint) {
		long  endTime = System.currentTimeMillis();
		logger.info("=====end time : " + endTime);
		logger.info("=====cost : " + (endTime-time));
		logger.info("=====after=====serviceLog====doAfter==");
	}

}