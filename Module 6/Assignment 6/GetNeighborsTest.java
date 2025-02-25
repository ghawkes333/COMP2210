import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Arrays;

public class GetNeighborsTest {
cat
tac
cot
bat
can
bam
zzz


   @Test public void severalNeighbors() {
      try {
         InputStream in = new FileInputStream("tiny.txt");
         Doublets d = new Doublets(in);
         List<String> expected = Arrays.asList(new String[]{"cat", "cot", "bat", "can"});
         List<String> actual = d.getNeighbors("cat");
         
         boolean result = listsEqual(expected, actual);
         
         assert(result);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
   
   
   @Test public void singleNeighbor() {
      try {
         InputStream in = new FileInputStream("tiny.txt");
         Doublets d = new Doublets(in);
         List<String> expected = Arrays.asList(new String[]{"zzz"});
         List<String> actual = d.getNeighbors("zzz");
         
         boolean result = listsEqual(expected, actual);
         assert(result);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
   
   
   @Test public void noNeighbors() {
      try {
         InputStream in = new FileInputStream("tiny.txt");
         Doublets d = new Doublets(in);
         List<String> expected = Arrays.asList(new String[]{});
         List<String> actual = d.getNeighbors("aaa");
         
         boolean result = listsEqual(expected, actual);
         assert(result);
         
      } catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }
   /*
   * Check if two lists are equal, regardless of order or capitalization
   */
   private boolean listsEqual(List<String> a, List<String> b){
      if (a.size() != b.size()) return false;
      
      for (int i = 0; i < a.size(); i++){
         if (!b.contains(a.get(i))){
            return false;
         }
      
      }
      
      return true;
   }
}
