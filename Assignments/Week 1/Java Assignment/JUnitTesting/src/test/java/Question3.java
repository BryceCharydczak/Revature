import static org.junit.Assert.*;
import org.junit.Test;


public class Question3 {
    @Test
    public void test(){
        String correctAnswer = "testing is lame";
        String testString = "emal si gnitset";
        ReverseString reverseString = new ReverseString();
        String answer = reverseString.reverseString(testString);
        assertEquals(answer, correctAnswer);
    }

}

