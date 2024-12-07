/** A library of operations on sets.
 *  A set is a collection of values without repetition and without order.
 *  For example, 2, 5, 2, 7 is not a set. {2, 5, 7} is a set.
 *  The order of the elements in the set is insignificant.
 *  For example, {2, 5, 7} is the same set as {5, 7, 2}.
 * 
 *  In this implementation sets are represented as arrays of integers. */

public class Sets {
	
	public static void main(String[] args) {

	    // Creates and prints three sets
	    int[] s1 = { 2, 5, 3, 7 };
	    System.out.print("s1 = "); println(s1);

	    int[] s2 = { 7, 9, 2 };
	    System.out.print("s2 = "); println(s2);

	    int[] s3 = { 5, 7 };
	    System.out.print("s3 = "); println(s3);

	    // Tests the elementOf function:
	    System.out.println("5 is an element of s1: " + elementOf(5, s1));
	    System.out.println("8 is an element of s1: " + elementOf(8, s1));

	    // Tests the subsetOf function:
	    System.out.println("s3 is a subset of s1: " + subsetOf(s3, s1));
	    System.out.println("s3 is a subset of s2: " + subsetOf(s3, s2));

	    // Tests the append function:
	    System.out.print("The set resulting from s2 and 9 appended: "); println(append(s2, 9));
	    System.out.print("The set resulting from s2 and 5 appended: "); println(append(s2, 5));
	  
	    // Prints the union of s1 and s2:
	    System.out.print("Union of s1 and s2 = ");
	    println(union(s1, s2));

	    // Prints the intersection of s1 and s2:
	    System.out.print("Intersection of s1 and s2 = ");
	    println(intersection(s1, s2));	    
    }

	/** Checks if the value e appears in the set. 
	 *  For example, if the set is { 7, 2, 5 } and the value is 2, returns true.
	 *               if the set is { 7, 2, 5 } and the value is 3, returns false. */
	public static boolean elementOf(int e, int[] set) {
		for (int i = 0; i < set.length; i++) {
			if (e == set[i]){
				return true;
			}
		}
		return false;
	}

	/** Checks if set1 is a subset of set2.
	 *  Set1 is a subset of set2 if every element of set1 is an element of set2. */
	public static boolean subsetOf(int[] set1, int[] set2) {
		for (int i = 0; i < set1.length; i++) {
			if (!elementOf(set1[i], set2)){
				return false;
			}
		}
		return true;
	}
	
	/** Appends (adds) the value e to the set.
	 *  If e exists in the set, returns the set (a set cannot have duplicate values).
	 *  Otherwise returns a set containing all the elements of the set, and e. */
	public static int[] append(int[] set, int e) {
		if (elementOf(e, set)) {
			return set;
		}
		int[] newSet = new int[set.length + 1];
		for (int i = 0; i < (newSet.length - 1); i++) {
			newSet[i] = set[i];
		}
		newSet[newSet.length - 1] = e;
        return newSet;
	}
	
	/** Returns the union of the two sets.
	 *  The union of set1 and set2 is the set containing all the elements of set1
	 *  and all the elements of set2, without repetitions. */ 
	public static int[] union(int[] set1, int[] set2) {	
		// Creates a temporary array whose size is the maximal possible size of the union
		int[] temp = new int[set1.length + set2.length];
		
		// Adds the elements of the first set
		for (int i = 0; i < set1.length; i++) {
			temp[i] = set1[i];
		}
		int size =  set1.length;
		
		// Adds the elements of the second set that are not members of the first set
		for (int i = 0; i < set2.length; i++) {
			if (!elementOf(set2[i], set1)) {
				temp[size] = set2[i];
				size++;
			}
		}
		
		// Creates and returns a new array that has the right size
		int[] union = new int[size];
		for (int i = 0; i < size; i++) {
			union[i] = temp[i];
		}
		return union;
	}
	
	/** Returns the intersection of the two sets.
	 *  The intersection of set1 and set2 is the set containing all the elements of set1
	 *  that are also elements of set2. */ 
	public static int[] intersection (int[] set1, int[] set2) {
		// Creates a temporary array whose size is the size of the smaller set
		int[] temp = new int[Math.min(set1.length, set2.length)];
		int size = 0;
		for (int i = 0; i < set1.length; i++) {
			if (elementOf(set1[i], set2)) {
				temp[size] = set1[i];
				size++;
			}
		}
		
		// Creates and returns an array of the right size
		int[] intersection = new int[size];
		for (int j = 0; j < intersection.length; j++) {
			intersection[j] = temp[j];
		}
		return intersection;
	}
	
	/** Prints the elements of the set, starting and ending with curly brackets.
     *   For example, if the set contains the elements 7, 2, 1, prints { 7, 2, 1 }. */
	public static void println(int[] set) {
		int n = set.length;
		System.out.print("{");
		for (int i = 0; i < (n - 1); i++) {
			System.out.print(" " + set[i] + ",");
		}
		System.out.println(" " + set[n - 1] + " }");
	}
}