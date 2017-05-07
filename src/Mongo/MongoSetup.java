package Mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoSetup {

    MongoClient mongoClient;
    DB dataBase;
    DBCollection tutors;


    MongoSetup() {
        try { mongoClient = new MongoClient(); } catch (UnknownHostException e) {
            System.out.println("Error connecting to host...");
        }

        dataBase = mongoClient.getDB("TutorBoard");
        tutors = dataBase.getCollection("Tutors");
    }

    public String getCollectionName(String collectionName) {
        return tutors.getCollection(collectionName).toString();
    }

}
