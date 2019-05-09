package stepDefinitions;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;

import managers.FileReaderManager;

import com.mongodb.client.MongoCollection;

import java.util.Arrays;

import org.bson.Document;
import org.bson.types.ObjectId;

public class MongoDBHelper {
	// Database credentials
	private static final String USER = FileReaderManager.getInstance().getConfigReader().getMongoDbUser();
	private static final String PASS = FileReaderManager.getInstance().getConfigReader().getMongoDbPass();
	private static final String DATABASE = "consent";
	
	private MongoDatabase db = null;
	String connectionString = FileReaderManager.getInstance().getConfigReader().getMongoDbUrl();
	MongoClient mongoClient;

	public MongoDBHelper() {
	}
	
	private MongoClient getMongoClient() {
		if (mongoClient == null) {
			MongoCredential credential = MongoCredential.createCredential(USER, "admin", PASS.toCharArray());
			mongoClient = new MongoClient(new ServerAddress(connectionString, 27017), Arrays.asList(credential));
		}
		return mongoClient;
	}


	private void open() {
		db = getMongoClient().getDatabase(DATABASE);
	}

}
