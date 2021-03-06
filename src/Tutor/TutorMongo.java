package Tutor;

import MongoSetup.MongoSetup;
import Student.Student;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class TutorMongo {

    MongoSetup mongoSetup;
    DB database;
    DBCollection tutors;

    TutorMongo() {
        mongoSetup = new MongoSetup();
        database = mongoSetup.getDatabase();
        tutors = database.getCollection("tutors");
    }

    //Will be called by UI when inserting Tutors

    public BasicDBObject tutorAdapter(Tutor _tutor){
        BasicDBObject tutor;

        tutor = new BasicDBObject("_id", _tutor.getID());
        tutor.put("name", _tutor.getName());
        tutor.put("classification", _tutor.getTutorYear().toString());
        tutor.put("subjects", _tutor.getSubjects().toString());
        tutor.put("max students", _tutor.getStudentCap());
        for(Student student : _tutor.getStudents()) {
            tutor.put("students", new BasicDBObject("_id", student.getID())); //Needs to be debugged -- still only showing 1 student ID
        }
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
