/** Represents a set of integers.
 *  A set is a collection of values without repetition or order.
 *  The set has an unlimited size. */
public class Set {

	private List elements;  // The elements of this set
			
	/** Constructs an empty set. */
	public Set() {
        elements = new List();
    }

	/** Checks if the given element exists in this set. */
	public boolean contains(int e) {
		return (elements.indexOf(e) > -1);
    }

    /** If the given element is not in this set, adds it to this set.
	 *  Otherwise, does nothing. */
	public void add(int e) {
		if (!contains(e)) {
           elements.add(e);
		}
	}

	/** Adds the array elements to this list */
	public void add(int[] arr) {
		// Iterates over the given array and adds its elements to this set
        for (int e : arr) {
            add(e);
        }
	}

    /** Creates a set containing the elements in the given array. */
	public Set(int[] arr) {
        this();
		add(arr);
    }

	//Creates a set containing the elements in the given set.
	public Set(Set other) {
    	this();
		// Iterates over the set and adds its elements to this set
        ListIterator itr = other.elements.listIterator();
		while (itr.hasNext()) {
			int e = itr.next();
			add(e);
        }
    }

	/** Returns a set which is the union of this set and the other set.
	 *  (Does not change this set or the other set). */
	public Set union(Set other) {
		// Creats a result set with the elements of this set
	    Set result = new Set(this);
		// Iterates over the other set and adds ite elements to the result set
		ListIterator itr = other.elements.listIterator();
		while (itr.hasNext()) {
			int e = itr.next();
			result.add(e);
        }
        return result;
    }

	/** Returns a set which is the intersection of this set and the other set.
	 *  (Does not change this set or the other set). */
	public Set intersection(Set other) {
        Set result = new Set();
		// For each element in this set, if the other set contains it, adds it
		ListIterator itr = elements.listIterator();
		while (itr.hasNext()) {
			int e = itr.next(); 
            if (other.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

	/** Returns a string representing this set in the form of
	 *  {e1, e2, e3, ...}, where the e's are the set elements. */
	public String toString() {	
		String s = elements.toString();
		// From a string like (3 5 7), generates the string {3, 5, 7}
		s = s.replace(" ", ", ");
		s = s.replace("(", "{").replace(")","}");
		return s;
	}
}
