import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MinTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   
   }
   
   
   /* Comparator */
   private class Ascending implements Comparator<Integer> {
      
      public int compare(Integer o1, Integer o2){
         return o1.compareTo(o2);
      
      }
   
   
   }
 
   
   //////////////////
   // Typical Cases//
   //////////////////
   
   /* Minimum value is the first in the list */
   @Test
   public void testFirst(){
      ArrayList<Integer> list = new ArrayList();
      list.add(0);
      list.add(1);
      list.add(100);
      
      Ascending sort = new Ascending();
      
      int expected = 0;
      int actual = Selector.<Integer>min(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* Minimum value is the second in the list */
   @Test
   public void testSecond(){
      ArrayList<Integer> list = new ArrayList();
      list.add(0);
      list.add(-1);
      list.add(100);
      
      Ascending sort = new Ascending();
      
      int expected = -1;
      int actual = Selector.<Integer>min(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* Minimum value is the last in the list */
   @Test
   public void testLast(){
      ArrayList<Integer> list = new ArrayList();
      list.add(0);
      list.add(-1);
      list.add(-100);
      
      Ascending sort = new Ascending();
      
      int expected = -100;
      int actual = Selector.<Integer>min(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* List includes duplicates; min is not one of them*/
   @Test
   public void testWithDupMinUnique(){
      ArrayList<Integer> list = new ArrayList();
      list.add(1);
      list.add(0);
      list.add(1);
      list.add(100);
      list.add(100);
      list.add(100);
      
      Ascending sort = new Ascending();
      
      int expected = 0;
      int actual = Selector.<Integer>min(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* List includes duplicates; min is one of them*/
   @Test
   public void testWithDupMinDup(){
      ArrayList<Integer> list = new ArrayList();
      list.add(0);
      list.add(1);
      list.add(0);
      list.add(1);
      list.add(100);
      list.add(100);
      list.add(100);
      
      Ascending sort = new Ascending();
      
      int expected = 0;
      int actual = Selector.<Integer>min(list, sort);
      assertEquals(expected, actual);
      
   }
   
   
   ///////////////////
   // Special Cases //
   ///////////////////
   
   /* Null collection */
   @Test (expected = IllegalArgumentException.class)
   public void testNullCollection(){
      ArrayList<Integer> list = null;
      
      Ascending sort = new Ascending();
      
      Selector.<Integer>min(list, sort);
      Selector.<Integer>min(list, sort);
      
   }
   
   /* Null comparator */
   @Test (expected = IllegalArgumentException.class)
   public void testNullList(){
      ArrayList<Integer> list = new ArrayList();
      list.add(0);
      list.add(-1);
      list.add(-100);
      
      Ascending sort = null;
      
      Selector.<Integer>min(list, sort);
      
   }
   
   /* Empty collection */
   @Test (expected = NoSuchElementException.class)
   public void testEmptyList(){
      ArrayList<Integer> list = new ArrayList();
      
      Ascending sort = new Ascending();
        
      Selector.<Integer>min(list, sort);
      
   }
   
   
   
   
   
   


}
