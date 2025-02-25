import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class CeilingTest {


   // Ceiling integer is contained in the array
   @Test
   public void testCeilingInArray(){
      int[] a = {1, 5, 7, 0, -4, 3, 2};
      int ceiling = 0; 
      int result = Selector.ceiling(a, ceiling);
      assertEquals(result, 0);
   }

   // Ceiling integer is not contained in the array
   @Test
   public void testCeilingNotInArray(){
      int[] a = {3, 4, -2, -100, 8};
      int ceiling = -1; 
      int result = Selector.ceiling(a, ceiling);
      assertEquals(result, 3);
   }

   // Ceiling is not contained in the array
   @Test(expected = IllegalArgumentException.class)
   public void testArrayNull(){
      int[] a = {4, 5, 9, -4, 0, 2};
      int ceiling = 10; 
      int result = Selector.ceiling(a, ceiling);
   }

   // Array is null
   @Test(expected = IllegalArgumentException.class)
   public void testArrayNull(){
      int[] a = null;
      int ceiling = 4; 
      int result = Selector.ceiling(a, ceiling);
   }

   // Array is empty
   @Test(expected = IllegalArgumentException.class)
   public void testArrayNull(){
      int[] a = {};
      int ceiling = 4; 
      int result = Selector.ceiling(a, ceiling);
   }
   
   



}