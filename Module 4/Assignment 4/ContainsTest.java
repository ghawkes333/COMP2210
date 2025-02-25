import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ContainsTest {

   /** first element in pointer chain **/
   @Test public void existsFirst() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      
      assertEquals(true, linkedSet.contains("A"));
   }
   
   /** first element in pointer chain **/
   @Test public void existsSecond() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      
      assertEquals(true, linkedSet.contains("B"));
   }
   
   /** first element in pointer chain **/
   @Test public void existsThird() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      
      assertEquals(true, linkedSet.contains("C"));
   }
   
   /** element does not exist in chain **/
   @Test public void nonExistent() {
      LinkedSet<String> linkedSet = new LinkedSet<String>();
      linkedSet.add("A");
      linkedSet.add("B");
      linkedSet.add("C");
      
      assertEquals(false, linkedSet.contains("D"));
   }
}
