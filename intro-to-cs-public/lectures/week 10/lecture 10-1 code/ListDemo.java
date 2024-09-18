/** Tests some of the methods of the List class. */
public class ListDemo {
	
	public static void main(String args[]) {
		TestAdd();
		testAddFirst();
		testIndexOf();
		testValueAt();
		testRemoveValue();
		testIterator();
	}

	public static void TestAdd() {
		System.out.println("\nTesting the the add method...");
		List q = new List();
		q.add(3); q.add(5); q.add(9);
		System.out.println("List after adding 3, 5, 9: " + q);
	}
	
	public static void testAddFirst() {
		System.out.println("\nTesting the addFirst method...");
		List q = new List();
		q.add(5); q.add(9);
		System.out.println("List: " + q);
		q.addFirst(3); q.addFirst(1);
		System.out.println("List after adding 3 and then 1 at the beginning: " + q);
	}

	public static void testIndexOf() {
		System.out.println("\nTesting the indexOf method...");
		List q = new List();
		q.add(3); q.add(5); q.add(9); q.add(15);
		System.out.println("List: " + q);
		System.out.println("Location of value 9 is: " + q.indexOf(9));
	}

	public static void testValueAt() {
		System.out.println("\nTesting the valueAt method...");
		List q = new List();
		q.add(3); q.add(5); q.add(9); q.add(15);
		System.out.println("List: " + q);
		System.out.println("Value at location 1 is: " + q.valueAt(1));
	}

	public static void testRemoveValue() {
		System.out.println("\nTesting the removeValue method:");
		List q = new List();
		q.add(3); q.add(5); q.add(9); q.add(15);
		System.out.println("List: " + q);
		q.removeValue(5);
		q.removeValue(15);
		System.out.println("After removing 5 and then 15: " + q);
	}

	public static void testIterator() {
		System.out.println("\nTesting the iterator method:");
		// Builds a list of some elements
		List q = new List();
		q.add(1); q.add(2); q.add(4); q.add(9);
		System.out.println("List: " + q);
		
		// Uses an iterator to sum up the list values.
		ListIterator itr = q.listIterator();
		int sum = 0;	
		while (itr.hasNext()) {
			sum = sum + itr.next();
		}
		System.out.println("Sum of elements: " + sum);
	}
}
