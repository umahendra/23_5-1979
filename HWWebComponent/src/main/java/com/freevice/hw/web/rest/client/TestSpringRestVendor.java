package com.freevice.hw.web.rest.client;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.freevice.hw.web.common.VendorRestURIConstants;
import com.freevice.hw.web.model.User;

public class TestSpringRestVendor {
		 
	    public static final String SERVER_URI = "http://localhost:8080/HWWebComponent";
	     
	    public static void main(String args[]){
	         
	    	//System.out.println("***** before testDrop");
	    	//testDropFreeviceDB();
	    	//System.out.println("***** After testDrop");
	  	    System.out.println("***** before testCreateUser");
	        testCreateVendor();
	        System.out.println("***** After testCreateUser");
	        System.out.println("***** before testGetUser");
	        testGetVendor();
	        System.out.println("***** After testGetUser");
	        System.out.println("***** before testGetUser");
	        //testGetAllEmployee();
	        System.out.println("***** after testGetUser");
	    }
	 
	 /*   private static void testGetAllEmployee() {
	        RestTemplate restTemplate = new RestTemplate();
	        //we can't get List<Employee> because JSON convertor doesn't know the type of
	        //object in the list and hence convert it to default JSON object type LinkedHashMap
	        List<LinkedHashMap> emps = restTemplate.getForObject(SERVER_URI+VendorRestURIConstants.GET_ALL_EMP, List.class);
	        System.out.println(emps.size());
	        for(LinkedHashMap map : emps){
	            System.out.println("ID="+map.get("id")+",Name="+map.get("name")+",CreatedDate="+map.get("createdDate"));;
	        }
	    }*/
	 
	  /*  private static void testDropFreeviceDB() {
	    	  RestTemplate restTemplate = new RestTemplate();
	    	  restTemplate.delete(SERVER_URI+VendorRestURIConstants.DROP_DB);
		      //printUserData(response);
			
		}*/

		private static void testGetAllEmployee() {
			  RestTemplate restTemplate = new RestTemplate();
		        //we can't get List<Employee> because JSON convertor doesn't know the type of
		        //object in the list and hence convert it to default JSON object type LinkedHashMap
		        List<LinkedHashMap> response = restTemplate.getForObject(SERVER_URI+VendorRestURIConstants.GET_ALL_VENDOR,List.class);
		        printUsersData(response);
			
		}

		private static void testCreateVendor() {
	        RestTemplate restTemplate = new RestTemplate();
	        User user = new User();
	        //user.setUserId("mahendra.solanki@gmail.com");
	        user.setUserReferenceId("refId1");
	        //user.setName("Mahendra Patel");
	        user.setFirstname("Mahendra");
	        User response = restTemplate.postForObject(SERVER_URI+VendorRestURIConstants.CREATE_VENDOR, user, User.class);
	        printUserData(response);
	    }
	 
	    private static void testGetVendor() {
	        RestTemplate restTemplate = new RestTemplate();
	        User user = new User();
	        //user.setUserId("umahendra.solanki@gmail.com");
	        //user = restTemplate.postForObject(SERVER_URI+VendorRestURIConstants.GET_USER_BY_ID_TEST,user, User.class);
	        user = restTemplate.getForObject(SERVER_URI+VendorRestURIConstants.GET_VENDOR_BY_ID+"/"+"mahendra", User.class);
	        printUserData(user);
	    }
	 
	/*    private static void testGetDummyEmployee() {
	        RestTemplate restTemplate = new RestTemplate();
	        Employee emp = restTemplate.getForObject(SERVER_URI+VendorRestURIConstants.DUMMY_EMP, Employee.class);
	        printEmpData(emp);
	    }*/
	    public static void printUsersData(List<LinkedHashMap> users){
	    	
	    	/*for (User user : users) {
	    		System.out.println("UserId="+user.getUserId()+",Name="+user.getName());
			}*/
	       // System.out.println("UserId="+user.getUserId()+",Name="+user.getName());
	    }
	    public static void printUserData(User user){
	        System.out.println("UserId="+user.getUserId()+",Name="+user.getFirstname());
	    }
	}