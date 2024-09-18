// import lists;

import java.util.Iterator;

/** Tests some of the methods of the List class. */
public class TestList {
	
	// A class level list, used by all the tests.
	public static List q;
	
	public static void main(String args[]) {
		////testAddFirst();
		////testIndexOf();
		////testRemove();
		////testDispose();
		////testToArray();
		testIterator();
	}
	
	public static void testAddFirst() {
		System.out.println("Tests the addFirst method:");
		q = new List();
		System.out.println("The list before adding any element: " + q);
		q.addFirst(7);
		System.out.println("After adding 7: " + q);
		q.addFirst(3);
		System.out.println("After adding 3: " + q);
		q.addFirst(5); 
		System.out.println("After adding 5: " + q);
		System.out.println();
	}
	
	/* public static void testIndexOf() {
		System.out.println("Tests the indexOf method:");
		buildList537();
		System.out.println("The list: " + q);
		System.out.println("The index of 7 is: " + q.indexOf(7));
		System.out.println("The index of 3 is: " + q.indexOf(3));
		System.out.println("The index of 5 is: " + q.indexOf(5));
		System.out.println("The index of 4 is: " + q.indexOf(4));
		System.out.println();
	} */
	
	public static void testRemove() {
		System.out.println("Tests the remove method:");
		buildList5976();
		System.out.println("The list: " + q);
		q.remove(2);
		System.out.println("After removing element 2: " + q);
		q.remove(0);
		System.out.println("After removing the first element: " + q);
		q.remove(1);
		System.out.println("After removing the last element: " + q);
		System.out.println();
	}
	
	/* public static void testDispose() {
		System.out.println("Tests the dispose method:");
		buildList537();
		System.out.println("The list: " + q);
		q.dispose();
		System.out.println("The list after disposing the list: " + q);
		System.out.println();
	} */
	
	/* public static void testToArray() {
		System.out.println("Tests the toArray method:");
		buildList537();
		System.out.println("The list: " + q);
		System.out.print("The array: ");
		// Constructs an array that consists of all the elements of the list
		int[] a = q.toArray();
		// Prints the array elements
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();	
		System.out.println();	
	} */
	
	public static void testIterator() {
		System.out.println("Tests the iterator method:");
		// Builds a list of 10 elements
		List q = new List();
		q.add(1); q.add(2); q.add(4); q.add(9);
		System.out.println(q);

		System.out.println("The list: " + q);
		
		// Uses an iterator to sum up the list's elements.
		Iterator<Integer> itr = q.iterator();
		int sum = 0;
		while (itr.hasNext()) {
			sum = sum + itr.next();
		}
	    System.out.println("Sum: " + sum);

		// Uses for-each to sum up the list's elements.
		sum = 0;
		for (int val : q) {
			sum = sum + val;
		}
	    System.out.println("Sum: " + sum);
	}
	
	// Builds a small list, called by some of the test methods.
	private static void buildList5976old() {
		q = new List();
		q.add(5); q.add(9); q.add(7); q.add(6); 
	}

	// Builds a small list, called by some of the test methods.
	private static void buildList5976() {
		q = new List();
		q.addFirst(5); q.addFirst(9); q.addFirst(7); 
	}
}
