import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class AutocompleteTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   @Test 
   public void defaultTest() {
      Term[] terms = {new Term("YZeta", 1), new Term("Beta", 3), new Term("YGamma", 0), new Term("Alpha", 10)};
      Autocomplete ac = new Autocomplete(terms);
      Term[] t = ac.allMatches("Y");
      System.out.println(t);
   }
}
