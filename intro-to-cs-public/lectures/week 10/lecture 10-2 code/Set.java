/** Represents a set of int values.
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

    /** Creates a set containing the elements in the given array. */
	public Set(int[] arr) {
        this();
		// Iterates over the given array and adds its elements to this set
        for (int e : arr) {
            add(e);
        }
    }

	/** Creates a set containing the elements in the given set. */
	public Set(Set set) {
    	this();
		// Iterates over the set and adds its elements to this set
        ListIterator itr = set.elements.listIterator();
		while (itr.hasNext()) {
			int e = itr.next();
			add(e);
        }
    }

	/** Returns a set which is the union of this set and the other set. */
	public Set union(Set other) {
		// Creats a result set with the elements of this set
	    Set result = new Set(this);
		// Iterates over the other set and adds ite elements to the result  set
		ListIterator itr = other.elements.listIterator();
		while (itr.hasNext()) {
			int e = itr.next();
			result.add(e);
        }
        return result;
    }

	/** Returns a set which is the intersection of this set and the other set. */
	public Set intersection(Set other) {
        Set result = new Set();
		// For each element in this set, checks if it exists also in the other set.
		// If so, adds it to the result set.
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
	
	public static void main(String args[]) {
		Set s1 = new Set();
		s1.add(3); s1.add(1); s1.add(3); s1.add(5); s1.add(7);  
		System.out.println("\ns1 = " + s1);

		int[] data = {7, 9, 1, 9, 1, 7};
		Set s2 = new Set(data);
		System.out.println("s2 = " + s2);	

		Set s3 = new Set(s2);
        System.out.println("s3 = " + s3);	
	    
		System.out.println("\nUnion of s1 and s2 = " + s1.union(s2));	
		System.out.println("Intersection of s1 and s2 = " + s1.intersection(s2));	
	}
}
