import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {

   private String query;
   private Long weight;

    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String query, long weight) {
      if (query == null) throw new NullPointerException();
      if (weight < 0) throw new IllegalArgumentException();
      this.query = query;
      this.weight = weight;
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() {
      return new Comparator<Term>(){
         @Override
         public int compare(Term t1, Term t2){
            return Long.compare(t2.weight, t1.weight);
         }
         
      
      };
    
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) {
      if (length <= 0) throw new IllegalArgumentException();     
      
      return new Comparator<Term>(){
         @Override
         public int compare (Term t1, Term t2){
            int lengthT1;
            int lengthT2;
            if (t1.query.length() < length) lengthT1 = t1.query.length();
            else lengthT1 = length;
            
            if (t2.query.length() < length) lengthT2 = t2.query.length();
            else lengthT2 = length;
            
            System.out.println(t1.query.substring(0, lengthT1));
            System.out.println(t2.query.substring(0, lengthT2));

            return t1.query.substring(0, lengthT1).compareTo(t2.query.substring(0, lengthT2));
         
         }
      
      };
    }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) {
      if (other == null || other.query == null || this.query == null) throw new IllegalArgumentException();
      
      int length = 0;
      if (this.query.length() > other.query.length()) length = this.query.length();
      else length = other.query.length();
      
      
      Comparator<Term> comp = byPrefixOrder(length);
      return comp.compare(this, other);
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString(){
      return query + "\t" + weight;
    }
    
    
}

