package com.freevice.hw.web.rest.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.freevice.hw.web.common.TestUserRestURIConstants;
import com.freevice.hw.web.common.UserRestURIConstants;
import com.freevice.hw.web.model.Account;
import com.freevice.hw.web.model.Location;
import com.freevice.hw.web.model.User;

public class TestSpringRestUser {
		 
	    public static final String SERVER_URI = "http://localhost:8080/HWWebComponent";
	     
	    public static void main(String args[]){
	         
	    	//System.out.println("***** before testDrop");
	    	//testDropFreeviceDB();
	    	//System.out.println("***** After testDrop");
	  	    System.out.println("***** before testCreateUser");
	        testCreateUser();
	        System.out.println("***** After testCreateUser");
	        System.out.println("***** before testGetUser");
	        //testGetUserById();
	        System.out.println("***** After testGetUser");
	        System.out.println("***** before testUpdateUser");
	        //testUpdateUser();
	        System.out.println("***** after testUpdateUser");
	        System.out.println("***** before testGetUser After Update");
	        //testGetUserById();
	        System.out.println("***** After testGetUser After Update");
	        System.out.println("***** before testGetAllUser");
	        //testGetAllUser();
	        System.out.println("***** after testGetAllUser");
	        System.out.println("***** before testDeleteUserById");
	        //testDeleteUserById();
	        System.out.println("***** after testDeleteUserById");
	        System.out.println("***** before testDeleteAllUser");
	        //testDeleteAllUser();
	        System.out.println("***** after testDeleteAllUser");
	      
	   
	    }
	 
	 /*   private static void testGetAllEmployee() {
	        RestTemplate restTemplate = new RestTemplate();
	        //we can't get List<Employee> because JSON convertor doesn't know the type of
	        //object in the list and hence convert it to default JSON object type LinkedHashMap
	        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+UserRestURIConstants.GET_ALL_EMP, List.class);
	        System.out.println(emps.size());
	        for(LinkedHashMap map : emps){
	            System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
	        }
	    }*/
	 
	/*    private static void testDropFreeviceDB() {
	    	  RestTemplate restTemplate = new RestTemplate();
	    	  restTemplate.delete(SERVER_URI+UserRestURIConstants.DROP_DB);
		      //printUserData(response);
			
		}*/

		private static void testDeleteAllUser() {
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.delete(SERVER_URI+TestUserRestURIConstants.DELETE_ALL_USER);
			
		}

		private static void testUpdateUser() {
			
		 	RestTemplate restTemplate = new RestTemplate();
	        User user = new User();
	        user.setUserId("umahendra_patidar");
	        user.setUserReferenceId("refId1");
	        user.setFirstname("Mahendra Patel Updated");
	        //user.setName("MahendraP");
	        User response = restTemplate.postForObject(SERVER_URI+TestUserRestURIConstants.UPDATE_USER, user, User.class);
	        printUserData(response);
		
		}

		private static void testDeleteUserById() {
			 	RestTemplate restTemplate = new RestTemplate();
		        //User user = new User();
		        //user.setUserId("umahendra_patidar");
		        //user.setUserReferenceId("refId1");
		        //user.setName("Mahendra Patel");
		        //user.setName("MahendraP");
		        restTemplate.delete(SERVER_URI+TestUserRestURIConstants.DELETE_USER_BYID_APPEND+"/"+"umahendra_patidar");
		        //printUserData(response);
			
		}

		private static void testGetAllUser() {
			  RestTemplate restTemplate = new RestTemplate();
		        //we can't get List<Employee> because JSON convertor doesn't know the type of
		        //object in the list and hence convert it to default JSON object type LinkedHashMap
		        List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI+UserRestURIConstants.GET_ALL_USER,List.class);
		        printUsersData(response);
			
		}

		private static void testCreateUser() {
	        RestTemplate restTemplate = new RestTemplate();
	        User user = new User();
	        createDummyUser(user);
	        User response = restTemplate.postForObject(SERVER_URI+UserRestURIConstants.CREATE_USER, user, User.class);
	        printUserData(response);
	    }
	 
	    private static void createDummyUser(User user) {
	    	
	    		user.setUserId("100");
		        user.setUserReferenceId("refId101");
		        user.setFirstname("MahendraP");
		        user.setCreated(new Date());
		        user.setDob(new Date());
		        user.setLastLogin(new Date());
		        user.setEmail("umahendra.solanki@gmail.com");
		        user.setActive(true);
		        Location location = new Location("20.97","23.00");
				user.setLocation(location);
		        user.setPrefLocation(location);
		        List<Account> accounts = new ArrayList<Account>();
		        Account account = new Account();
		        account.setAccountType("internal");
		        account.setAcountId("internalGeneratedId1");
		        account.setPassword("password");
		        accounts.add(account);
		        user.setAccounts(accounts);
		        
			
		}

		private static void testGetUserById() {
	        RestTemplate restTemplate = new RestTemplate();
	        User user = new User();
	        //user.setUserId("umahendra.solanki@gmail.com");
	        //user = restTemplate.postForObject(SERVER_URI+UserRestURIConstants.GET_USER_BY_ID_TEST,user, User.class);
	        user = restTemplate.getForObject(SERVER_URI+TestUserRestURIConstants.GET_USER_BY_ID_APPENDID+"/"+"100", User.class);
	        printUserData(user);
	    }
	 
	/*    private static void testGetDummyEmployee() {
	        RestTemplate restTemplate = new RestTemplate();
	        Employee emp = restTemplate.getForObject(SERVER_URI+UserRestURIConstants.DUMMY_EMP, Employee.class);
	        printEmpData(emp);
	    }*/
	    public static void printUsersData(List<LinkedHashMap> users){
	    	
	    	if(users!=null){
				for(LinkedHashMap<String, Object> map : users){
		            System.out.println("User : userId="+map.get("userId")+", Name="+map.get("firstname"));;
		        }
			}else{
				System.out.println("No user exist----------");
			}
	    }
	    public static void printUserData(User user){
	    	if(user!=null){
	    		System.out.println("UserId="+user.getUserId()+",Name="+user.getFirstname());
	    	}
	    }
	}