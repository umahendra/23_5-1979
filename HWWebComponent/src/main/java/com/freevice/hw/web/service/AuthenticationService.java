package com.freevice.hw.web.service;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;

import com.freevice.hw.web.model.Account;
import com.freevice.hw.web.model.User;
import com.freevice.hw.web.mongo.dao.UserDao;

public class AuthenticationService {

	// @Autowired
	private UserDao userDao;

	public AuthenticationService() {
		System.out.println("AuthenticationService called");
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean authenticate(String authCredentials) {
		boolean authenticationStatus = false;
		if (null == authCredentials){
			return false;
		}
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String userName = tokenizer.nextToken();
		final String password = tokenizer.nextToken();
		 // Issue a token for the user
		String accessKey = issueToken(userName);
		//user.resetAccessKey(accessKey);
    	//account.set(token);
		// Return the token on the response
     //return httpServletResponse.ok(token).build();
		// we have fixed the userName and password as admin
		// call some UserService/LDAP here
		//user.resetUserName(userName);
		User dbUser = userDao.findUserById(userName);
		if(dbUser!=null){
		List<Account> accounts = dbUser.getAccounts();

		for (Account account : accounts) {
			if (userName.equals(account.getAcountId()) && password.equals(account.getPassword())) {
				//user.resetAccount(account);
				authenticationStatus = true;
				break;
				}
			}
		}
		return authenticationStatus;
	}
	
	private String issueToken(String firstname) {
		Random random = new SecureRandom();
		System.out.println("User name is:"+firstname);
		String token = new BigInteger(130, random).toString(32);
	    return token;
	}
}
