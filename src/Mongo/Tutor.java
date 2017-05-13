package Mongo;

/**
 * Created by coder on 5/9/17.
 */
public class Tutor {

    String id;
    String firstName;
    String lastName;
    enum classification{ FRESHMAN, SOPHMORE, JUNIOR, SENIOR }

    public Tutor(String _id, String _firstName, String _lastName) {
        id = _id;
        firstName = _firstName;
        lastName = _lastName;
    }

    public String getID() { return id; }

    public String getName() {return firstName + " " + lastName; }

}
