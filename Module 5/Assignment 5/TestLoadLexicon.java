import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestLoadLexicon {


   /** Test a file that does not include spaces on each line **/
   @Test 
   public void testNoSpaces() {
      LinkedWordSearchGame game = new LinkedWordSearchGame();
      game.loadLexicon("words_small.txt");
      System.out.println("test");
      
      
   }
   
   /** Test a file that includes spaces on each line **/
   @Test 
   public void testWithSpaces() {
      LinkedWordSearchGame game = new LinkedWordSearchGame();
      game.loadLexicon("OWL.txt");
      System.out.println("test");
      
      
   }
}
