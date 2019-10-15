package com.boot.service;

import java.util.List;

import com.boot.bean.BmsUser;

public interface UserService {
	
	public List<BmsUser> findAllUser();

	public BmsUser findById(String userId);

	public BmsUser findByName(String userRealName);
	
	public void insertUser(BmsUser user);
	
	public void testTransaction(BmsUser user);
	
	//public void updateUser(String userId);

}
