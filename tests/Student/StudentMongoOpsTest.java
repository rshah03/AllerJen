package Student;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StudentMongoOpsTest {

    StudentMongo mongo;

    @Before
    public void setup() throws Exception {
        mongo = new StudentMongo();
    }

    @Test
    public void insertTutorInsertsATutor() {
        Student t = new Student("1000","Adam", "Doe", Student.Classification.FRESHMAN);
        mongo.addStudent(t);
        assertEquals(mongo.students.count(), 1);
    }

    @Test
    public void insertMultipleTutors() {
        Student s1, s2;
        s1 = new Student("1000","Jack", "Doe", Student.Classification.FRESHMAN);
        s2 = new Student("1001","Jill", "Doe", Student.Classification.SOPHMORE);
        List<Student> students = Arrays.asList(s1, s2);
        for(Student student : students)
            mongo.addStudent(student);
        assertEquals(mongo.students.count(), 2);
    }

    @Test
    public void removeOneTutorFromCollection() {
        Student s1, s2;
        s1 = new Student("1001","Jack", "Doe", Student.Classification.FRESHMAN);
        s2 = new Student("1002","Jill", "Doe", Student.Classification.SOPHMORE);
        List<Student> students = Arrays.asList(s1, s2);
        for(Student student : students)
            mongo.addStudent(student);

        mongo.removeStudent(s1);
        assertEquals(mongo.students.count(), 1);
    }

    @Test
    public void removeMultipleTutorsFromCollection() {
        Student s1, s2, t3;
        s1 = new Student("1001","Adam", "Doe", Student.Classification.FRESHMAN);
        s2 = new Student("1002","Jake", "Doe", Student.Classification.SOPHMORE);
        t3 = new Student("1003", "Jill", "Nobody", Student.Classification.SENIOR);
        List<Student> students = Arrays.asList(s1, s2, t3);
        for(Student student : students)
            mongo.addStudent(student);

        List<Student> studentsToRemove = Arrays.asList(s1, t3);
        for(Student student : studentsToRemove)
            mongo.removeStudent(student);

        assertEquals(mongo.students.count(), 1);
    }

    @After
    public void clearDB() {
        mongo.students.drop();
    }
}
