import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;


public class ByPrefixOrderTest {


   /** first comes before second **/
   @Test 
   public void typical1() {
     Term term1 = new Term ("A", 2);
     Term term2 = new Term ("B", 1);
     
     Comparator<Term> comp = Term.byPrefixOrder(1);
     
     boolean result = comp.compare(term1, term2) < 0;
     assertTrue(result);
     
   }

   /** second comes before first **/
   @Test 
   public void typical2() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery2", 1);
     
     Comparator<Term> comp = Term.byPrefixOrder(8);
     
     boolean result = comp.compare(term2, term1) > 0;
     assertTrue(result);
     
   }

   
   /** terms are non-null and are duplicates **/
   @Test 
   public void duplicates() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery1", 2);
     
     Comparator<Term> comp = Term.byPrefixOrder(8);
     
     boolean result = comp.compare(term1, term2) == 0;
     assertTrue(result);
     
   }
   
   /** length is greater than query **/
   @Test 
   public void lengthGreater() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery2", 2);
     
     Comparator<Term> comp = Term.byPrefixOrder(8 + 1);
     
     boolean result = comp.compare(term1, term2) == 0;
     System.out.println(term1.query.substring(0, 8));
     assertTrue(result);
     
   }
   
   /** argument length = 0 **/
   @Test (expected = IllegalArgumentException.class)
   public void zeroLengthTest() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery1", 2);
     
     Comparator<Term> comp = Term.byPrefixOrder(0);
          
   }
   
   /** argument length = 0 **/
   @Test (expected = IllegalArgumentException.class)
   public void negLengthTest() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery1", 2);
     
     Comparator<Term> comp = Term.byPrefixOrder(-100);
     
     
   }
}
