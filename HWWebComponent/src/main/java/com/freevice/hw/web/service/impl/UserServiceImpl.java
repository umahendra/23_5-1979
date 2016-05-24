package com.freevice.hw.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.freevice.hw.web.model.User;
import com.freevice.hw.web.mongo.dao.UserDao;
import com.freevice.hw.web.service.UserService;

public class UserServiceImpl implements UserService {

	
	//@Autowired
	private UserDao userDao;
	
	
	public UserServiceImpl() {
		System.out.println("UserServiceImpl called"); 
	}
	

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void createUser(User user) {
		// TODO Auto-generated method stub
		 userDao.createUser(user);
	}

	public User findUserById(String userId) {
		// TODO Auto-generated method stub
		return userDao.findUserById(userId);
	}



	public void deleteUserById(String userId){
		// TODO Auto-generated method stub
		 userDao.deleteUserById(userId);
		
	}


	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public String forgotUserPassword(String userId) {
		// TODO Auto-generated method stub
		return null;
	}


	public void deleteAllUser() {
		userDao.deleteAllUser();
		
	}
	
}
