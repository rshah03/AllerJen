package Tutor;

import Student.Student;
import com.mongodb.BasicDBObject;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends BasicDBObject{

    enum Classification{ FRESHMAN, SOPHMORE, JUNIOR, SENIOR }
    String tid;
    String firstName;
    String lastName;
    int maxStudents;
    int currentStudents;
    List<String> subjects;
    List<Student> students;
    public Classification tutorYear;

    public Tutor(String _tid, String _firstName, String _lastName, Classification _tutorYear, int _maxStudents) {
        tid = _tid;
        firstName = _firstName;
        lastName = _lastName;
        tutorYear = _tutorYear;
        maxStudents = _maxStudents;
        currentStudents = 0;
        subjects = new ArrayList<>();
        students = new ArrayList<>();

        //TODO: add functionality for time slots
    }

    public String getID() { return tid; }

    public String getName() {return firstName + " " + lastName; }

    public Classification getTutorYear() {return tutorYear; }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public List<String> getSubjects() { return subjects; }

    public void addStudent(Student student) {
        if(!isAtCapacity()) {
            students.add(student);
            currentStudents++;
        }
    }

    public List<Student> getStudents() { return students; }

    public int getStudentCap() { return maxStudents; }

    public boolean isAtCapacity() {
        return currentStudents >= maxStudents;
    }
}
