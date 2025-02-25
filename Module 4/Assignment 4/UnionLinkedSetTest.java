import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class UnionLinkedSetTest {

   
   /** all unique values, already ascending**/
   @Test public void allUniqueAscend() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("E");
      b.add("F");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[A, B, C, D, E, F]");
   }
   
   /** all duplicate values**/
   @Test public void allDup() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("A");
      a.add("A");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("A");
      b.add("A");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[A]");
   }
   
   /** some duplicate values, already ascending **/
   @Test public void someDupAscend() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("A");
      a.add("B");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("C");
      b.add("D");
      b.add("D");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[A, B, C, D]");
   }
   
   /** all unique values, descending order **/
   @Test public void allUniqueDescend() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("E");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("C");
      b.add("B");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[B, C, D, E, F, G]");
   }
   
   /** some duplicate values, descending order **/
   @Test public void someDupDescend() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("F");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("D");
      b.add("B");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[B, D, F, G]");
   }
   
   /** all unique values, mixed order **/
   @Test public void allUniqueMixedOrder() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("H");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("I");
      b.add("E");
      b.add("Z");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[E, F, G, H, I, Z]");
   }
   
   /** some duplicate values, mixed order **/
   @Test public void someDupMixedOrder() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("F");
      
      LinkedSet<String> b = new LinkedSet<String>();
      b.add("H");
      b.add("E");
      b.add("H");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[E, F, G, H]");
   }
   
   /** null argument **/
   @Test public void nullArgument() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("H");
      
      Set<String> union = a.<String>union(null);
      
      assertEquals(union.toString(), "[F, G, H]");
   }
}
