import static org.junit.Assert.*;
import org.junit.Test;


public class Question1 {
    @Test
    public void test(){
        BubbleSort bub = new BubbleSort();
        int[] test = {0,2,3,1,5};
        int[] answer = {0,1,2,3,5};
        int[] sorted = bub.bubblesort(test);
        assertArrayEquals(sorted,answer);
    }

}
