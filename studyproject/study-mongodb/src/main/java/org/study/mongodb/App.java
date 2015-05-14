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
			DB db = mongo.getDB("helloworld_db");
			DBCollection dbCollection = db.getCollection("helloworld");
			BasicDBObject basicDBObject = new BasicDBObject();
			basicDBObject.put("Luck number", new Random().nextInt(1000));
			dbCollection.insert(basicDBObject);
			
			System.out.println("MongoDB has stored the luck number!"+"  ");
			
			DBCollection collection = db.getCollection("helloworld");
			DBCursor cursor = dbCollection.find();
			while(cursor.hasNext()){
				System.out.println(cursor.next());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
