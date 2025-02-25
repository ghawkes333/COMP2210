import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;


public class DescendingWeightTest {


   /** first comes before second **/
   @Test 
   public void typical1() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery2", 1);
     
     Comparator<Term> comp = Term.byDescendingWeightOrder();
     
     boolean result = comp.compare(term1, term2) < 0;
     assertTrue(result);
     
   }

   /** second comes before first **/
   @Test 
   public void typical2() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery2", 1);
     
     Comparator<Term> comp = Term.byDescendingWeightOrder();
     
     boolean result = comp.compare(term2, term1) > 0;
     assertTrue(result);
     
   }
   
   /** terms are non-null and are duplicates **/
   @Test 
   public void duplicates() {
     Term term1 = new Term ("myQuery1", 2);
     Term term2 = new Term ("myQuery1", 2);
     
     Comparator<Term> comp = Term.byDescendingWeightOrder();
     
     boolean result = comp.compare(term1, term2) == 0;
     assertTrue(result);
     
   }
}
