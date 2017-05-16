package Tutor;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        Tutor t = new Tutor("126","John", "Doe", Tutor.Classification.FRESHMAN);
        mongo.addTutor(t);
        assertEquals(mongo.tutors.count(), 1);
    }

    @Test
    public void insertMultipleTutors() {
        Tutor t1, t2;
        t1 = new Tutor("123","Vohn", "Doe", Tutor.Classification.FRESHMAN);
        t2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE);
        List<Tutor> tutors = Arrays.asList(t1, t2);
        for(Tutor tutor : tutors)
            mongo.addTutor(tutor);
        assertEquals(mongo.tutors.count(), 2);
    }

    @Test
    public void removeOneTutorFromCollection() {
        Tutor t1, t2;
        t1 = new Tutor("123","Vohn", "Doe", Tutor.Classification.FRESHMAN);
        t2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE);
        List<Tutor> tutors = Arrays.asList(t1, t2);
        for(Tutor tutor : tutors)
            mongo.addTutor(tutor);

        mongo.removeTutor(t1);
        assertEquals(mongo.tutors.count(), 1);
    }

    @Test
    public void removeMultipleTutorsFromCollection() {
        Tutor t1, t2, t3;
        t1 = new Tutor("123","John", "Doe", Tutor.Classification.FRESHMAN);
        t2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE);
        t3 = new Tutor("789", "Adam", "Nobody", Tutor.Classification.SENIOR);
        List<Tutor> tutors = Arrays.asList(t1, t2, t3);
        for(Tutor tutor : tutors)
            mongo.addTutor(tutor);

        List<Tutor> tutorsToRemove = Arrays.asList(t1, t3);
        for(Tutor tutor : tutorsToRemove)
            mongo.removeTutor(tutor);

        assertEquals(mongo.tutors.count(), 1);
    }

    @After
    public void clearDB() {
        mongo.tutors.drop();
    }
}
