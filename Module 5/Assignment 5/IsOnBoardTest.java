import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;


public class IsOnBoardTest {

   private boolean[][] myArray;

   /**  word is in straight line on the board, starts at first square */
   @Test 
   public void lettersStraightLineStartFirst() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"C", "A", "T", "A", "B", "C", "D", "E", "F"});
      List<Integer> actual = g.isOnBoard("cat");
      Integer[] correctArr = {0, 1, 2};
      List<Integer> correct = Arrays.asList(correctArr);
      assertEquals(correct, actual);
   }
   
   /** word changes direction on the board, starts at first square */
   @Test 
   public void lettersCurveStartFirst() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"C", "A", "Z", "A", "T", "C", "D", "E", "F"});
      List<Integer> actual = g.isOnBoard("cat");
      Integer[] correctArr = {0, 1, 4};
      List<Integer> correct = Arrays.asList(correctArr);
      assertEquals(correct, actual);
   }
   
   
   /**  word is in straight line on the board, does not start at first square */
   @Test 
   public void lettersStraightLineStartMiddle() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"H", "A", "Z", "C", "A", "T", "D", "T", "F"});
      List<Integer> actual = g.isOnBoard("cat");
      Integer[] correctArr = {3, 4, 5};
      List<Integer> correct = Arrays.asList(correctArr);
      assertEquals(correct, actual);
   }
   
   /** word changes direction on the board, does not start at first square */
   @Test 
   public void lettersCurveStartMiddle() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"H", "A", "Z", "A", "C", "A", "D", "T", "F"});
      List<Integer> actual = g.isOnBoard("cat");
      Integer[] correctArr = {};
      List<Integer> correct = Arrays.asList(correctArr);
      assertEquals(correct, actual);
   }
   
   /** word does not exist */
   @Test 
   public void doesNotExist() {
      LinkedWordSearchGame g = new LinkedWordSearchGame();
      g.setBoard(new String[]{"H", "A", "Z", "A", "C", "A", "D", "Z", "T"});
      List<Integer> actual = g.isOnBoard("cat");
      Integer[] correctArr = {4, 5, 8};
      List<Integer> correct = Arrays.asList(correctArr);
      assertEquals(correct, actual);
   }
   
 
}
