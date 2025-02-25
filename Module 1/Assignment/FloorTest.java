import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class FloorTest {


   // Ceiling integer is contained in the array
   @Test
   public void testFloorInArray(){
      int[] a = {1, 5, 7, 0, -4, 3, 2};
      int floor = 0; 
      int result = Selector.floor(a, floor);
      assertEquals(result, 0);
   }

   // Ceiling integer is not contained in the array
   @Test
   public void testfloorNotInArray(){
      int[] a = {3, 4, -2, -100, 8};
      int floor = -1; 
      int result = Selector.floor(a, floor);
      assertEquals(-2, result);
   }

   // Ceiling is not contained in the array
   public void testArrayNull(){
      int[] a = {4, 5, 9, -4, 0, 2};
      int floor = 10; 
      int result = Selector.floor(a, floor);
      assertEquals(9, result);
   }

   // Array is null
   @Test(expected = IllegalArgumentException.class)
   public void testArrayNull2(){
      int[] a = null;
      int ceiling = 4; 
      int result = Selector.floor(a, ceiling);
   }

   // Array is empty
   @Test(expected = IllegalArgumentException.class)
   public void testArrayNull3(){
      int[] a = {};
      int ceiling = 4; 
      int result = Selector.floor(a, ceiling);
   }
}
