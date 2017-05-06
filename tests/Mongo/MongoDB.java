package Mongo;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoDB {

    MongoDB mongoDB;
    MongoClient testClient;
    DB testDB;

    @Before
    public void setup() throws Exception {
        mongoDB = new MongoDB();
        testClient = new MongoClient();
    }

    @Test
    public void getCollectionReturnsCollection() {
        testDB = testClient.getDB("Tutors");
        DBCollection testCollection = testDB.getCollection("Tutors");
        assertEquals("Tutors", testCollection.toString());
    }


}
