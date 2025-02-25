import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class RangeTest {


   @Test
   public void testTypical(){
      Collection coll = new ArrayList<Integer>();
      coll.add(3);
      coll.add(5);
      coll.add(2);
      coll.add(1);
      coll.add(4);
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(3);
      expectedColl.add(2);
      expectedColl.add(4);
      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
      
      if (!(actual.getClass() == ArrayList.class)) fail("Collection was not an ArrayList");
      
      assertEquals(expectedColl, actual);
      
   
   }
   
   /* Coll has only one element; the element is between the low and high*/
   @Test
   public void testColSingleElementRetNonempty(){
      Collection coll = new ArrayList<Integer>();
      coll.add(3);
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(3);
      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
      
      if (!(actual.getClass() == ArrayList.class)) fail("Collection was not an ArrayList");
      
      assertEquals(expectedColl, actual);
      
   
   }
   
   /* Coll has only one element; the element is not between the low and high*/
   @Test (expected = NoSuchElementException.class)
   public void testColSingleElementRetEmpty(){
      Collection coll = new ArrayList<Integer>();
      coll.add(5);
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
      
      if (!(actual.getClass() == ArrayList.class)) fail("Collection was not an ArrayList");
      
      assertEquals(expectedColl, actual);
      
   
   }
   
   /* Coll has only one element; the element is equal to the low*/
   @Test
   public void testColSingleElementEqLow(){
      Collection coll = new ArrayList<Integer>();
      coll.add(2);
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(2);      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
      
      if (!(actual.getClass() == ArrayList.class)) fail("Collection was not an ArrayList");
      
      assertEquals(expectedColl, actual);
      
   
   }
   
   /* Coll has only one element; the element is equal to the high*/
   @Test
   public void testColSingleElementEqHigh(){
      Collection coll = new ArrayList<Integer>();
      coll.add(4);
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(4);      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
      
      if (!(actual.getClass() == ArrayList.class)) fail("Collection was not an ArrayList");
      
      assertEquals(expectedColl, actual);
      
   
   }
   
   
   
   
   /////////////////////////////
   // Invalid Arguments Cases //
   /////////////////////////////

   /* Low is greater than high */
   @Test (expected = NoSuchElementException.class)
   public void testLowGreaterThanHigh(){
      Collection coll = new ArrayList<Integer>();
      coll.add(3);
      coll.add(5);
      coll.add(2);
      coll.add(1);
      coll.add(4);
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 1;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(3);
      expectedColl.add(2);
      expectedColl.add(4);
      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
            
   
   }


   /* Coll is null */
   @Test (expected = IllegalArgumentException.class)
   public void testNullColl(){
      Collection coll = null;
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(3);
      expectedColl.add(2);
      expectedColl.add(4);
      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);      
      
   
   }

   /* Coll is empty */
   @Test (expected = NoSuchElementException.class)
   public void testEmptyColl(){
      Collection coll = new ArrayList<Integer>();
      
      
      Ascending sort = new Ascending();
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(3);
      expectedColl.add(2);
      expectedColl.add(4);
      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
   
   }

   /* Sort is null */ 
   @Test (expected = IllegalArgumentException.class)
   public void testNullSort(){
      Collection coll = new ArrayList<Integer>();
      
      Ascending sort = null;
      int low = 2;
      int high = 4;
      
      ArrayList<Integer> expectedColl = new ArrayList<Integer>();
      expectedColl.add(3);
      expectedColl.add(2);
      expectedColl.add(4);
      
      
      Collection<Integer> actual = Selector.<Integer>range(coll, low, high, sort);
      
   
   }
   
   class Ascending implements Comparator<Integer>{
   
      public int compare(Integer objA, Integer objB){
         System.out.println("Comparing " + objA + " to " + objB + ": " + objA.compareTo(objB));
         return objA.compareTo(objB);
      }
   
   
   }
   
}
