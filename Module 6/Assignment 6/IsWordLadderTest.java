import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.List;
import java.util.Arrays;


public class IsWordLadderTest {



   @Test public void typical() {
      InputStream in = new FileInputStream("OWL.txt");
      Doublets d = new Doublets(in);
      List<String> ladder = Arrays.asList(new String[]{"abandon",});
   }
}
