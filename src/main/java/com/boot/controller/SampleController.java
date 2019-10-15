package com.boot.controller;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;  
/**
 * 捕获异常类
 * @author yu
 *
 */
@Controller  
public class SampleController {    
    //用来手动记录日志    
    private static final Logger log = LoggerFactory.getLogger(SampleController.class);     
    //触发除0异常    
    @GetMapping("/test1")    
    public void test1() {    
        int i=1/0;      
    }    
    //触发空指针异常    
    @GetMapping("/test2")    
    public void test2()  {    
        String a=null;    
        a.length();     
    }    
    
    
    //触发除0异常    
    @PostMapping("/test1")    
    public void test11() {    
        int i=1/0;      
    }    
    //触发空指针异常    
    @PostMapping("/test2")    
    public void test22()  {    
        String a=null;    
        a.length();     
    } 
    //捕获除0异常    
    @ExceptionHandler(ArithmeticException.class)    
    public void exception1(ArithmeticException e){    
        System.out.println("处理除0异常");    
        //继续抛出异常，才能被logback的error级别日志捕获    
        throw e;    
    }  
    
    
    //捕获空指针异常    
    @ExceptionHandler(NullPointerException.class)    
    public String exception2(NullPointerException e){    
        System.out.println("处理空指针异常");    
        //手动将异常写入logback的error级别日志    
        log.error("空指针异常",e);    
        return "/error/null.html";    
    }    
} 