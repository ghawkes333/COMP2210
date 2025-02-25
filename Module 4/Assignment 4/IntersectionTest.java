import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class IntersectionTest {
   
   /** identical sets **/
   @Test public void sameElements() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("C");
      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[A, B, C]", intersection.toString());
   }
   
   /** identical sets **/
   @Test public void diffElements() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("E");
      b.add("F");
      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[]", intersection.toString());
   }   
   
   /** argument set is empty **/
   @Test public void emptySet() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[]", intersection.toString());
   }   
   
   /** argument set is null **/
   @Test public void nullSet() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = null;

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[]", intersection.toString());
   }   
   
   /** argument set has larger size **/
   @Test public void secondLargerThanFirstSet() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("Y");
      b.add("Z");
      b.add("B");

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[A, B]", intersection.toString());
   }   
   
   /** argument set has larger size **/
   @Test public void firstLargerThanSecondSet() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("Y");
      b.add("Z");
      b.add("B");

      
      Set<String> intersection = a.<String>intersection(b);
      
      assertEquals("[A, B]", intersection.toString());
   }   
}
