package Tutor;

import com.mongodb.BasicDBObject;
import java.util.*;

public class Tutor extends BasicDBObject{

    enum Classification{ FRESHMAN, SOPHMORE, JUNIOR, SENIOR }
    String tid;
    String firstName;
    String lastName;
    int maxStudents;
    List<String> subjects;
    public Classification tutorYear;

    public Tutor(String _tid, String _firstName, String _lastName, Classification _tutorYear, int _maxStudents) {
        tid = _tid;
        firstName = _firstName;
        lastName = _lastName;
        tutorYear = _tutorYear;
        maxStudents = _maxStudents;
        subjects = new ArrayList<>();

        //TODO: add functionality for time slots
    }

    public String getID() { return tid; }

    public String getName() {return firstName + " " + lastName; }

    public Classification getTutorYear() {return tutorYear; }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public List<String> getSubjects() { return subjects; }

    public boolean isAtCapacity(int students) {
        return students > maxStudents;
    }
}
