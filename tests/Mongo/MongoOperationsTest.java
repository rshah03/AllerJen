package Mongo;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MongoOperationsTest {

    MongoOperations mongoSetup;

    @Before
    public void setup() throws Exception {
        mongoSetup = new MongoOperations();
    }

    //NOTE: DB has  to be cleared before running this multiple times.
    //Instructions to clear DB (Type the following commands directly into the MongoDB shell):
    //  1) use TutorBoard
    //  2) db.dropDatabase()
    //  3) show dbs
    //      --> Check and see whether or not TutorBoard shows up on this list. If it does, you did not delete properly.

    @Test
    public void insertTutorInsertsATutor() {
        Tutor t = new Tutor("123","John", "Doe", Tutor.Classification.FRESHMAN);
        mongoSetup.addTutor(t);


    }

    @Test
    public void insertMultipleTutors() {
        Tutor t1, t2;
        t1 = new Tutor("123","Vohn", "Doe", Tutor.Classification.FRESHMAN);
        t2 = new Tutor("456","Jane", "Doe", Tutor.Classification.SOPHMORE);
        List<Tutor> tutors = Arrays.asList(t1, t2);
        for(Tutor tutor : tutors)
            mongoSetup.addTutor(tutor);
    }
}