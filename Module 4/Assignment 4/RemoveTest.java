import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class RemoveTest {

   /** all duplicates**/
   @Test public void removeFirst() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      linkedSet.remove("A");
      
      assertEquals(linkedSet.toString(), "[B, C]");
   }
   
   /** all duplicates**/
   @Test public void removeSecond() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      linkedSet.remove("B");
      
      assertEquals(linkedSet.toString(), "[A, C]");
   }
   
   /** all duplicates**/
   @Test public void removeThird() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      linkedSet.remove("C");
      
      assertEquals(linkedSet.toString(), "[A, B]");
   }
   
   /** all duplicates**/
   @Test public void removeNull() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      
      
      assertEquals(false, linkedSet.remove("D"));
      assertEquals(linkedSet.toString(), "[A, B, C]");
   }
   
}
