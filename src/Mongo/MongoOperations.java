package Mongo;

import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoOperations {

    MongoClient mongoClient;
    DB dataBase;
    DBCollection tutors;

    MongoOperations() {
        try { mongoClient = new MongoClient("localhost", 27017); } catch (UnknownHostException e) {
            System.out.println("Error connecting to host...");
        }

        dataBase = mongoClient.getDB("TutorBoard");
        tutors = dataBase.getCollection("tutors");
    }

    //Will be called by UI when inserting Tutors
    public void addTutor(Tutor _tutor) {
        BasicDBObject tutor = new BasicDBObject("_id", (_tutor.getID().charAt(_tutor.getID().length()-1) + _tutor.getName().charAt(0) + _tutor.getName().charAt(1)));
        tutor.put("sid", _tutor.getID());
        tutor.put("name", _tutor.getName());
        tutor.put("classification", _tutor.getTutorYear().toString());
        tutors.insert(tutor);
    }



}
