import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AddTest {

   /** all uniques, added in ascending order**/
   @Test public void addUniquesAscend() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      
      assertEquals(linkedSet.toString(), "[A, B, C]");
   }
   
   /** all uniques, added in descending order**/
   @Test public void addUniquesDescend() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("C");
      linkedSet.add("B");
      linkedSet.add("A");
      
      assertEquals(linkedSet.toString(), "[A, B, C]");
   }
   
   /** all uniques, added in different order so the B element is added between two nodes**/
   @Test public void addUniquesMixedOrder() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("C");
      linkedSet.add("A");
      linkedSet.add("B");
      
      assertEquals(linkedSet.toString(), "[A, B, C]");
   }
   
   /** all duplicates**/
   @Test public void addDuplicates() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.remove("A");
      linkedSet.add("A");
      
      assertEquals(linkedSet.size(), 1);
   }
   
   /** all duplicates**/
   @Test public void addNull() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      boolean bool = linkedSet.add(null);
      
      assertEquals(bool, false);
   }
}
