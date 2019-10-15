package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.BmsUser;
import com.boot.service.UserService;

/**
 * mybatis 查询数据库 控制类
 * @RestController自动返回的是json格式数据
 * 
 */
@RestController
public class BmsUserController {
	
	@Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<BmsUser> list(){
        List<BmsUser> list = userService.findAllUser();
        return list;
    }
    
    @RequestMapping("/findById")
    public BmsUser findById(@RequestBody BmsUser dto){
    	String id = dto.getId();
		System.out.println("======!"+id);
        BmsUser user = userService.findById(id);
        return user;
    }
    
    
    @RequestMapping("/findByName")
    public BmsUser findByName(@RequestBody BmsUser dto){
    	String userRealName = dto.getUserRealName();
		System.out.println("======!"+userRealName);
        BmsUser user = userService.findByName(userRealName);
        return user;
    }
    
    
    
    @RequestMapping("/saveUser")
    public void saveUser(@RequestBody BmsUser dto){
    	String userRealName = dto.getUserRealName();
		System.out.println("======!"+userRealName);
         userService.insertUser(dto);
    }
    
    
    
    @RequestMapping("/testTransaction")
    public void testTransaction(@RequestBody BmsUser dto){
    	String userRealName = dto.getUserRealName();
		System.out.println("======!"+userRealName);
         userService.testTransaction(dto);
    }

}
