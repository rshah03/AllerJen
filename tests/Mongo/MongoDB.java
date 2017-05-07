package Mongo;


import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoDB {

    MongoSetup mongoSetup;
    MongoClient testClient;
    DB testDB;

    @Before
    public void setup() throws Exception {
        mongoSetup = new MongoSetup();
        testClient = new MongoClient();
        testDB = testClient.getDB("TutorBoard");

    }

    @Test
    public void getCollectionReturnsCollection() { 
        assertEquals("Tutors.Tutors", mongoSetup.getCollectionName("Tutors"));
    }


}
