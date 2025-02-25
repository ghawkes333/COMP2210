import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;

public class LinkedSetTest {


   
   
   /** argument set is null **/
   @Test public void printThreeElem() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Iterator<Set<String>> itr = a.powerSetIterator();
      
      while (itr.hasNext()){
         Set<String> s = itr.next();
         System.out.println(s.toString());
      }

   }
   
   /** argument set is null **/
   @Test public void printFourElem() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      a.add("D");
      
      Iterator<Set<String>> itr = a.powerSetIterator();
      
      while (itr.hasNext()){
         Set<String> s = itr.next();
         System.out.println(s.toString());
      }

   }
   
   /** argument set is null **/
   @Test public void printEmpty() {
      LinkedSet<String> a = new LinkedSet<String>();
      
      Iterator<Set<String>> itr = a.powerSetIterator();
      
      while (itr.hasNext()){
         Set<String> s = itr.next();
         System.out.println(s.toString());
      }

   }
   
   /** argument set is null **/
   @Test public void printEmpty2() {
      LinkedSet<String> a = new LinkedSet<String>();
      a.add("A");
      a.add("B");
      a.add("C");
      
      Iterator<String> itr = a.descendingIterator();
      
      while (itr.hasNext()){
         String s = itr.next();
         System.out.println(s.toString());
      }

   }
   
   /** argument set is null **/
   @Test public void printEmpty3() {
      LinkedSet<String> a = new LinkedSet<String>();
      
      Iterator<String> itr = a.iterator();
      
      while (itr.hasNext()){
         String s = itr.next();
         System.out.println(s.toString());
      }

   }
}
