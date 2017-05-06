package Mongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoDB {

    MongoClient mongoClient;
    DB dataBase;


    MongoDB() {
        try { mongoClient = new MongoClient(); } catch (UnknownHostException e) {
            System.out.println("Error connecting to host...");
        }

        dataBase = mongoClient.getDB("Tutors");
    }

    public String getCollectionName(String collectionName) {
        return dataBase.getCollection(collectionName).toString();
    }

}
