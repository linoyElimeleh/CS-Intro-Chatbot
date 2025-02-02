/** A library of operations on sets.
 *  A set is a collection of values without repetition and without order.
 *  For example, 2, 5, 2, 7 is not a set. {2, 5, 7} is a set.
 *  The order of the elements in the set is insignificant.
 *  For example, {2, 5, 7} is the same set as {5, 7, 2}.
 * 
 *  In this implementation sets are represented as arrays of integers. */

public class Sets {
	
	public static void main(String[] args) {

	    // Creates and prints some sets, for testing.
	    int[] s1 = { 9, 8, 12, 7 };
	    System.out.print("s1 = "); println(s1);

	    int[] s2 = { 6, 8, 7, 12, 9 };
	    System.out.print("s2 = "); println(s2);

	    int[] s3 = { 7, 8, 4 };
	    System.out.print("s3 = "); println(s3);

	    int[] s4 = { 12, 9 };
	    System.out.print("s4 = "); println(s4);

	    System.out.print("Intersection of s1, s2, s3 = ");
	    println(intersection(s1, s2, s3));

	    System.out.print("s4 dominates s3? ");
	    System.out.println(dominates(s4, s3)); 

        System.out.print("The set of odd values in s2 = ");
	    println(oddValuesOf(s2));

	    System.out.print("The set of odd values in s3 = ");
	    println(oddValuesOf(s3));		

	    int x = 3;
        int[] y = { 1, 2, 3 };
        triple1(x);
        triple2(y);
	    System.out.println(x);
	    for (int i = 0; i < x; i++) {
	       System.out.print(y[i] + " ");
	    }
	    triple3(y);
	    for (int i = 0; i < x; i++) {
	       System.out.print(y[i] + " ");
	    }
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

	/** Checks if set1 dominates set2. Set1 dominates set2 is every element of set1 
	 *  is greater than every element of set2. */
	public static boolean dominates(int[] set1, int[] set2) {
		int min = set1[0];
		for (int i = 0; i < set1.length; i++) {
			if (set1[i] < min) {
				min = set1[i];
			}
		}
		for (int i = 0; i < set2.length; i++) {
			if (min <= set2[i]) {
				return false;
			}
		}
		return true;
	}

	/** Returns a set containing the elements of the set that are not multiples of 2. */
	public static int[] oddValuesOf(int[] set) {	
		// Creates a temporary array whose size is the maximal possible size of the answer
		int[] temp = new int[set.length];
		
		// Adds the set's odd elements
		int size = 0;
		for (int i = 0; i < set.length; i++) {
			if ((set[i] % 2) != 0) {
			    temp[size] = set[i];
		        size++;
		    }
		}
		
		// Creates and returns a new array that has the right size
		int[] ans = new int[size];
		for (int i = 0; i < size; i++) {
			ans[i] = temp[i];
		}
		return ans;
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

	/** Returns the intersection of the three sets.
	 *  The intersection of set1, set2, and set3 is the set containing all the elements 
	 *  that are both in set1, set2, and set3. */ 
	public static int[] intersection (int[] set1, int[] set2, int[] set3) {
		return intersection(intersection(set1, set2), set3);
	}

	public static void triple1(int a) {
        a = 3 * a;
    }

    public static void triple2(int[] a) {
        for (int i = 0; i < a.length; i++) {
	      a[i] = 3 * a[i];
	  }
    } 

    public static void triple3(int[] a) {
        for (int i = 0; i < a.length; i++) {
	       triple1(a[i]);
	    }
    }       
	
	/** Prints the elements of the set. */
	public static void println(int[] set) {
		if (set.length == 0) {
		    System.out.println("{ }");
		    return;
		}
		int n = set.length;
		System.out.print("{");
		for (int i = 0; i < (n - 1); i++) {
			System.out.print(" " + set[i] + ",");
		}
		System.out.println(" " + set[n - 1] + " }");
	}
}