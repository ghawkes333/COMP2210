import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class GetBoardTest {

   @Test 
   public void typicalTest() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"});
      
      String s = "a b c \nd e f \ng h i";
      assertEquals(s, g.getBoard());
   }
   
   @Test 
   public void emptyBoard() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      
      String s = "";
      assertEquals(s, g.getBoard());
   }
}
