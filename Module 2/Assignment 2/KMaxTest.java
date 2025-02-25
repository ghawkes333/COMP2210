import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.NoSuchElementException;


public class KMaxTest {
   
   
   /* Comparator */
   private class Ascending implements Comparator<Integer> {
      
      public int compare(Integer o1, Integer o2){
         return o1.compareTo(o2);
      
      }
   
   
   }
   
   ///////////////////
   // Typical Cases //
   ///////////////////
   
   /* All values in the collection are unique */
   @Test
   public void testUnique(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(0);
      a.add(-3);
      a.add(10);
      
      int k = 2;
      Ascending comp = new Ascending();
      
      Integer expected = 2;
      Integer actual = Selector.kmax(a, k, comp);
      
      assertEquals(expected, actual);
   
   
   }
   
   /* Duplicates exist; return value is unique*/
   @Test
   public void testDuplicatesReturnUnique(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(0);
      a.add(0);
      a.add(10);
      a.add(11);
      
      int k = 2;
      Ascending comp = new Ascending();
      
      int expected = 10;
      int actual = Selector.kmax(a, k, comp);
      
      assertEquals(expected, actual);
   
   
   }
   
   /* Duplicates exist; return value is a duplicate*/
   @Test
   public void testDuplicatesReturnDuplicate(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(0);
      a.add(10);
      a.add(10);
      a.add(11);
      
      int k = 2;
      Ascending comp = new Ascending();
      
      int expected = 10;
      int actual = Selector.kmax(a, k, comp);
      
      assertEquals(expected, actual);
   
   
   }
   
   ///////////////////
   // Special Cases //
   ///////////////////
   
   /* Null collection */
   @Test (expected = IllegalArgumentException.class)
   public void testNullCollection(){
      ArrayList<Integer> a = null;
      
      int k = 2;
      Ascending comp = new Ascending();
      
      Integer actual = Selector.kmax(a, k, comp);
   }
   
   /* Null comparator */
   @Test (expected = IllegalArgumentException.class)
   public void testNullComp(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(0);
      a.add(2);
      a.add(10);
      
      int k = 2;
      Ascending comp = null;
      
      Selector.kmax(a, k, comp);  
   }
   
   /* Negative k */
   @Test (expected = NoSuchElementException.class)
   public void testNegK(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(0);
      a.add(2);
      a.add(10);
      
      int k = -4;
      Ascending comp = new Ascending();
      
      Selector.kmax(a, k, comp);
   }
   
   /* K value is larger than the array length */
   @Test (expected = NoSuchElementException.class)
   public void testLargeK(){
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(0);
      a.add(2);
      a.add(10);
      
      int k = a.size() + 1;
      Ascending comp = new Ascending();
      
      Selector.kmax(a, k, comp);
   }
   
}
