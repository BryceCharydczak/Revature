import static org.junit.Assert.*;
import org.junit.Test;


public class Question5 {
    @Test
    public void test(){
        SubString subString = new SubString();
        String testStr = "hi, how are you?";
        String correctOutput = "hi";
        String answer = subString.substringMethod(testStr, 1);
        assertEquals(correctOutput,answer);
    }

}
