import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MainTest {

   @Test public void defaultTest() {
      TextGenerator.main(new String[]{"9", "10", "paulgraham2.txt"});
   }
}
