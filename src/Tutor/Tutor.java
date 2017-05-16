package Tutor;

import com.mongodb.BasicDBObject;

public class Tutor extends BasicDBObject{

    enum Classification{ FRESHMAN, SOPHMORE, JUNIOR, SENIOR }
    String tid;
    String firstName;
    String lastName;
    public Classification tutorYear;

    public Tutor(String _tid, String _firstName, String _lastName, Classification _tutorYear) {
        tid = _tid;
        firstName = _firstName;
        lastName = _lastName;
        tutorYear = _tutorYear;

        //TODO: add functionality for time slots
    }

    public String getID() { return tid; }

    public String getName() {return firstName + " " + lastName; }

    public Classification getTutorYear() {return tutorYear; }
}
