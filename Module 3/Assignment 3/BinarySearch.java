import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
     
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) throw new NullPointerException(); 
      if (a.length == 0) return -1;
      
      return locateFirstIndex(0, a.length - 1, a, key, comparator);
 
    }
    
    private static <Key> int locateFirstIndex (int begin, int end, Key[] a, Key key, Comparator<Key> comparator){
      if (begin > end) return -1;
      int mid = (begin + end) / 2;
      int result = comparator.compare(key, a[mid]);
      if (result == 0 && (mid == 0 || comparator.compare(a[mid], a[mid - 1]) != 0)){
          return mid;
       }
      else if (result == 0) return locateFirstIndex(begin, mid - 1, a, key, comparator);
      else if (result < 0) return locateFirstIndex(begin, mid - 1, a, key, comparator);
      else if (result > 0) return locateFirstIndex(mid + 1, end, a, key, comparator);
    
      return -1;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
     
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      if (a == null || key == null || comparator == null) throw new NullPointerException();
      if (a.length == 0) return -1;
      
      return locateLastIndex(0, a.length - 1, a, key, comparator);
    }
    
    private static <Key> int locateLastIndex (int begin, int end, Key[] a, Key key, Comparator<Key> comparator){
      if (begin > end) return -1;
      int mid = (begin + end) / 2;
      int result = comparator.compare(key, a[mid]);
      if (result == 0 && (mid == a.length - 1 || comparator.compare(a[mid], a[mid + 1]) != 0)) return mid;
      else if (result == 0) return locateLastIndex(mid + 1, end, a, key, comparator);
      else if (result < 0) return locateLastIndex(begin, mid - 1, a, key, comparator);
      else if (result > 0) return locateLastIndex(mid + 1, end, a, key, comparator);
    
      return -1;
    }

}
