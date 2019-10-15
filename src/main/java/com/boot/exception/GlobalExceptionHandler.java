package com.boot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {// 此处仅用作测试
	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
 
		ModelAndView mav = new ModelAndView();
	/*	if (e instanceof UnauthorizedException) {// 判断异常类型
			mav.addObject("exception", "无权访问!");// 根据异常类型，返回具体的展示信息
		} else {
			mav.addObject("exception", "系统错误，请联系管理员@chhliu!");
		}*/
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("/error");// 异常信息展示到哪个页面，此处指定在error.html页面中进行展示
		return mav;
	}
}
