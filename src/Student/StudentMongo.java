package Student;

import MongoSetup.MongoSetup;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class StudentMongo {
    MongoSetup mongoSetup;
    DB database;
    DBCollection students;

    public StudentMongo() {
        mongoSetup = new MongoSetup();
        database = mongoSetup.getDatabase();
        students = database.getCollection("students");
    }

    //Will be called by UI when inserting students

    public BasicDBObject studentAdapter(Student _student){
        BasicDBObject student;

        student = new BasicDBObject("_id", _student.getID());
        student.put("name", _student.getName());
        student.put("classification", _student.getstudentYear().toString());
        return student;
    }

    public void addStudent(Student _student) {
        students.insert(studentAdapter(_student));
    }

    public void removeStudent(Student _student) {
        BasicDBObject query = new BasicDBObject("_id", _student.getID());
        students.findAndRemove(query);
    }

}

