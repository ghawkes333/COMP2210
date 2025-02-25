import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Gabriella Hawkes (geh004@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
    public boolean add(T element) {
      if (element == null) return false;
      if (contains(element)) return false;
      
      if (front == null) {
         front = new Node (element);
         rear = front;
         size++;
         return true;
      }
        
      if (element.compareTo(front.element) < 0){
         // Add to front of pointer chain
         Node n = new Node(element);
         n.next = front;
         n.next.prev = n;
         front = n;
         size++;
         return true;
      }
      
      Node p = front;
      
      while (p != null){
         if (p.next == null && element.compareTo(p.element) > 0){
            // Add element to end of pointer chain
            Node n = new Node(element);
            n.prev = p;
            p.next = n;
            rear = n;
            size++;
            return true;
         } else if (element.compareTo(p.element) > 0 && element.compareTo(p.next.element) < 0){
            // Add element between two existing elements in pointer chain
            Node n = new Node(element);
            n.next = p.next;
            n.prev = p;
            p.next.prev = n;
            p.next = n;
            size++;
            return true;
         }
         p = p.next;
      }
      
      return false;
    }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
    public boolean remove(T element) {
        if (element == null || !contains(element)) return false;
        
        Node p = front;
        while (p != null){
         if(p.element.equals(element)){
            if (p.next != null) p.next.prev = p.prev;
            if (p.prev != null) p.prev.next = p.next;
            else front = p.next;
            return true;
         }
         p = p.next;
        }
        
        return false;
        
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */
    public boolean contains(T element) {
        Node p = front;
        while (p != null){
         if (p.element.equals(element)){
            return true;
         }
         p = p.next;
        }
        return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(Set<T> s) {
        if (s.size() != this.size()) return false;
        for (T a : s){
           boolean found = false;
           for (T b : this){
               System.out.println(a + " " + b);
               if (b.equals(a)){
                  found = true;
                  break;
               }
           }
           if (found == false) return false;
        }
        
        return true;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
    public boolean equals(LinkedSet<T> s) {
        if (s == null) return false;
        if (s.size() != size()) return false;
        
        Node pointer = front;
        Node sPointer = s.front;
        
        while (pointer != null){
            if (!pointer.element.equals(sPointer.element)) return false;
            pointer = pointer.next;
            sPointer = sPointer.next;
        }
        
        return true;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(Set<T> s){
        if (s == null) return this;
        LinkedSet<T> ls = new LinkedSet<T>();
        
        for (T element : this) {
         ls.add(element);
        }
        
        for (T element : s) {
         ls.add(element);
        }
        
        return ls;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
    public Set<T> union(LinkedSet<T> s){
        if (s == null) return this;
        
        LinkedSet<T> union = new LinkedSet<T>();
        Node pThis = rear;
        Node pParam = s.rear;
        
        while (pThis != null || pParam != null){
            if (pThis == null){
               union.add(pParam.element);
               pParam = pParam.prev;
            } else if (pParam == null) {
               union.add(pThis.element);
               pThis = pThis.prev;            
            } else if (pParam.element.compareTo(pThis.element) > 0){
               union.add(pParam.element);
               pParam = pParam.prev;               
            } else {
               union.add(pThis.element);
               pThis = pThis.prev;          
               
            }                  
            
            
        }
        
        return union;
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
    public Set<T> intersection(Set<T> s) {
      if (s == null) {
         Set<T> output = new LinkedSet<T>();
         return output;
      }
            
      LinkedSet<T> ls = new LinkedSet<T>();
      for (T a : s){
         for (T b : this){
            if (b.equals(a)) ls.add(a);
         }
      
      }
      
      return ls;
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */
    public Set<T> intersection(LinkedSet<T> s) {
      if (s == null || s.front == null) {
         Set<T> output = new LinkedSet<T>();
         return output;
      }
      
      LinkedSet<T> ls = new LinkedSet<T>();
      
      Node pointerA;
      Node pointerB;
      if (s.front.element.compareTo(this.front.element) > 0){
         pointerA = s.front;
         pointerB = this.front;
      } else {
         pointerA = this.front;    
         pointerB = s.front;
      }
      
      while (pointerA != null && pointerB != null){
         if (pointerA.element.equals(pointerB.element)){
            ls.add(pointerA.element);
            pointerA = pointerA.next;
            pointerB = pointerB.next;
         } else if (pointerA.element.compareTo(pointerB.element) > 0){
            pointerB = pointerB.next;         
         
         } else if (pointerA.element.compareTo(pointerB.element) < 0){
            pointerA = pointerA.next;
         }
      
      }
      
      return ls;      
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
    public Set<T> complement(Set<T> s) {
        if (s == null) return null;
        LinkedSet<T> ls = new LinkedSet<T>();
        for (T element : this){
            if (!s.contains(element)){
               ls.add(element);
            }
        }
        
        return ls;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
    public Set<T> complement(LinkedSet<T> s) {
        if (s == null || s.front == null) return this;
        
        Node thisP = front;
        Node sP = s.front;
        
        LinkedSet<T> ls = new LinkedSet<T>();
        
        while (thisP != null){
            if (sP == null){
               
            }
            int compareResult = sP.element.compareTo(thisP.element);
            if (compareResult == 0){
               thisP = thisP.next;
               sP = sP.next;
            } else if (compareResult < 0 && (sP.next == null || sP.next.element.compareTo(thisP.element) > 0)){
               ls.add(thisP.element);
               thisP = thisP.next;
               sP = sP.next;            
            } else if(compareResult > 0){
               ls.add(thisP.element);
               thisP = thisP.next;            
            }
        }
        
        return ls;
        
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> iterator() {
        return new Iterator<T>(){
             private Node pointer = front;
             
             @Override
             public boolean hasNext(){
                return pointer != null;
             }
             
             @Override
             public T next(){
               if(pointer == null) throw new NoSuchElementException();
                T element = pointer.element;
                pointer = pointer.next;
                return element;
             }
         
         };
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
    public Iterator<T> descendingIterator() {
        return new Iterator<T>(){
            private Node p = rear;
            
            @Override
            public boolean hasNext(){
               if (p == null) return false;
               return p != null;
            }
            
            @Override
            public T next(){
               if (p == null) throw new NoSuchElementException();
               T element = p.element;
               p = p.prev;
               return element;            
            }
        
        
        };
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
    public Iterator<Set<T>> powerSetIterator() {
        return new LinkedSetPowerSetIterator();
    }
       
   private class LinkedSetPowerSetIterator implements Iterator<Set<T>> {
       // cardinality of this set
       int N;
   
       // cardinality of the power set (2^N)
       int M;
   
       // the integer identifier of the current subset, i.e. the current element
       // of the power set. Legal values range from 0..M-1 inclusive.
       int current;
   
       public LinkedSetPowerSetIterator() {
         N = size();
         M = (int) Math.pow(2, N);
         current = 0;
       }
   
       public boolean hasNext() {
           if (M == 1) return false;
           return current < M;
       }
   
       public Set<T> next() {
           LinkedSet<T> s = new LinkedSet<T>();
           char[] bitstring = Integer.toBinaryString(current).toCharArray();
   
           // iterate from right to left over bitstring and the internal
           // linked list to ensure that the call to add will insert a new
           // first node (constant time)
           
           LinkedSet<T> ls = new LinkedSet<T>();
           Node n = rear;
           for (int i = bitstring.length - 1; i >= 0; i--){
               if (bitstring[i] == '1'){
                  ls.add(n.element);
               }
               n = n.prev;
           
           }
   
           current = current + 1;
           return ls;
       }
   
       public void remove() {
   
       }
} 



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.

    ////////////////////
    // Nested classes //
    ////////////////////

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

}
