import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class EqualsLinkedSetTest {

   /** identical sets **/
   @Test public void identical() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("C");
      
      assertEquals(true, a.equals(b));
   }
   
   /** no elements in common **/
   @Test public void differentSets() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("E");
      b.add("F");
      
      assertEquals(false, a.equals(b));
   }
   
   /** null argument **/
   @Test public void nullSet() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = null;
      
      assertEquals(false, a.equals(b));
   }
   
   /** some elements in common **/
   @Test public void similarSets() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("E");
      b.add("F");
      
      assertEquals(false, a.equals(b));
   }
   
}
