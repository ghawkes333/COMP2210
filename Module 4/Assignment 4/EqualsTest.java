import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class EqualsTest {

   /** identical including order **/
   @Test public void identical() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("C");
      
      assertEquals(true, a.equals(b));
   }
      
   /** one set has an extra element **/
   @Test public void extraElements() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      a.add("D");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("C");
      
      assertEquals(false, a.equals(b));
   }
      
   /** one set has a different element **/
   @Test public void differentElements() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("D");
      
      assertEquals(false, a.equals(b));
   }
   
}
