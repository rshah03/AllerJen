package Student;

public class Student {
    enum Classification{ FRESHMAN, SOPHMORE, JUNIOR, SENIOR }
    String sid;
    String firstName;
    String lastName;
    public Classification studentYear;

    public Student(String _sid, String _firstName, String _lastName, Classification _studentYear) {
        sid = _sid;
        firstName = _firstName;
        lastName = _lastName;
        studentYear = _studentYear;

        //TODO: add functionality for time slots
    }

    public String getID() { return sid; }

    public String getName() {return firstName + " " + lastName; }

    public Classification getstudentYear() {return studentYear; }

}
