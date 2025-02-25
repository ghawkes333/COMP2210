import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class UnionTest {
   
   /** all unique values, already ascending**/
   @Test public void allUniqueAscend() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Set<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("E");
      b.add("F");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[A, B, C, D, E, F]");
   }
   
   /** all duplicate values**/
   @Test public void allDup() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("A");
      a.add("A");
      
      Set<String> b = new LinkedSet<String>();
      b.add("A");
      b.add("A");
      b.add("A");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[A]");
   }
   
   /** some duplicate values, already ascending **/
   @Test public void someDupAscend() {
      Set<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("A");
      a.add("B");
      
      Set<String> b = new LinkedSet<String>();
      b.add("C");
      b.add("D");
      b.add("D");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[A, B, C, D]");
   }
   
   /** all unique values, descending order **/
   @Test public void allUniqueDescend() {
      Set<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("E");
      
      Set<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("C");
      b.add("B");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[B, C, D, E, F, G]");
   }
   
   /** some duplicate values, descending order **/
   @Test public void someDupDescend() {
      Set<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("F");
      
      Set<String> b = new LinkedSet<String>();
      b.add("D");
      b.add("D");
      b.add("B");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[B, D, F, G]");
   }
   
   /** all unique values, mixed order **/
   @Test public void allUniqueMixedOrder() {
      Set<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("H");
      
      Set<String> b = new LinkedSet<String>();
      b.add("I");
      b.add("E");
      b.add("Z");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[E, F, G, H, I, Z]");
   }
   
   /** some duplicate values, mixed order **/
   @Test public void someDupMixedOrder() {
      Set<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("F");
      
      Set<String> b = new LinkedSet<String>();
      b.add("H");
      b.add("E");
      b.add("H");
      
      Set<String> union = a.<String>union(b);
      
      assertEquals(union.toString(), "[E, F, G, H]");
   }
   
   /** null argument **/
   @Test public void nullArgument() {
      Set<String> a = new LinkedSet<String>();
      a.add("G");
      a.add("F");
      a.add("H");
      
      Set<String> union = a.<String>union(null);
      
      assertEquals(union.toString(), "[F, G, H]");
   }
}
