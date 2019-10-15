package com.boot.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.boot.bean.BmsUser;
import com.boot.mapper.UserMapper;
import com.boot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
//@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<BmsUser> findAllUser() {
		//分页插件: 查询第1页，每页3行    下面两行之间不能有其他代码
        Page<BmsUser> page =PageHelper.startPage(3, 7);  
		List<BmsUser> list = userMapper.findAll();
		
		Page<BmsUser> page1 = (Page<BmsUser>) list;
		 System.out.println("page1"+page1);
		 //数据表的总行数  
        page.getTotal();  
        //分页查询结果的总行数  
        page.size();  
        //开始页数
        page.getStartRow();
        //每页多少条
        page.getPageSize();
        
        System.out.println( "每页："+page.getPageSize()+"条，从  "+ page.getStartRow()+"条开始。共有数据："+ page.getTotal()+"条，当前查询页数返回："+ page.size()+"条"); 
        //第一个User对象，参考list，序号0是第一个元素，依此类推  
        System.out.println("=== page.get(0).getLocationid()===!"+ page.get(0).getLocationid()); 
       // list.add(page);
		return list;
	}
	
	
	public BmsUser findById(String id){
		BmsUser user = userMapper.findById(id);
		return user;
	}

	public BmsUser findByName(String userRealName) {
		BmsUser user = userMapper.findByName(userRealName);
		return user;
	}
	
	/**
	 * 新增用户时候   添加事物控制
	 * 
	 * <prop key="save*">PROPAGATION_REQUIRED</prop>      

     	<prop key="find*">PROPAGATION_REQUIRED,readOnly</prop>      

     	<prop key="delete*">PROPAGATION_REQUIRED</prop>      

     	<prop key="update*">PROPAGATION_REQUIRED</prop>      

     	<prop key="*">PROPAGATION_REQUIRED</prop>   
     	  
	 * 默认的话在抛出Exception.class异常的时候，就会触发方法中所有数据库操作回滚，当然这指的是增、删、改。
	 */
	@Transactional(propagation = Propagation.REQUIRED,
	isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void insertUser(BmsUser user) {
		 userMapper.insertUser(user);
	}



	/**
	 * @Transactional注解内的所有dba操作，统一事物
	 * 添加事物可以保证事物一致性 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
	public void testTransaction(BmsUser user) {
		//成功
		userMapper.insertUser(user);
		//失败
		user.setBmsStatus("222");
		user.setId("D423FEDAC3AA4C4F8C0D77C93B54C1B3");
		userMapper.updatetUser(user);
		
	}

}
