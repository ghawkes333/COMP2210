import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.IOException;


public class MarkovModelTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   @Test public void defaultTest() {
      int k = 9;
      File text;
      try {
         text = new File("paulgraham2.txt");
         if (!text.canRead()) {
            throw new Exception();
         }
      }
      catch (Exception e) {
         System.out.println("Error: Could not open");
         return;
      }
      
      MarkovModel m = new MarkovModel(k, text);
      System.out.println(m.getFirstKgram());
   }
}
