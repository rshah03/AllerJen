package Tutor;


import Student.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TutorMongoOpsTest {

    TutorMongo mongo;
    Date[] availability;

    @Before
    public void setup() throws Exception {
        mongo = new TutorMongo();
        //availability = {new Date(), new Date()};
        //mongoSetup.tutors.drop();
    }

    //NOTE: DB has  to be cleared before running this multiple times.
    //Instructions to clear DB (Type the following commands directly into the MongoDB shell):
    //  1) use TutorBoard
    //  2) db.dropDatabase()
    //  3) show dbs
    //      --> Check and see whether or not TutorBoard shows up on this list. If it does, you did not delete properly.

    @Test
    public void insertTutorInsertsATutor() {
        Tutor tutor = new Tutor("126","John", "Doe", Tutor.Classification.FRESHMAN, 1);
        mongo.addTutor(tutor);
        assertEquals(mongo.tutors.count(), 1);
    }

    @Test
    public void insertMultipleTutors() {
        Tutor tutor1, tutor2;
        tutor1 = new Tutor("589","Vohn", "Doe", Tutor.Classification.FRESHMAN, 1);
        tutor2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE, 2);
        List<Tutor> tutors = Arrays.asList(tutor1, tutor2);
        for(Tutor tutor : tutors)
            mongo.addTutor(tutor);
        assertEquals(mongo.tutors.count(), 2);
    }

    @Test
    public void removeOneTutorFromCollection() {
        Tutor tutor1, tutor2;
        tutor1 = new Tutor("123","Vohn", "Doe", Tutor.Classification.FRESHMAN, 4);
        tutor2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE, 2);
        List<Tutor> tutors = Arrays.asList(tutor1, tutor2);
        for(Tutor tutor : tutors)
            mongo.addTutor(tutor);

        mongo.removeTutor(tutor1);
        assertEquals(mongo.tutors.count(), 1);
    }

    @Test
    public void removeMultipleTutorsFromCollection() {
        Tutor tutor1, tutor2, tutor3;
        tutor1 = new Tutor("123","John", "Doe", Tutor.Classification.FRESHMAN, 2);
        tutor2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE, 3);
        tutor3 = new Tutor("789", "Adam", "Nobody", Tutor.Classification.SENIOR, 2);
        List<Tutor> tutors = Arrays.asList(tutor1, tutor2, tutor3);
        for(Tutor tutor : tutors)
            mongo.addTutor(tutor);

        List<Tutor> tutorsToRemove = Arrays.asList(tutor1, tutor3);
        for(Tutor tutor : tutorsToRemove)
            mongo.removeTutor(tutor);

        assertEquals(mongo.tutors.count(), 1);
    }

    @Test
    public void addOneSubjectToTutor() {
        Tutor tutor = new Tutor("123","John", "Doe", Tutor.Classification.FRESHMAN, 2);
        tutor.addSubject("COSC 101");

        mongo.addTutor(tutor);
        assertEquals(mongo.tutors.count(), 1);
        assertEquals(1, tutor.getSubjects().size());
    }

    @Test
    public void addMultipleSubjectsToOneTutor() {
        Tutor tutor = new Tutor("123","John", "Doe", Tutor.Classification.FRESHMAN, 2);
        List<String> subjects = Arrays.asList("COSC 101", "COSC 102", "MATH 201");
        for(String subject : subjects)
            tutor.addSubject(subject);

        mongo.addTutor(tutor);

        assertEquals(mongo.tutors.count(), 1);

        assertEquals(3, tutor.getSubjects().size());
    }

    @Test
    public void addSubjectsToMultipleTutors() {
        Tutor tutor1 = new Tutor("123","John", "Doe", Tutor.Classification.FRESHMAN, 2);
        Tutor tutor2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE, 3);
        Tutor tutor3 = new Tutor("789", "Adam", "Nobody", Tutor.Classification.SENIOR, 2);

        tutor1.addSubject("COSC 101");
        tutor1.addSubject("MATH 210");

        tutor2.addSubject("COSC 102");

        tutor3.addSubject("COSC 301");

        boolean collectivePass = false;

        if(tutor1.getSubjects().size() == 2
                && tutor2.getSubjects().size() == 1
                && tutor3.getSubjects().size() == 1)
            collectivePass = true;

        mongo.addTutor(tutor1);
        mongo.addTutor(tutor2);
        mongo.addTutor(tutor3);

        assertEquals(mongo.tutors.count(), 3);
        assertTrue(collectivePass);
    }

    @Test
    public void onlyAllowStudentsWhileBelowCapacity() {
        Tutor tutor = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE, 2);
        tutor.addStudent(new Student("1001","Jack", "Doe", Student.Classification.FRESHMAN));

        mongo.addTutor(tutor);

        assertEquals(mongo.tutors.count(), 1);
        assertTrue(!tutor.isAtCapacity());
       //Create method to add student objects
    }

    @Test
    public void failToAddStudentsIfOverCapacity() {
        Tutor tutor = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE, 1);
        tutor.addStudent(new Student("1001","Jack", "Doe", Student.Classification.FRESHMAN));
        tutor.addStudent(new Student("1002","Jill", "Doe", Student.Classification.FRESHMAN));
        tutor.addStudent(new Student("1003","Jane", "Doe", Student.Classification.FRESHMAN));

        mongo.addTutor(tutor);

        assertEquals(mongo.tutors.count(), 1);
        assertTrue(tutor.isAtCapacity());
    }

    @After
    public void clearDB() {
        mongo.tutors.drop();
    }
}
