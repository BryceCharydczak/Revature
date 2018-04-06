import static org.junit.Assert.*;
import org.junit.Test;


public class Question6 {
    @Test
    public void test(){
        TestMod Mod = new TestMod();
        int test = 6;
        int test2 = 7;
        int answer = Mod.testMod(test);
        int answer2 = Mod.testMod(test2);

        assertEquals(answer,1);
        assertEquals(answer2, 0);

    }

}
