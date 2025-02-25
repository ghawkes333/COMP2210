import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KMinTest {



   @Test public void test() {
      int[] arr = {1, -9, 0, 8, 100, -3};
      int k = 3;
      
      int expected = 0;
      int result = Selector.kmax(arr, k);
      assertEquals(expected, result);
   }

   @Test public void testDup() {
      int[] arr = {1, -9, -9, 8, 100, 100};
      int k = 3;
      
      int expected = 8;
      int result = Selector.kmin(arr, k);
      assertEquals(expected, result);
   }

}
