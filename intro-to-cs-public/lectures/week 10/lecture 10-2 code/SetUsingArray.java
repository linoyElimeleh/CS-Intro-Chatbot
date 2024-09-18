/** Represents a collection of int values.
 *  A set is a collection of values without repetition or order.
 *  The set has an unlimited size. */
public class Set {
	
	// Initial capacity of this set
	private static final int MAX_SIZE = 100;
	
	// The elements of this set, in no particular order, and no gaps
	private int[] elements; 
	
	// Current number of elements of this set
	private int size;	
	
	/** Constructs an empty set. */
	public Set() {
        elements = new int[MAX_SIZE];
        size = 0;
    }

	/** Returns true if the given element exists in this set, false otherwise. */
	public boolean contains(int e) {
        for (int element : elements) {
            if (element == e) {
                return true;
            }
        }
        return false;
    }

    /** If the given element is not in this set, adds it to this set.
	 *  Otherwise, does nothing. */
	public void add(int e) {
        if (!contains(e)) {
            if (size == MAX_SIZE) {
            	doubleTheSize();
            }
            elements[size++] = e;
        }
    }

    private void doubleTheSize() {
		int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    /** Creates a set containing the elements in the given array. */
	public Set(int[] arr) {
        this();
        for (int e : arr) {
            add(e);
        }
    }
	
	/** If the given element is in this set, removes it.
	 *  Otherwise, does nothing. */
	public void remove(int e) {
        for (int i = 0; i < size; i++) {
        	// If the element is found, sets it to the last element
            if (elements[i] == e) {
                elements[i] = elements[--size];
                return;
            }
        }
    }

	/** Returns a set which is the intersection of this set and the other set. */
	public Set intersection(Set other) {
        Set result = new Set();
        for (int e : elements) {
            if (other.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /** Returns a set which is the union of this set and the other set. */
	public Set union(Set other) {
		// Creates a new set from the elements of this set
		Set result = new Set(elements);
		for (int e : other.elements) {
			result.add(e);
		}       
        return result;
    }

	/** Returns a string representing this set in the form of
	 *  {e1, e2, e3, ...}, where the e's are the set elements. */
	public String toString() {		
		if (size == 0) {
			return "{}";
		}
		StringBuilder s = new StringBuilder("{");
		// Appends all the elements except for the last one
		for (int i = 0; i < (size - 1); i++) {
			s.append(elements[i] + ", ");
		}
		// Appends the last element
		return s.append(elements[size - 1] + "}").toString();
	}
	
	public static void main(String args[]) {
		Set s1 = new Set();
		s1.add(3); s1.add(1); s1.add(3); s1.add(7); s1.add(5); 
		System.out.println("\ns1 = " + s1);

		int[] data = {7, 1, 7, 8, 1, 7};
		Set s2 = new Set(data);
		System.out.println("s2 = " + s2);	
		
		System.out.println("\nIntersection of s1 and s2 = " + s1.intersection(s2));
		System.out.println("Union of s1 and s2 = " + s1.union(s2));		

		s2.remove(1);
		System.out.println("\ns2 after removing 1 = " + s2);
		s2.remove(8);
		System.out.println("s2 after removing 8 = " + s2);
		s2.remove(7);
        System.out.println("s2 after removing 7 = " + s2); 
	}
}
