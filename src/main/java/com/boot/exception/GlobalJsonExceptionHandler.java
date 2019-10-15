package com.boot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalJsonExceptionHandler {
 
	/*@ExceptionHandler(value = Exception.class)
	@ResponseBody// 返回json数据
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception	{
 
		ErrorInfo<String> r = new ErrorInfo<>();// 异常信息封装类
		r.setMessage(e.getMessage());
		r.setCode("403");
		r.setData("无权访问");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}*/
}
