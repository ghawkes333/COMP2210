import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;


public class FirstIndexOfTest {


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
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
      assertEquals(3, result);
   }
   
   /** Target is a duplicate in the array **/
   @Test
   public void duplicateTargetTest1() {
      Integer[] a = {-10, -3, 2, 2, 5};
      Integer target = 2;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
      assertEquals(2, result);
   }
   
   /** Target is a duplicate in the array at the beginning**/
   @Test
   public void duplicateTargetTest2() {
      Integer[] a = {-10, -10, 2, 2, 5};
      Integer target = -10;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
      assertEquals(0, result);
   }
   
   /** Target is a duplicate in the array at the end **/
   @Test
   public void duplicateTargetTest3() {
      Integer[] a = {-10, -3, 0, 5, 5};
      Integer target = 5;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
      assertEquals(3, result);
   }
   
   /** Entire array is the target value **/
   @Test
   public void duplicateTargetTest4() {
      Integer[] a = {5, 5, 5, 5, 5};
      Integer target = 5;
      Comparator<Integer> comp = new Comparator<Integer> (){
         @Override
         public int compare(Integer a, Integer b){
            return a.compareTo(b);
         }      
      };
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
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
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
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
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
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
      
      int result = BinarySearch.firstIndexOf(a, target, comp);
      
      assertEquals(-1, result);
   }
}