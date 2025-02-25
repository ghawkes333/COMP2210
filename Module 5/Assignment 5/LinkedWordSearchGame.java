/*
* A game engine that implements WordSearchGame
* 
* @author Gabriella Hawkes (geh0042@auburn.edu)
*/

import java.util.SortedSet;
import java.util.List;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class LinkedWordSearchGame implements WordSearchGame {
   private TreeSet<String> lexicon;
   private String[][] board;
   
   private boolean[][] visited;
   
   public LinkedWordSearchGame(){
      board = new String[0][0];
   }
   
   @Override
   public void loadLexicon(String fileName){
      if (fileName == null) throw new IllegalArgumentException();
      lexicon = new TreeSet<String>();
      
      Path p = Paths.get(fileName);
      
      Scanner scr;
      try {
         scr = new Scanner(p);      
      } catch (IOException e){
         throw new IllegalArgumentException();
      }
      
      scr.useDelimiter("\n");
      
      while (scr.hasNext()){
         String line = scr.next();
         if (line.length() == 0) continue;
         String word;
         if (line.indexOf(" ") == -1) word = line;
         else word = line.substring(0, line.indexOf(" ")); 
         
         word = word.toUpperCase();
         lexicon.add(word);
      }
      
      scr.close();
   
   }
   
   @Override
   public void setBoard(String[] letterArray){
      if (letterArray == null) throw new IllegalArgumentException("The Letter Array cannot be null");
      if (Math.sqrt(letterArray.length) % 1.0 != 0) throw new IllegalArgumentException("The given letter array must have a length that is a perfect square");
      int size = (int) Math.sqrt(letterArray.length);
      board = new String[size][size];
      
      // Assigns each element in letterArray to board in row-major order
      for (int i = 0; i < letterArray.length; i++){
         board[i / size][(i % size)] = letterArray[i];
      }
      return;
   }
   
   @Override
   public String getBoard(){
      if (board.length == 0) return "";
      String output = "";
      for (String[] row : board){
         for (String word : row){
            output = output + word + " ";
         }
         output = output + "\n";
      }
      
      output = output.substring(0, output.length() - 2);
      return output; 
   }
   
   @Override
   public SortedSet<String> getAllScorableWords(int minimumWordLength){
      if (minimumWordLength < 1) throw new IllegalArgumentException("MinimumWordLength must be positive");
      if (lexicon == null) throw new IllegalStateException("Lexicon has not been loaded");
      SortedSet<String> allScorable = new TreeSet<String>();
      
      for (int y = 0; y < board.length; y++){
         for (int x = 0; x < board[0].length; x++){
            Position start = new Position (x, y);
            getAllScorableWordsDFS(x, y, allScorable, minimumWordLength);
         }
      }
      
   
      return allScorable;
   }
   
   // x - the starting x-index
   // y - the starting y-index
   private void getAllScorableWordsDFS(int x, int y, SortedSet<String> allScorable, int minLength){
      Deque<Position> stack = new ArrayDeque<Position>();
      String letters = "";
      visited = new boolean[board.length][board[0].length];
      
      stack.addFirst(new Position(x, y));
      visited[y][x] = true;
      letters = letters + board[y][x];
      if (isValidWord(letters) && letters.length() >= minLength) allScorable.add(letters);
      if (!isValidPrefix(letters)) {
           Position q = stack.removeFirst();
           letters = letters.substring(0, letters.length() - 1);
         }
      
      Position n = getNextAvailableNeighbor(stack.peekFirst());
      while (!stack.isEmpty() && n != null){
         stack.addFirst(n);
         visited[n.y][n.x] = true;
         letters = letters + board[n.y][n.x];
         if (isValidWord(letters) && letters.length() >= minLength) allScorable.add(letters);
         if (!isValidPrefix(letters)) {
           Position q = stack.removeFirst();
           letters = letters.substring(0, letters.length() - 1);
           
         }
         n = getNextAvailableNeighbor(stack.peekFirst());
      
      }
      
   
   
   }
   
   @Override
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength){return -1;}
   
   @Override
   public boolean isValidWord(String wordToCheck){
      if (wordToCheck == null) throw new IllegalArgumentException("The given wordToCheck is null");
      if (lexicon == null) throw new IllegalStateException("Lexicon has not been loaded");
      if (wordToCheck.length() == 0) return false;
      
      return lexicon.contains(wordToCheck.toUpperCase());
   
   }
   
   @Override
   public boolean isValidPrefix(String prefixToCheck){
      if (prefixToCheck == null) throw new IllegalArgumentException("PrefixToCheck is null");
      if (lexicon == null) throw new IllegalStateException("Lexicon has not been loaded");
      prefixToCheck = prefixToCheck.toUpperCase();
      
      String str = lexicon.ceiling(prefixToCheck);
   
      return str == null ? false : str.contains(prefixToCheck);
   }
   
   @Override
   public List<Integer> isOnBoard(String wordToCheck){
      if (wordToCheck == null) throw new IllegalArgumentException("The given wordToCheck is null");
      if (lexicon == null) throw new IllegalStateException("Lexicon has not been loaded");
      if (wordToCheck.length() == 0) return null;    
      return itrSearchOnBoard(wordToCheck); 
   }
   
   public List<Integer> itrSearchOnBoard(String searchStr){
      int j = 0;
      String firstLetter = searchStr.substring(0, 1);
      while (j < board.length){
         int i = 0;
         while (i < board[0].length){
            if (firstLetter.equalsIgnoreCase(board[j][i])){
               List<Integer> list = itrDepthFirst(i, j, searchStr);
               if (list != null) return list;
            }
            i++;
         }
         j++;
      
      }
      
      return new ArrayList<Integer>();
   
   }
   
   private List<Integer> itrDepthFirst(int startX, int startY, String searchStr){
     Position start = new Position (startX, startY);
     visited = new boolean[board.length][board[0].length];   
     Deque<Position> stack = new ArrayDeque<>();
     stack.addFirst(start);
     visited[startY][startX] = true;
     List<Integer> path = new ArrayList<Integer>();
     int searchIndex = 1;
     
     Position p = start;
     
     while (searchIndex < searchStr.length() && p != null && !stack.isEmpty()) {
         Position position = stack.peekFirst();
         p = getNextAvailableNeighbor(position);
         if (p == null) stack.removeFirst();
         stack.addFirst(p);            
         visited[p.y][p.x] = true;
         if (searchStr.substring(searchIndex, searchIndex + 1).equalsIgnoreCase(board[p.y][p.x])) {
             searchIndex++;
             // Process
         }
         else {
             // Backtrack
             stack.removeFirst();
         }
     }
     
     if (searchIndex < searchStr.length() - 1){
         // Did not find the string
         return null;
     }
     
     List<Integer> locations = new ArrayList<Integer>();
     while (!stack.isEmpty()){
         locations.add(stack.removeLast().toNumber());
     }
     
     return locations;
   }
   
   
   private boolean isVisited(boolean[][] visited, Position p){
      return visited[p.y][p.x];   
   }
   
   private void markAsVisited(Position p){
      visited[p.y][p.x] = true;
   }
   

   
   // Return one open neighbor
   public Position getNextAvailableNeighbor(Position current){
      List<Position> neighbors = new ArrayList<Position>();
      
//         for (int y = -1; y <= 1; y++){
//            for (int x = -1; x <= 1; x++){
//               int newX = current.x + x;
//               int newY = current.y + y;
//               if (!(x == 0 && y == 0) && newX >= 0 && newY >= 0){
//                 System.out.println("test");
//               }
//               if (!(x == 0 && y == 0) && newX >= 0 && newX < board[0].length && newY >= 0 && newY < board.length && visited[newY][newX] == false){
//                  return new Position(newX, newY);
//               }
//            
//            }
//         
//         }
      
       //Right// 
       if (board[0].length > current.x + 1 && visited[current.y][current.x + 1] == false) return new Position(current.x + 1, current.y);
        
        // Left
        if (current.x > 0 && visited[current.y][current.x - 1] == false) return new Position(current.x - 1, current.y);
        
        // Down
        if (board.length > current.y + 1 && visited[current.y + 1][current.x] == false) return new Position(current.x, current.y + 1);
        
        // Up
        if (current.y > 0 && visited[current.y - 1][current.x] == false) return new Position(current.x, current.y - 1);
        
        // Diagonal up and to right
        if (current.y > 0 && current.x < board[0].length - 1 && visited[current.y - 1][current.x + 1] == false) return new Position(current.x + 1, current.y - 1);
        // Diagonal up and to the left
        if (current.x > 0 && current.y > 0 && visited[current.y - 1][current.x - 1] == false) return new Position(current.x - 1, current.y - 1);
        // Diagonal down and to the right
        if (current.x < board[0].length - 1 && current.y < board.length - 1 && visited[current.y + 1][current.x + 1] == false) return new Position(current.x + 1, current.y + 1);
        // Diagonal down and to the left
        if (current.x > 0 && current.y > 0 && visited[current.y - 1][current.x - 1] == false) return new Position(current.x - 1, current.y - 1);
             
   
      return null;
   }
   
   // Return a List of open neighbors. Returns null if all neighbors have already been visited
   public List<Position> getNeighbors(Position current){
      List<Position> neighbors = new ArrayList<Position>();
      // Right
      if (board[0].length > current.x + 1 && visited[current.y][current.x + 1] == false) neighbors.add(new Position(current.x + 1, current.y));
      
      // Left
      if (current.x > 0 && visited[current.y][current.x - 1] == false) neighbors.add(new Position(current.x - 1, current.y));
      
      // Down
      if (board.length > current.y + 1 && visited[current.y + 1][current.x] == false) neighbors.add(new Position(current.x, current.y + 1));
      
      // Up
      if (current.y != 0 && visited[current.y - 1][current.x] == false) neighbors.add(new Position(current.x, current.y - 1));
   
      return neighbors;
   }
   
   public class Position {
      public int x;
      public int y;
      
      public Position (int x, int y){
         this.x = x;
         this.y = y;
      }
      
      public int toNumber(){
         return (y * board[0].length) + x;
      
      }
      
   
   
   
   }

}