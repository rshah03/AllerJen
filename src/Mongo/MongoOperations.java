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

    public BasicDBObject tutorAdapter(Tutor _tutor){
        BasicDBObject tutor;
        String uniqueID = Character.toString(_tutor.getID().charAt(_tutor.getID().length()-1))
                + Character.toString(_tutor.getName().charAt(0))
                + Character.toString(_tutor.getName().charAt(1));

        tutor = new BasicDBObject("_id", _tutor.getID());
        tutor.put("name", _tutor.getName());
        tutor.put("classification", _tutor.getTutorYear().toString());
        return tutor;
    }

    public void addTutor(Tutor _tutor) {
        tutors.insert(tutorAdapter(_tutor));
    }

    public void removeTutor(Tutor _tutor) {
        BasicDBObject query = new BasicDBObject("_id", _tutor.getID());
        tutors.findAndRemove(query);
    }



}
