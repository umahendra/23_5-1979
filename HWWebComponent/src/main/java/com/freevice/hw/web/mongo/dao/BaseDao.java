package com.freevice.hw.web.mongo.dao;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class BaseDao {

	
	MongoClient mongo = new MongoClient("localhost", 27017);
	
	
	//MongoClient mongo = new MongoClient("57.37.20.35", 27017);
	

	DB db = mongo.getDB("FreeviceDB");
	
	
	public DBCollection getDocumentByName(String name){
		return db.getCollection(name);
	}
	
	public void dropDB(String name){
		
		System.out.println("Dropping DB"+name);
		
		MongoClient mongo = new MongoClient("localhost", 27017);

		mongo.dropDatabase("FreeviceDB");
		
		System.out.println("Dropping DB"+name+" Done");
		
	}
	
}
