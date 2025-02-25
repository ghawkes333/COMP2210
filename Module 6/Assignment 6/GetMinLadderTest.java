import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class GetMinLadderTest {

   @Test 
   public void notExistent() {
      try {
      InputStream in = new FileInputStream("tiny.txt");
      Doublets d = new Doublets(in);
      System.out.println(d.getMinLadder("cat", "zzz"));
      } catch (FileNotFoundException e){
         System.out.println(e);
      }
   }
   

   @Test 
   public void singleStep() {
      try {
      InputStream in = new FileInputStream("tiny.txt");
      Doublets d = new Doublets(in);
      System.out.println(d.getMinLadder("cat", "can"));
      } catch (FileNotFoundException e){
         System.out.println(e);
      }
   }
   
  
   @Test 
   public void multipleSteps() {
      try {
      InputStream in = new FileInputStream("tiny.txt");
      Doublets d = new Doublets(in);
      System.out.println(d.getMinLadder("cat", "cot"));
      } catch (FileNotFoundException e){
         System.out.println(e);
      }
   }
   
   
   @Test 
   public void large() {
      try {
      InputStream in = new FileInputStream("OWL.txt");
      Doublets d = new Doublets(in);
      System.out.println(d.getMinLadder("beaver", "waters"));
      } catch (FileNotFoundException e){
         System.out.println(e);
      }
   }
  
}
