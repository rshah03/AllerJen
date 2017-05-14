package Mongo;

import com.mongodb.BasicDBObject;

public class Tutor extends BasicDBObject{

    enum Classification{ FRESHMAN, SOPHMORE, JUNIOR, SENIOR }
    String sid;
    String firstName;
    String lastName;
    public Classification tutorYear;

    public Tutor(String _sid, String _firstName, String _lastName, Classification _tutorYear) {
        sid = _sid;
        firstName = _firstName;
        lastName = _lastName;
        tutorYear = _tutorYear;
    }

    public String getID() { return sid; }

    public String getName() {return firstName + " " + lastName; }

    public Classification getTutorYear() {return tutorYear; }
}
