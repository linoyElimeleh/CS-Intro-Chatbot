/** This class features operations on sets that contain integer values.
 *  A set is a collection of values without repetition.
 *  For example, 2, 5, 2, 7 is not a set. {2, 5, 7} is a set.
 *  The order of the elements in the set is insignificant.
 *  For example, {2, 5, 7} is the same set as {5, 7, 2}.
 * 
 *  In this implementation sets are represented as arrays of integers. 
 *  In particular, a set that contains N elements is implemented by an
 *  int[] array of size N. */

public class Sets {
	
	public static void main(String[] args) {

		// Tests the arrayCopy function:
		System.out.print("Tests the arrayCopy function:");
	    int[] b1 = { 2, 5, 3 };
	    int[] b2 = new int[5];
	    System.out.print("b1 = "); println(b1);
	    System.out.print("b2 = "); println(b2);
	    arrayCopy(b1, b2);
	    System.out.print("b2 = "); println(b2);

	    // Creates two sets using the buildSet function:
	    int[] a1 = { 2, 5, 3, 2, 7, 5 };
	    int[] s1 = buildSet(a1);
	    System.out.print("s1 = ");
	    println(s1);

	    int[] a2 = { 7, 5, 5, 6, 7 };
	    int[] s2 = buildSet(a2);
	    System.out.print("s2 = ");
	    println(s2);

	    // Tests the elementOf function:
	    System.out.println("5 is an element of s1: " + elementOf(5, s1));
	    System.out.println("8 is an element of s1: " + elementOf(8, s1));

        // Tests the append function:
        // b1 = { 2, 5, 3 };
	    System.out.print("b1 = "); println(b1);
	    System.out.println("Inserting 5 to b1...");
	    b1 = append(b1, 5);
	    System.out.print("b1 = "); println(b1); 
	    System.out.println("appending 7 to b1...");
	    b1 = append(b1, 7);
	    System.out.print("b1 = "); println(b1); 
	  
	    // Prints the intersection of s1 and s2:
	    System.out.print("Intersection of s1 and s2 = ");
	    println(intersection(s1,s2));

	    // Prints the union of s1 and s2:
	    System.out.print("Union  of s1 and s2 = ");
	    println(union(s1, s2));

	    // Prints the union of s1 and s2 (testing union1):
	    System.out.print("Union1 of s1 and s2 = ");
	    println(union1(s1, s2));

	    // Prints the union of s1 and s2 (testing union2):
	    System.out.print("Union2 of s1 and s2 = ");
	    println(union2(s1, s2));

	    // Tests the random function:
	    System.out.println("A random value drawn from the set s1: " + random(s1));
    }

	/** Checks if the given element exists in the given set. */
	public static boolean elementOf(int e, int[] set) {
		for (int i = 0; i < set.length; i++) {
			if (e == set[i]){
				return true;
			}
		}
		return false;
	}

	/** Checks if set1 is a subset of set2.
	 *  Set1 is a subset of set2 is every element of set1 is also an element of set2. */
	public static boolean subsetOf(int[] set1, int[] set2) {
		for (int i = 0; i < set1.length; i++) {
			if (!elementOf(set1[i], set2)){
				return false;
			}
		}
		return true;
	}
	
	/** Checks if two sets are equal.
	 *  Set1 equals set2 if set1 is a subset of set2 and set2 is a subset of set1. */
	public static boolean equals(int[] set1, int[]set2) {
		return subsetOf(set1, set2) && subsetOf(set2, set1);
	}
	
	/** Appends (adds) the given element to the given set.
	 *  If e exists in the set, returns the set (a set cannot have duplicate values).
	 *  Otherwise returns an array containing all the elements of the original set, and e. */
	public static int[] append(int[] set, int e) {
		if (elementOf(e, set)) {
			return set;
		}
		int[] newSet = new int[set.length + 1];
		arrayCopy(set, newSet);
		newSet[set.length] = e;
		return newSet;
	}
	
