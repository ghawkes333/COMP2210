import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class IsValidWordTest {


   /** A test that always fails. **/
   @Test 
   public void defaultTest() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.loadLexicon("words_medium.txt");      
      
      assertEquals(true, g.isValidWord("AAH"));
   }
}
