import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HammingDistanceTest {


   @Test public void firstLetterDiff() {
      try {
         InputStream in = new FileInputStream("small.txt");
         Doublets d = new Doublets(in);
         int actual = d.getHammingDistance("cat", "hat");
         int expected = 1;
         assertEquals(expected, actual);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
   
   
   @Test public void noDiff() {
      try {
         InputStream in = new FileInputStream("small.txt");
         Doublets d = new Doublets(in);
         int actual = d.getHammingDistance("hat", "hat");
         int expected = 0;
         assertEquals(expected, actual);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
   
   
   @Test public void allDiff() {
      try {
         InputStream in = new FileInputStream("small.txt");
         Doublets d = new Doublets(in);
         int actual = d.getHammingDistance("bed", "hat");
         int expected = 3;
         assertEquals(expected, actual);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
   
   
   @Test public void diffLengths() {
      try {
         InputStream in = new FileInputStream("small.txt");
         Doublets d = new Doublets(in);
         int actual = d.getHammingDistance("cats", "hat");
         int expected = -1;
         assertEquals(expected, actual);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
}
