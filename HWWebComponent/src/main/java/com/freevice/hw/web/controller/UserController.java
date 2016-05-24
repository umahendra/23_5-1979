package com.freevice.hw.web.controller;
//http://www.technicalkeeda.com/mongodb/how-to-implement-mongodb-crud-operations-using-spring-data - Reference
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.freevice.hw.web.common.UserRestURIConstants;
import com.freevice.hw.web.model.User;
import com.freevice.hw.web.service.UserService;
import com.freevice.hw.web.service.impl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserService userServiceImpl ;

	public UserController(){
		System.out.println("UserController called");
	}
	public UserService getUserDao() {
		return userServiceImpl;
	}

	public void setUserDao(UserService userDao) {
		this.userServiceImpl = userDao;
	}
	
	@RequestMapping(value = UserRestURIConstants.GET_USER_BY_ID, method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody User getUserById(@PathVariable("userId") String userId) {
		
		System.out.println("called UserController getUserById");
		
		return userServiceImpl.findUserById(userId);
	

	}
	@RequestMapping(value = UserRestURIConstants.GET_ALL_USER, method = RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody List<User> getAllUser() {
		System.out.println("called UserController getAllUser");
		
		return userServiceImpl.findAllUser();
	
	}
		
	
	
	@RequestMapping(value = UserRestURIConstants.CREATE_USER, method = RequestMethod.POST,headers="Accept=application/json")
	public @ResponseBody User createUser(@RequestBody User user) {
		System.out.println("called UserController create user");
		userServiceImpl.createUser(user);
		return user;
	}
	
	@RequestMapping(value = UserRestURIConstants.UPDATE_USER, method = RequestMethod.POST,headers="Accept=application/json")
	public @ResponseBody User updateUser(@RequestBody User user) {
		System.out.println("called UserController updateUser");
		userServiceImpl.updateUser(user);
		return user;
	}
	
	@RequestMapping(value = UserRestURIConstants.FORGOT_USER_PASSWORD, method = RequestMethod.PUT,headers="Accept=application/json")
	public @ResponseBody User forgotUserPassword(@RequestBody User user) {
		System.out.println("called UserController forgotpassword");
		userServiceImpl.createUser(user);
		return user;
	}
	@RequestMapping(value = UserRestURIConstants.DELETE_USER_BY_ID, method = RequestMethod.DELETE,headers="Accept=application/json")
	public @ResponseBody void deleteUserById(@PathVariable("userId") String userId) {
		System.out.println("called UserController deleteUserById");
		userServiceImpl.deleteUserById(userId);
	}
	@RequestMapping(value = UserRestURIConstants.DELETE_ALL_USER, method = RequestMethod.DELETE,headers="Accept=application/json")
	public @ResponseBody void deleteAllUser() {
		System.out.println("called UserController deleteAllUser");
		userServiceImpl.deleteAllUser();
	}
}
