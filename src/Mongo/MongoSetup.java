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
        try { mongoClient = new MongoClient("localhost", 3000); } catch (UnknownHostException e) {
            System.out.println("Error connecting to host...");
        }

        dataBase = mongoClient.getDB("TutorBoard");
        tutors = dataBase.getCollection("Tutors");
    }



}
