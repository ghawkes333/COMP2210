import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;


public class CeilingTest {


   /** Test Typical **/
   @Test 
   public void testTypical() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(5);
      a.add(10);
      a.add(-3);
      a.add(1);
      
      int key = 3;
      Ascending comp = new Ascending();
      
      int expected = 3;
      int actual = Selector.ceiling(a, key, comp);
      assertEquals(expected, actual);
   }
   
   ///////////////////
   // Special Cases //
   ///////////////////
   
   @Test (expected = IllegalArgumentException.class)
   public void testNullComp() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(5);
      a.add(10);
      a.add(-3);
      a.add(1);
      
      int key = 3;
      Ascending comp = null;
      
      int expected = 5;
      int actual = Selector.ceiling(a, key, comp);
      assertEquals(expected, actual);
   }
   
   @Test (expected = IllegalArgumentException.class)
   public void testNullArr() {
      ArrayList<Integer> a = null;
      
      int key = 3;
      Ascending comp = new Ascending();
      
      int expected = 5;
      Selector.ceiling(a, key, comp);
   }

   /** Array includes duplicates **/
   @Test 
   public void testDuplicates() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(2);
      a.add(10);
      a.add(3);
      a.add(1);
      
      int key = 3;
      Ascending comp = new Ascending();
      
      int expected = 3;
      int actual = Selector.ceiling(a, key, comp);
      assertEquals(expected, actual);
   }

   /** Array includes duplicates, key is not a duplicate but is in the array **/
   @Test 
   public void testDuplicatesUniqueKey() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(2);
      a.add(10);
      a.add(4);
      a.add(1);
      
      int key = 3;
      Ascending comp = new Ascending();
      
      int expected = 3;
      int actual = Selector.ceiling(a, key, comp);
      assertEquals(expected, actual);
   }

   /** Array includes duplicates, result is a duplicate, key is not in the array **/
   @Test 
   public void testDuplicatesKeMissingy() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(2);
      a.add(10);
      a.add(4);
      a.add(0);
      
      int key = 1;
      Ascending comp = new Ascending();
      
      int expected = 2;
      int actual = Selector.ceiling(a, key, comp);
      assertEquals(expected, actual);
   }

   /** Key above array **/
   @Test (expected = NoSuchElementException.class)
   public void testKeyAbovel() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(5);
      a.add(10);
      a.add(-3);
      a.add(1);
      
      int key = 11;
      Ascending comp = new Ascending();
      
      Selector.ceiling(a, key, comp);
   }

   /** Key below array **/
   @Test
   public void testKeyBelow() {
      ArrayList<Integer> a = new ArrayList<Integer>();
      a.add(2);
      a.add(3);
      a.add(5);
      a.add(10);
      a.add(-3);
      a.add(1);
      
      int key = -5;
      Ascending comp = new Ascending();
      
      int expected = -3;
      int actual = Selector.ceiling(a, key, comp);
      assertEquals(expected, actual);
   }
   
   
   class Ascending implements Comparator<Integer>{
   
      public int compare(Integer objA, Integer objB){
         System.out.println("Comparing " + objA + " to " + objB + ": " + objA.compareTo(objB));
         return objA.compareTo(objB);
      }
   
   
   }
}
