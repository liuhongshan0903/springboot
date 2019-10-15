package com.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.boot.bean.BmsUser;

/**
 * 
 * 支持myBatis 的服务基类
 * @author liuhs
 *
 */
@Mapper
public interface UserMapper {
    
    public List<BmsUser> findAll();

	public BmsUser findById(String id);

	public BmsUser findByName(String userRealName);
	
	public void insertUser(BmsUser user);
	
	public void updatetUser(BmsUser user);
	
	
    

}
