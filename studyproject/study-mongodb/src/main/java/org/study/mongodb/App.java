package org.study.mongodb;

import java.net.UnknownHostException;
import java.util.Random;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
			Mongo mongo = new Mongo("127.0.0.1",27017);
			DB db = mongo.getDB("test");
			DBCollection dbCollection = db.getCollection("number");
			
			for(int i=0;i<1000;i++){
				BasicDBObject basicDBObject = new BasicDBObject();
				basicDBObject.put("foo", "bar");
				basicDBObject.put("bar", i);
				
				
				dbCollection.insert(basicDBObject);
			}
			
			
			System.out.println("MongoDB has stored the luck number!"+"  ");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
