package com.freevice.hw.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



public class User implements Serializable {

		
	@Id
	private String userId;
	//String firstname;
	String lastname;
	String email;
	String mobile;
	String gender;
	Date lastLogin;
	Date created;
	Location prefLocation;
	Location location;
	List<String> roles;
	List<Account> accounts;
	
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}


	
	public String getFistname() {
		return fistname;
	}

	public void setFistname(String fistname) {
		this.fistname = fistname;
	}

	

	public Location getPrefLocation() {
		return prefLocation;
	}

	public void setPrefLocation(Location prefLocation) {
		this.prefLocation = prefLocation;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	boolean active;
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDatOfCreation() {
		return datOfCreation;
	}

	public void setDatOfCreation(Date datOfCreation) {
		this.datOfCreation = datOfCreation;
	}

	public String getFirstname() {
		return fistname;
	}

	public void setFirstname(String name) {
		this.fistname = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	private Date dob;
	
	private Date datOfCreation;

	private String fistname;

	private String userReferenceId;
	
	public String getUserReferenceId() {
		return userReferenceId;
	}

	public void setUserReferenceId(String userReferenceId) {
		this.userReferenceId = userReferenceId;
	}

	private String password;
	
	private String userType;
	
	
}
