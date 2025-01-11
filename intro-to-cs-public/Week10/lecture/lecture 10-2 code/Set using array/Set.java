/** Represents a set of int values.
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
        	// If the element is found, assigns it to the last element
			// and reduced the set's size.
            if (elements[i] == e) {
                elements[i] = elements[--size];
                return;
            }
        }
    }

	/** Returns a set which is the intersection of this set and the other set.
	 *  (Does not change this set or the other set). */
	public Set intersection(Set other) {
        Set result = new Set();
        for (int e : elements) {
            if (other.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /** Returns a set which is the union of this set and the other set.
	 *  (Does not change this set or the other set). */
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
}
