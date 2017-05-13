package Mongo;


import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.junit.Before;

public class MongoSetupTest {

    MongoSetup mongoSetup;
    MongoClient testClient;
    DB testDB;

    @Before
    public void setup() throws Exception {
        mongoSetup = new MongoSetup();
        testClient = new MongoClient();
        testDB = testClient.getDB("TutorBoard");

    }

}
