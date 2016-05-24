package com.freevice.hw.web.mongo.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.freevice.hw.web.model.User;
import com.mongodb.WriteResult;




public class UserDao {

	 private static final String COLLECTION = "users";

	 //@Autowired
	 private MongoTemplate mongoTemplate;
	 
	 public UserDao(){
		 System.out.println("UserDao called");
	 }
	 
	 public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void createUser(User user) {
		  if (user != null) {
		   this.mongoTemplate.insert(user, COLLECTION);
		  }
		 }

		 public User findUserById(String userId) {
		  Query query = new Query(Criteria.where("userId").is(userId));
		  return this.mongoTemplate.findOne(query, User.class, COLLECTION);
		 }

	 public void deleteUserById(String userId) {

		  Query query = new Query(Criteria.where("userId").is(userId));
		  this.mongoTemplate.remove(query, User.class,COLLECTION);
		 
		 }

		 public User updateUser(User user) {
			 
			 Query query = new Query(Criteria.where("userId").is(user.getUserId()));
			  User repositoryUser = this.mongoTemplate.findOne(query, User.class, COLLECTION);
			 
			  if (repositoryUser != null) {
				  //user.setUserId("NewUserId");
				  //this.mongoTemplate.insert(user, COLLECTION);
				  this.mongoTemplate.save(user, COLLECTION);
			  }
			  
			  return user;
		 }

		 public List getAllUser() {
		  return (List) mongoTemplate.findAll(User.class,
		    COLLECTION);
		 }
		 
		public void deleteAllUser(){
			 mongoTemplate.dropCollection(COLLECTION);
		 }
	
	/*public String createUser(User user){
		
		*//**** Get collection / table from 'parichayDB' ****//*
		System.out.println("user dao createUser");
	
		DBCollection table = getDocumentByName("user");

		*//**** Insert ****//*
		// create a document to store key and value
		BasicDBObject useDocument = new BasicDBObject();
		useDocument.put("userId", user.getUserId());
		useDocument.put("name", user.getName());
		useDocument.put("age", 30);
		useDocument.put("createdDate", new Date());
		table.insert(useDocument);
		System.out.println("creation done from userDao");
		return user.getUserId();
	}

	
	public User getUser(String userId) {
		*//**** Get collection / table from 'parichayDB' ****//*
		System.out.println("user dao getUser");

		DBCollection table = getDocumentByName("user");
		System.out.println("size of user is:"+table.count());
		
		*//**** Find and display ****//*
		BasicDBObject searchQuery = new BasicDBObject();
		//if(emp.getId()!=null)
		{
			searchQuery.put("userId", userId);
	
		}
		//else{
			//searchQuery.put("name", "mkyong");
		//}
		
		DBCursor cursor = table.find(searchQuery);
		User user = null;
		while (cursor.hasNext()) {
			user = new User();
			System.out.println("object found");
			DBObject row = cursor.next();
			//Integer id = new Integer(String.valueOf((row.get("userId"))));
				if(userId.equals(String.valueOf(row.get("userId")))){
					System.out.println("found matched User with Id:"+String.valueOf(row.get("userId")));
					user.setUserId(String.valueOf(row.get("userId")));
					System.out.println("id fetched is:"+String.valueOf(row.get("userId")));
					user.setName(String.valueOf(row.get("name")));
					System.out.println("name fetched is:"+user.getName());
				}
			//System.out.println(user.guserme());
		}
		return user;
	}	
	public static void main(String[] args) {
		new UserDao().testDB();
	}

	private  void testDB() {
		
		
		
				DBCollection table = getDocumentByName("user");
		
				// if collection doesn't exists, MongoDB will create it for you
				
						//DBCollection table = db.getCollection("user");
				//employee.setId()
				*//**** Insert ****//*
				// create a document to store key and value
				BasicDBObject useDocument = new BasicDBObject();
				useDocument.put("userId", "100");
				useDocument.put("name", "Mahendra");
				useDocument.put("age", 30);
				useDocument.put("createdDate", new Date());
				table.insert(useDocument);
				System.out.println("creation done from userDao");
		
		
				System.out.println("End ...");
		
		
		
	}


	public List<User> getUsers() {
		
		DBCollection table = getDocumentByName("user");
		System.out.println("size of user is:"+table.count());
		

		DBCursor cursor = table.find();
		ArrayList<User> users = new ArrayList<User>();
		User user = null;
		while (cursor.hasNext()) {
			user = new User();
			System.out.println("object found");
			DBObject row = cursor.next();
			//Integer id = new Integer(String.valueOf((row.get("userId"))));
				//if(userId.equals(String.valueOf(row.get("userId"))))
				{
					System.out.println("found matched User with Id:"+String.valueOf(row.get("userId")));
					user.setUserId(String.valueOf(row.get("userId")));
					System.out.println("id fetched is:"+String.valueOf(row.get("userId")));
					user.setName(String.valueOf(row.get("name")));
					System.out.println("name fetched is:"+user.getName());
				}
				//System.out.println(user.guserme());
				users.add(user);
		}
		return users;
	}


	public void dropDB() {
		// TODO Auto-generated method stub
		
	}
	*/
}
