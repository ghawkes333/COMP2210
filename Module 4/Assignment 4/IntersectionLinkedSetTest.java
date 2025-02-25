import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class IntersectionLinkedSetTest {
   
   /** identical sets **/
   @Test public void sameElements() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("C");
      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[A, B, C]", intersection.toString());
   }
   
   /** identical sets **/
   @Test public void diffElements() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("E");
      b.add("F");
      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[]", intersection.toString());
   }   
   
   /** argument set is empty **/
   @Test public void emptySet() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[]", intersection.toString());
   }   
   
   /** argument set is null **/
   @Test public void nullSet() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = null;

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[]", intersection.toString());
   }   
   
   /** argument set has larger size **/
   @Test public void secondLargerThanFirstSet() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("Y");
      b.add("Z");
      b.add("B");

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[A, B]", intersection.toString());
   }   
   
   /** argument set has larger size **/
   @Test public void firstLargerThanSecondSet() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("Y");
      b.add("Z");
      b.add("B");

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[A, B]", intersection.toString());
   }   
}
