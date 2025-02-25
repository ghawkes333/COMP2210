import java.io.File;
import java.util.HashMap;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.lang.Math;
import java.lang.StringBuilder;

/**
 * MarkovModel.java Creates an order K Markov model of the supplied source
 * text. The value of K determines the size of the "kgrams" used to generate
 * the model. A kgram is a sequence of k consecutive characters in the source
 * text.
 *
 * @author     Gabriella Hawkes (geh042@auburn.edu)
 * @author     Dean Hendrix (dh@auburn.edu)
 * @version    2018-04-17
 *
 */
public class MarkovModel {

   // Map of <kgram, chars following> pairs that stores the Markov model.
   private HashMap<String, String> model;
   
   private String[] kgramArray;
   
   private String firstKgram;

   // add other fields as you need them ...


   /**
    * Reads the contents of the file sourceText into a string, then calls
    * buildModel to construct the order K model.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, File sourceText) {
      model = new HashMap<>();
      try {
         String text = new Scanner(sourceText).useDelimiter("\\Z").next();
         buildModel(K, text);
      }
      catch (IOException e) {
         System.out.println("Error loading source text: " + e);
      }
   }


   /**
    * Calls buildModel to construct the order K model of the string sourceText.
    *
    * DO NOT CHANGE THIS CONSTRUCTOR.
    *
    */
   public MarkovModel(int K, String sourceText) {
      model = new HashMap<>();
      buildModel(K, sourceText);
   }


   /**
    * Builds an order K Markov model of the string sourceText.
    */
   private void buildModel(int K, String sourceText) {
       
      model = new HashMap<String, String>();
      
      firstKgram = sourceText.substring(0, K);
      
      for (int i = 0; i <= sourceText.length() - K; i++){
         String str = sourceText.substring(i, i + K);
         boolean b = i + K == sourceText.length();
         
         String next = i + K == sourceText.length() ? "\u0000" : sourceText.substring(i + K, i + K + 1);
         
         String existing = model.get(str);
         
         if (existing == null){
            model.put(str, next);
         } else {
            model.put(str, existing + next);
        }
      }
      
      kgramArray = model.keySet().toArray(new String[0]);
    
   }


   /** Returns the first kgram found in the source text. */
   public String getFirstKgram() {
      return firstKgram;
   }


   /** Returns a kgram chosen at random from the source text. */
   public String getRandomKgram() {
      Set<String> kgrams = getAllKgrams();
      int randInt = randInt(0, kgrams.size() - 1);
      
      return kgramArray[randInt];
   }


   /**
    * Returns the set of kgrams in the source text.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    public Set<String> getAllKgrams() {
      return model.keySet();
   }


   /**
    * Returns a single character that follows the given kgram in the source
    * text. This method selects the character according to the probability
    * distribution of all characters that follow the given kgram in the source
    * text.
    */
   public char getNextChar(String kgram) {
      String letters = model.get(kgram);
      if (letters == null) return '\u0000';
      
      while (letters.length() == 0){
         kgram = getRandomKgram();
         letters = model.get(kgram);
      }
      
      
      // The following line must be returning -1 at some point (String outOfBounds Exception)
      int index = randInt(0, letters.length() - 1);
      
      
      return letters.charAt(index);
   }
   
  private static int randInt (int low, int high){
      int rand = (int) (low + ((Math.random() * ((high + 1) - low))));
      return rand; 
   }


   /**
    * Returns a string representation of the model.
    * This is not part of the provided shell for the assignment.
    *
    * DO NOT CHANGE THIS METHOD.
    *
    */
    @Override
    public String toString() {
      return model.toString();
   }

}
