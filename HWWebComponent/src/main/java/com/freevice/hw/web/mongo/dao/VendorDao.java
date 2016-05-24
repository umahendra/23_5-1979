package com.freevice.hw.web.mongo.dao;
import java.util.Date;
import java.util.List;

import com.freevice.hw.web.model.Vendor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


public class VendorDao extends BaseDao {

	/* (non-Javadoc)
	 * @see com.freevice.hw.web.mongo.dao.VendorService#createVendor(com.freevice.hw.web.model.Vendor)
	 */
	public String createVendor(Vendor vendor){
		
		/**** Get collection / table from 'parichayDB' ****/
		System.out.println("user dao vendorUser");
	
		DBCollection table = getDocumentByName("vendor");

		/**** Insert ****/
		// create a document to store key and value
		BasicDBObject useDocument = new BasicDBObject();
		useDocument.put("vendorId", vendor.getVendorId());
		useDocument.put("vendorName", vendor.getVendorName());
		//useDocument.put("age", 30);
		useDocument.put("createdDate", new Date());
		table.insert(useDocument);
		System.out.println("creation done from userDao");
		return vendor.getVendorId();
	}

	
	/* (non-Javadoc)
	 * @see com.freevice.hw.web.mongo.dao.VendorService#getVendor(java.lang.String)
	 */
	public Vendor getVendor(String vendorId) {
		/**** Get collection / table from 'parichayDB' ****/
		System.out.println("user dao getVendor");

		DBCollection table = getDocumentByName("vendor");
		System.out.println("size of user is:"+table.count());
		
		/**** Find and display ****/
		BasicDBObject searchQuery = new BasicDBObject();
		//if(emp.getId()!=null)
		{
			searchQuery.put("vendorId", vendorId);
	
		}
		//else{
			//searchQuery.put("name", "mkyong");
		//}
		
		DBCursor cursor = table.find(searchQuery);
		Vendor vendor = null;
		while (cursor.hasNext()) {
			vendor = new Vendor();
			System.out.println("object found");
			DBObject row = cursor.next();
			//Integer id = new Integer(String.valueOf((row.get("userId"))));
				if(vendorId.equals(String.valueOf(row.get("vendorId")))){
					System.out.println("found matched Vendor with Id:"+String.valueOf(row.get("vendorId")));
					vendor.setVendorId(String.valueOf(row.get("vendorId")));
					System.out.println("id fetched is:"+String.valueOf(row.get("vendorId")));
					vendor.setVendorName(String.valueOf(row.get("name")));
					System.out.println("name fetched is:"+vendor.getVendorName());
				}
			//System.out.println(user.guserme());
		}
		return vendor;
	}	
	public static void main(String[] args) {
		new VendorDao().testDB();
	}

	private  void testDB() {
		
		
		
				DBCollection table = getDocumentByName("vendor");
		
				// if collection doesn't exists, MongoDB will create it for you
				
						//DBCollection table = db.getCollection("user");
				//employee.setId()
				/**** Insert ****/
				// create a document to store key and value
				BasicDBObject useDocument = new BasicDBObject();
				useDocument.put("vendor", "100");
				useDocument.put("name", "Mahendra");
				//useDocument.put("age", 30);
				useDocument.put("createdDate", new Date());
				table.insert(useDocument);
				System.out.println("creation done from vendorDao");
		
		
				System.out.println("End ...");
		
		
		
	}


	/* (non-Javadoc)
	 * @see com.freevice.hw.web.mongo.dao.VendorService#getVendors()
	 */
	public List<Vendor> getVendors() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
