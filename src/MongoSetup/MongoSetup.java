package MongoSetup;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoSetup {
    MongoClient mongoClient;
    DB database;

    public MongoSetup() {
        try {
            mongoClient = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            System.out.println("Error connecting to host...");
        }

        database = mongoClient.getDB("TutorBoard");
    }

    public MongoClient getMongoClient() { return mongoClient; }
    public DB getDatabase() { return database; }


}
