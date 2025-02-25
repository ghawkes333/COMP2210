import java.util.Arrays;


/**
 * Autocomplete.
 */
public class Autocomplete {

	private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) {
   
      if (terms == null) throw new NullPointerException();
      
      this.terms = terms;
      
      Arrays.sort(this.terms);
	
    }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
    
    /*
    Strategy: Binary Search - Check if middle term is the first term in the list to start with the given prefix. If the given prefix comes after the middle term, repeat on right side. If it comes before, repeat on left side. If it doesn't exist, return []
       Then, find the end term: Check the middle term between the found "beginning index" and the end of array is the last term with the prefix. If so, return the array from the beginning to end. If the prefix comes after the middle term, repeat on right side of the array. If the prefix comes before, left side. 
       
       Alg: 
       1) firstIndexOf(terms, prefix, comparator)
       1) lastIndexOf(terms, prefix, comparator)
       3) create Arrays.copyOf()
       4) sort and return the array
    */
	public Term[] allMatches(String prefix) {
      if (prefix == null) throw new NullPointerException();
      
      Term p = new Term(prefix, 0);
      int firstIndex = BinarySearch.firstIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
      int lastIndex = BinarySearch.lastIndexOf(terms, p, Term.byPrefixOrder(prefix.length()));
      
      Term[] result = Arrays.copyOfRange(terms, firstIndex, lastIndex + 1);
      Arrays.sort(result, Term.byDescendingWeightOrder());

      
      return result;
      
      }

}

