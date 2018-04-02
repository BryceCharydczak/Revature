import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class StudentTest {

    @AfterClass
    public static void runAfterClass(){
        System.out.println("called runAfterClass() method");
    }

    @BeforeClass
    public static void runBeforeClass(){
        System.out.println("called runBeforeClass() method");
    }

    @Before
    public static void runBefore(){
        System.out.println("called runBefore() method");
    }

    @After
    public static void runAfter(){
        System.out.println("called runAfter() method");
    }


}
