import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;




public class ComplementLinkedSetTest {

   /** argument set does not contain any elements of first set **/
   @Test public void noOverlap() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("Y");
      b.add("Z");
      
      Set<String> complement = a.<String>complement(b);
      
      assertEquals("[A, B, C]", complement.toString());
   }   
   
   /** argument set and first set are identical **/
   @Test public void identicalSets() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("B");
      b.add("C");
      
      Set<String> complement = a.<String>complement(b);
      
      assertEquals("[]", complement.toString());
   }
   
   /** argument set contains some  elements of first set **/
   @Test public void someOverlap() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("Z");
      b.add("A");
      b.add("P");
      
      Set<String> complement = a.<String>complement(b);
      
      assertEquals("[B, C]", complement.toString());
   }
   
   /** argument set is null **/
   @Test public void nullArgument() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = null;
      
      Set<String> complement = a.<String>complement(b);
      
      assertEquals(null, complement);
   }
}
