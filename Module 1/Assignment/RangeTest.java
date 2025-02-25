import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;


public class RangeTest {




   // Both bounds are included in the array
   @Test
   public void testRangeTypical(){
      int[] a = {1, 2, 3, 4, 5, 6, 7};
      assertEquals(1, 1);
      assertArrayEquals(new int[]{2, 3, 4, 5}, Selector.range(a, 2, 5));
   }
   
   // Upper bound is outside of the array
   @Test
   public void testRangeOutOfBounds(){
      int[] a = {1, 2, 3, 4, 5, 6, 7};
      int[] b = Selector.range(a, 2, 8);
      assertArrayEquals(new int[]{2, 3, 4, 5, 6, 7}, Selector.range(a, 2, 8));
   }
      
   // Lower bound is outside of the array
   @Test
   public void testBoundOutOfArray(){
      int[] a = {1, 2, 3, 4, 5, 6, 7};
      System.out.println(Selector.range(a, 0, 5));
   }
   
   // Array is null
   @Test(expected = IllegalArgumentException.class)
   public void testArrayNull(){
      int[] a = null;
      System.out.println(Selector.range(a, 2, 5));
   }
   
   // Array has length 0
   @Test(expected = IllegalArgumentException.class)
   public void testArrayEmpty(){
      int[] a = {};
      System.out.println(Selector.range(a, 2, 5));
   }
   
   
   
   
      // Ceiling integer is contained in the array
   @Test
   public void testCeilingInArray(){
      int[] a = {1, 5, 7, 0, -4, 3, 2};
      int ceiling = 0; 
      int result = Selector.ceiling(a, ceiling);
      assertEquals(0, result);
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
   public void ceilingtestArrayNull(){
      int[] a = {4, 5, 9, -4, 0, 2};
      int ceiling = 10; 
      int result = Selector.ceiling(a, ceiling);
   }

   // Array is null
   @Test(expected = IllegalArgumentException.class)
   public void ceilingtestArrayNull2(){
      int[] a = null;
      int ceiling = 4; 
      int result = Selector.ceiling(a, ceiling);
   }

   // Array is empty
   @Test(expected = IllegalArgumentException.class)
   public void ceilingtestArrayEmpty(){
      int[] a = {};
      int ceiling = 4; 
      int result = Selector.ceiling(a, ceiling);
   }
}
