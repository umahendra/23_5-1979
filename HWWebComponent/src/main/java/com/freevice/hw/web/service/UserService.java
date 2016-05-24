package com.freevice.hw.web.service;

import java.util.List;

import com.freevice.hw.web.model.User;

public interface UserService {

	void createUser(User user);

	User findUserById(String userId);

	List<User> findAllUser();
	
	void deleteUserById(String userId);
	
	String forgotUserPassword(String userId);

	User updateUser(User user);

	void deleteAllUser();
	
}
