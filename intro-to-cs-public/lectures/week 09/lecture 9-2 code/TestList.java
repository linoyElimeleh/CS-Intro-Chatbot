// Imports all the classes from the lists package.
import lists.*;

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
		////testIterator();
	}
	
	public static void testAddFirst() {
		System.out.println("Tests the addFirst method:");
		q = new List();
		System.out.println("The list before adding any element: " + q);
		q.addFirst(7);
		System.out.println("The list after adding 7 to the beginning: " + q);
		q.addFirst(3);
		System.out.println("The list after adding 3 to the beginning: " + q);
		q.addFirst(5); 
		System.out.println("The list after adding 5 to the beginning: " + q);
		System.out.println();
	}
	
	public static void testIndexOf() {
		System.out.println("Tests the indexOf method:");
		buildList537();
		System.out.println("The list: " + q);
		System.out.println("The index of 7 is: " + q.indexOf(7));
		System.out.println("The index of 3 is: " + q.indexOf(3));
		System.out.println("The index of 5 is: " + q.indexOf(5));
		System.out.println("The index of 4 is: " + q.indexOf(4));
		System.out.println();
	}
	
	public static void testRemove() {
		System.out.println("Tests the remove method:");
		buildList537();
		System.out.println("The list: " + q);
		q.remove(3);
		System.out.println("The list after removing 3: " + q);
		q.remove(4);
		System.out.println("The list after removing 4: " + q);
		q.remove(5);
		System.out.println("The list after removing 5: " + q);
		q.remove(7);
		System.out.println("The list after removing 7: " + q);
		System.out.println();
	}
	
	public static void testDispose() {
		System.out.println("Tests the dispose method:");
		buildList537();
		System.out.println("The list: " + q);
		q.dispose();
		System.out.println("The list after disposing the list: " + q);
		System.out.println();
	}
	
	public static void testToArray() {
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
	}
	
	public static void testIterator() {
		System.out.println("Tests the iterator method:");
		// Builds a list of 10 elements
		buildList537();
		q.addFirst(2);
		q.addFirst(4);
		q.addFirst(1); 
		q.addFirst(9);
		q.addFirst(0);
		q.addFirst(6); 
		q.addFirst(8);
		System.out.println("The list: " + q);
		
		// Uses an iterator to print all the elements in the list.
		System.out.println("The list elements: ");
		ListIterator itr = q.listIterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}
	
	// Builds a small list, called by some of the test methods.
	private static void buildList537() {
		q = new List();
		q.addFirst(7);
		q.addFirst(3);
		q.addFirst(5); 
	}
}
