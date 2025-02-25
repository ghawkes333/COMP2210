import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class SetBoardTest {

   /** A test that always fails. **/
   @Test public void defaultTest() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"});
   }
}
