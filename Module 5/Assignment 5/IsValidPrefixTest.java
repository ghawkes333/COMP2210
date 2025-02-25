import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class IsValidPrefixTest {


   /** Prefix is a word in the lexicon **/
   @Test 
   public void prefixIsWordInLexicon() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.loadLexicon("words_small.txt");
      
      boolean result = g.isValidPrefix("abbey");
      
      assertEquals(true, result);
   }
   
   /** A word in the lexicon begins with the prefix but is not equal to it **/
   @Test 
   public void wordStartsWithPrefix() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.loadLexicon("words_small.txt");
      
      boolean result = g.isValidPrefix("ab");
      
      assertEquals(true, result);
   }
   
   /** A word in the lexicon begins with the prefix but is not equal to it **/
   @Test 
   public void prefixDoesNotExist() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.loadLexicon("words_small.txt");
      
      boolean result = g.isValidPrefix("abede");
      
      assertEquals(false, result);
   }
}
