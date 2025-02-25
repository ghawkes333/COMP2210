import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Gabriella Hawkes (geh0042@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  August 30, 2022
*
*/
public final class Selector {

    /**
     * Can't instantiate this class.
     *
     * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
     *
     */
    private Selector() { }


     //TODO: REVIEW REQUIREMENTS AND CHECK ALL ARE MET

    /**
     * Selects the minimum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int min(int[] a) {
        if (a == null) throw new IllegalArgumentException();
        if (a.length == 0) throw new IllegalArgumentException();
        
        int minValue = a[0];
        for (int val : a){
            if(val < minValue){
                minValue = val;
            }
        }

        return minValue;
    }


    /**
     * Selects the maximum value from the array a. This method
     * throws IllegalArgumentException if a is null or has zero
     * length. The array a is not changed by this method.
     */
    public static int max(int[] a) {
        if (a == null) throw new IllegalArgumentException();
        if (a.length == 0) throw new IllegalArgumentException();
        
        int maxValue = a[0];
        for (int val : a){
            if(val > maxValue){
                maxValue = val;
            }
        }

        return maxValue;
    }


    /**
     * Selects the kth minimum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth minimum value. Note that there is no kth
     * minimum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.
     
     Strategy: Linear scan
     
     Alg: 
     - Check for valid a and k (besides if k is larger than the number of distinct values) - Ex null a, empty a, k is equal to  than the boundary values (?) - no because the alg doesn't change k (but good thing to test)
     - Copy a into a second array
     - Sort the second array
      Create a counter
      Iterate thru the second array. Increment counter if there are elements left in the array. 
       Increment counter if the current element is different than the element before it (skip if it's the current element is the first element)
      Stop if counter == k.
      throw exception if you run off the end of the array
     */
    public static int kmax(int[] a, int k) {
        // Check that a is valid
        if (a == null) throw new IllegalArgumentException();
        if (a.length == 0) throw new IllegalArgumentException();
        
        // Check that k is valid
        if (k < 1 || k > a.length) throw new IllegalArgumentException();
        
        int[] b = Arrays.copyOf(a, a.length);
        
        Arrays.sort(b);

        
        // Remove duplicates
        int[] c = Arrays.copyOf(b, b.length);
        int countCLen = 0;
        for (int i = 0; i < b.length; i++){
         int val = b[i];
         int j = i;
         c[countCLen] = val;
         countCLen++;
         while (j < b.length && val == b[j]){
            i = j;
            j++;
         }
         
        }
        
        int[] d = Arrays.copyOf(c, countCLen);
        
        if(k-1 < d.length) return d[k-1];
        else throw new IllegalArgumentException();
                
    }


    /**
     * Selects the kth maximum value from the array a. This method
     * throws IllegalArgumentException if a is null, has zero length,
     * or if there is no kth maximum value. Note that there is no kth
     * maximum value if k < 1, k > a.length, or if k is larger than
     * the number of distinct values in the array. The array a is not
     * changed by this method.

     */
    public static int kmin(int[] a, int k) {
        // Check that a is valid
        if (a == null) throw new IllegalArgumentException();
        if (a.length == 0) throw new IllegalArgumentException();
        
        // Check that k is valid
        if (k < 1 || k > a.length) throw new IllegalArgumentException();
        
        int[] z = Arrays.copyOf(a, a.length);
        
        Arrays.sort(z);
        int[] b = new int[z.length];
        
        int q = 0;
        for(int i = b.length - 1; i >=0; i--){
         b[q] = z[i];
         q++;
        }
        
        // Remove duplicates
        int[] c = Arrays.copyOf(b, b.length);
        int countCLen = 0;
        for (int i = 0; i < b.length; i++){
         int val = b[i];
         int j = i;
         c[countCLen] = val;
         countCLen++;
         while (j < b.length && val == b[j]){
            i = j;
            j++;
         }
         
        }
        
        int[] d = Arrays.copyOf(c, countCLen);
        
        if(k-1 < d.length) return d[k-1];
        else throw new IllegalArgumentException();
                
    }


    /**
     * Returns an array containing all the values in a in the
     * range [low..high]; that is, all the values that are greater
     * than or equal to low and less than or equal to high,
     * including duplicate values. The length of the returned array
     * is the same as the number of values in the range [low..high].
     * If there are no qualifying values, this method returns a
     * zero-length array. Note that low and high do not have
     * to be actual values in a. This method throws an
     * IllegalArgumentException if a is null or has zero length.
     * The array a is not changed by this method.
     
     Strategy: linear scan

      Algorithm:
      Create a new array temp with the same length as a
      Create counter integer count and set to 0
      Loop through each value in a
          If the current value is >= low and <= high, then set that value in b at index count
      Create a new array with length count + 1
      Use Arrays method Arrays.(Array source, int start, int end)
     */
    public static int[] range(int[] a, int low, int high) {
    if (a == null) throw new IllegalArgumentException();
    if (a.length == 0) throw new IllegalArgumentException();
    
      int[] temp = new int[a.length];
      int count = 0;
      for (int val : a){
         if (val >= low && val <= high){
            temp[count] = val;
            count++;
         }
      
      }
      
      return Arrays.copyOf(temp, count);
    }


    /**
     * Returns the smallest value in a that is greater than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     
     Strategy: linear scan
     Alg: 
         - Create var smallestValue
         - loop through the array
         - If the current value is < smallestValue and > the key, then store in smallestValue
         - return smallestValue
     */
    public static int ceiling(int[] a, int key) {
        if (a == null) throw new IllegalArgumentException(); 
        if (a.length == 0) throw new IllegalArgumentException();
        
        int smallestVal = a[0];
        for (int val : a){
         if (val <= smallestVal && val >= key) smallestVal = val;
        }
        
        return smallestVal;
    }


    /**
     * Returns the largest value in a that is less than or equal to
     * the given key. This method throws an IllegalArgumentException if
     * a is null or has zero length, or if there is no qualifying
     * value. Note that key does not have to be an actual value in a.
     * The array a is not changed by this method.
     
          Strategy: linear scan
     Alg: 
         - Check that a is valid
         - Create var largestVal
         - loop through the array
         - If the current value is > largestVal and < the key, then store in largestVal
         - return largestVal
     */
    public static int floor(int[] a, int key) {
        if (a == null) throw new IllegalArgumentException(); 
        if (a.length == 0) throw new IllegalArgumentException();
        
        int largestVal = a[0];
        for (int val : a){
         if (val > largestVal && val <= key) largestVal = val;
        }
        if(largestVal > key) throw new IllegalArgumentException();
        
        return largestVal;
    }

}