	/** Returns the union of two sets. */
	public static int[] union(int[] set1, int[]set2) {	
		// Creates a temporary array whose size is the maximal possible size of the union
		int[] temp = new int[set1.length + set2.length];
		
		// Adds the elements of the first set
		arrayCopy(set1, temp);
		int size =  set1.length;
		
		// Adds the elements of the second set that are not members of the first set
		for (int i = 0; i < set2.length; i++) {
			if (!elementOf(set2[i], set1)){
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
	
	/** Returns the union of two sets.
	 *  This implementation uses the append function, and is less efficient. */
	public static int[] union1(int[] set1, int[] set2) {
		int[] union = new int[set1.length];
		arrayCopy(set1, union);
		for (int i = 0; i < set2.length; i++) {
			union = append(union, set2[i]);
		}
		return union;
	}
	
	/** Returns the union of two sets.
     *  This implementation uses the BuildSet function. */
	public static int[] union2(int[] set1, int[]set2) {
		// Creates a temporary array whose size is the maximal possible size of the union
		int[] temp = new int[set1.length + set2.length];
		for (int i = 0; i < temp.length; i++) {
			if (i < set1.length){
				temp[i] = set1[i];
			} else {
				temp[i] = set2[i - set1.length];
			}
		}
		return buildSet(temp);
	}
	
	/** Returns the intersection of two sets. */
	public static int[] intersection (int[] set1, int[] set2) {
		// Creates a temporary array whose size is the size of the smaller set
		int[] temp = new int[Math.min(set1.length, set2.length)];
		int size = 0;
		for (i = 0; i < set1.length; i++) {
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
	
	/**
	 * Returns the difference of two sets, i.e. a set consisting of all the elements 
	 * of set1 which are not elements of set2.	 
	 */
	public static int[] difference (int[] set1, int[]set2) {
		// Creates a temporary array 
		int[] temp = new int [set1.length];
		int size = 0;
		for (int i = 0; i < set1.length; i++) {
			if(!elementOf(set1[i], set2)){
				temp[size] = set1[i];
				size++;
			}
		}
		
		// Creates and returns an array of the right size
		int[] difference = new int[size];
		for (int i = 0; i < difference.length; i++) {
			difference[i] = temp[i];
		}
		return difference;
	}
	
	
	/**
	 * Returns the difference of two sets.
	 * This implementation uses the append function. 
	 */
	public static int[] difference1 (int[] set1, int[] set2){
		int[] newSet = new int[0];
		for (int i = 0; i < newSet.length; i++) {
			if(!elementOf(set1[i], set2)){
				newSet = append(newSet, set1[i]);
			}
		}
		return newSet;
	}
	
	public static int[] buildSet(int[] arr) {
		// Creates a temp array that contains only the unique element of the given array.
		int[] temp = new int[arr.length];
		int size = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean found = false;
			for (int j = 0; j < size; j++) {
				found = found || arr[i] == temp[j];
			}
			if (!found) {
				temp[size] = arr[i];
				size++;
			}
		}
		
		// Creates and returns an array of the right size.
		int[] set = new int[size];
		for (int i = 0; i < size; i++) {
			set[i] = temp[i];
		}
		return set;
	}
	
	/**
	 * Builds a set from a given array.
	 * Only distinct elements are added to the set.
	 */
	public static int[] buildSet1 (int[] arr) {
		int[] temp = new int[arr.length];
		int currentPlace = 0;
		for (int i = 0; i < temp.length; i++) {
			boolean found = false;
			for (int j = 0; j < currentPlace; j++) {
				found = found || arr[i] == temp[j];
			}
			if(!found) {
				temp[currentPlace] = arr[i];
				currentPlace++;
			}
		}
		return getPrefix(temp, currentPlace);
	}
	
	/** Returns an array which is the i'th prefix of a given array. 
	 *  For example, the */
	public static int[] getPrefix (int[] arr, int lastElement) {
		int[] newSet = new int[lastElement];
		for (int i = 0; i < newSet.length; i++) {
			newSet[i] = arr[i];
		}
		return newSet;
	}
	
	/** Returns the Cartesian product of the two sets. */
	public static int[][][] product (int[] set1, int[] set2) {
		int[][][] product =  new int[set1.length][set2.length][2];
		for (int i = 0; i < set1.length; i++) {
			for (int j = 0; j < set2.length; j++) {
				product[i][j][0] = set1[i];
				product[i][j][1] = set2[j];
			}
		}
		return product;
	}
	
	/** Returns a random element chosen from the given set. */
	public static int random (int[] set) {
		// Computes a random index of the right size
		int r =  (int) (Math.random() * (set.length - 1));
		return set[r];
	}
	
	/** Prints the elements of the given set, starting and ending with curly brackets.
	 *  Then moves the cursor to a new line.
     *  For example, if the array contains the elements 7, 2, 1, prints { 7, 2, 1 }
     *  and moves the cursor to a new line.  */
	public static void println(int[] set) {
		int n = set.length;
		System.out.print("{");
		for (int i = 0; i < (n - 1); i++) {
			System.out.print(" " + set[i] + ",");
		}
		System.out.println(" " + set[n - 1] + " }");
	}
	
	/**
	 * This function receives a square matrix (the number of rows and columns is the same)
	 * and computes and returns something.  What does this function do?
	 */
	public static boolean mystery(int[][] m){
		int n = m.length-1, a1 = 0, a2 = 0;
		for (int i = 0; i <= n; i++) {
			a1 = a1 + m[i][i];
			a2 = a2 + m[i][n-i];
		}
		return a1 == a2;
	}

	/** Assumes that the length of the destination array is greater than
	 *  or equal to the length of the source array. Copies all the elements of the
	 *  src array to the destination array, from element 0 onward. */
	public static void arrayCopy(int[] src, int[] dest) {
		// {dest.length >= src.length}
		for (int i = 0; i < src.length; i++) {
			dest[i] = src[i];
		}
	}
	
}