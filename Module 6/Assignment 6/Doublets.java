import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Gabriella Hawkes (geh0042@auburn.edu)
 */
public class Doublets implements WordLadderGame {

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    
    private HashSet<String> lexicon;
    
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////

    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) {
        try {
            lexicon = new HashSet<String>();
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                lexicon.add(str.toLowerCase());
                s.nextLine();
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }


    public int getWordCount(){
      return lexicon.size();
    }


    public boolean isWord(String str){
      return lexicon.contains(str);
    }

    public int getHammingDistance(String str1, String str2){
      if (str1.length() != str2.length()) return -1;
      int count = 0;
      
      for (int i = 0; i < str1.length(); i++){
         if (str1.charAt(i) != str2.charAt(i)) count++;
      }
      
      return count;
      
    }
     
    public List<String> getNeighbors(String word){
      if (word == null) return null;
      
      word = word.toLowerCase();
      
      List<String> list = new LinkedList<>();
      char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
      
      for (int i = 0; i < word.length(); i++){
         for (char a : alpha){
            String s = word.substring(0, i) + a + word.substring(i + 1);
            if (lexicon.contains(s) && !s.equals(word)){
               list.add(s);
            }
         }
      }
      
      return list;
      
    }


    /**
     * Checks to see if the given sequence of strings is a valid word ladder.
     *
     * @param  sequence the given sequence of strings
     * @return          true if the given sequence is a valid word ladder,
     *                       false otherwise
     */
     
    public boolean isWordLadder(List<String> sequence){
      if (sequence.size() == 0) return false;
      if (sequence.size() == 1 && isWord(sequence.get(0))) return true;
      if (sequence.size() == 1) return false;
      
      for (int i = 0; i < sequence.size() - 1; i++){
         if (getHammingDistance(sequence.get(i), sequence.get(i+1)) != 1) return false;
         if (!isWord(sequence.get(i))) return false;
      }
      if (!isWord(sequence.get(sequence.size() - 1))) return false;
      
      return true;
    }


   /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
    
    public List<String> getMinLadder(String start, String end){ 
      if (start.length() != end.length()) return new ArrayList<String>();
      
      Node startNode = new Node(start, null); 
      Deque<Node> queue = new ArrayDeque<Node>();
      HashSet<String> visited = new HashSet<String>();
      
      queue.addLast(startNode);
      
      while (!queue.isEmpty()){
         Node top = queue.removeFirst();
         if (top.data.equalsIgnoreCase(end)){
            return getRoute(top);
         } else {
            List<String> neighbors = getNeighbors(top.data);
            for (String word : neighbors){
               if (visited.contains(word)) continue;
               visited.add(word);
               Node n = new Node(word, top);
               queue.addLast(n);
            }
         }
      }

      // No ladder exists
      return new ArrayList<String>();
      
    }
    
    private List<String> getRoute (Node n){
      Node p = n;
      LinkedList<String> list = new LinkedList<String>();
      
      while (p != null) {
         list.addFirst(p.data);
         p = p.prev;
      
      }
      
      return list;
    }
    
    private class Node {
      public String data;
      public Node prev;
      
      public Node(String data, Node prev){
         this.data = data;
         this.prev = prev;
      }
    
    }

}

