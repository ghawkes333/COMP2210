import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;


public class LastIndexOfTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Target is unique in the array **/
   @Test
   public void uniqueTargetTest() {
      Integer[] a = {-10, -3, 0, 2, 5};
      Integer target = 2;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.lastIndexOf(a, target, comp);
      
      assertEquals(3, result);
   }
   
   /** Target is a duplicate in the array **/
   @Test
   public void duplicateTargetTest() {
      Integer[] a = {-10, -3, 2, 2, 5};
      Integer target = 2;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.lastIndexOf(a, target, comp);
      
      assertEquals(3, result);
   }
   
   /** Target is in between two adjacent values in the array **/
   @Test
   public void nonexistentTargetTest1() {
      Integer[] a = {-10, -3, 0, 2, 5};
      Integer target = 1;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.lastIndexOf(a, target, comp);
      
      assertEquals(-1, result);
   }
   
   /** Target is larger than any value in the array **/
   @Test
   public void nonexistentTargetTest2() {
      Integer[] a = {-10, -3, 0, 2, 5};
      Integer target = 10;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.lastIndexOf(a, target, comp);
      
      assertEquals(-1, result);
   }
   
   /** Target is smaller than any value in the array **/
   @Test
   public void nonexistentTargetTest3() {
      Integer[] a = {-10, -3, 0, 2, 5};
      Integer target = 1;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.lastIndexOf(a, target, comp);
      
      assertEquals(-1, result);
   }
}