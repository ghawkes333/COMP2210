import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class MaxTest {


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
   
   /* Maximum value is the first in the list */
   @Test
   public void testFirst(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(100);
      list.add(0);
      list.add(1);
      
      Ascending sort = new Ascending();
      
      int expected = 100;
      int actual = Selector.<Integer>max(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* Maximum value is the second in the list */
   @Test
   public void testSecond(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(100);
      list.add(-1);
      
      Ascending sort = new Ascending();
      
      int expected = 100;
      int actual = Selector.<Integer>max(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* Maximum value is the last in the list */
   @Test
   public void testLast(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(-1);
      list.add(100);
      
      Ascending sort = new Ascending();
      
      int expected = 100;
      int actual = Selector.<Integer>max(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* List includes duplicates; max is not one of them */
   @Test
   public void testDupMaxUnique(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(-1);
      list.add(0);
      list.add(100);
      list.add(-1);
      list.add(-1);
      
      Ascending sort = new Ascending();
      
      int expected = 100;
      int actual = Selector.<Integer>max(list, sort);
      assertEquals(expected, actual);
      
   }
   
   /* List includes duplicates; max is one of them */
   @Test
   public void testDupMaxDup(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(100);
      list.add(-1);
      list.add(0);
      list.add(100);
      list.add(-1);
      list.add(-1);
      
      Ascending sort = new Ascending();
      
      int expected = 100;
      int actual = Selector.<Integer>max(list, sort);
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
      
      Selector.<Integer>max(list, sort);
      
   }
   
   /* Null comparator */
   @Test (expected = IllegalArgumentException.class)
   public void testNullList(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      list.add(0);
      list.add(-1);
      list.add(-100);
      
      Ascending sort = null;
      
      Selector.<Integer>max(list, sort);
      
   }
   
   /* Empty collection */
   @Test (expected = NoSuchElementException.class)
   public void testEmptyList(){
      ArrayList<Integer> list = new ArrayList<Integer>();
      
      Ascending sort = new Ascending();
        
      Selector.<Integer>max(list, sort);
      
   }
   
   
   
   
   
   


}
