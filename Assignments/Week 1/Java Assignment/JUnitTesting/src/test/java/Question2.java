import static org.junit.Assert.*;
import org.junit.Test;


public class Question2 {
    @Test
    public void test(){
        long correctAnswer = 46368;
        DynamicFib fibObj = new DynamicFib();
        long answer = fibObj.DyamicFib();
        assertEquals(answer, correctAnswer);
    }

}
