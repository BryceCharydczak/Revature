import static org.junit.Assert.*;
import org.junit.Test;


public class Question4 {
    @Test
    public void test(){
        long correctAnswer = 3628800;
        int testN = 10;
        nFactorial nFac = new nFactorial();
        long testReturn = nFac.nFactorial(testN);
        assertEquals(correctAnswer, testReturn);

    }

}

