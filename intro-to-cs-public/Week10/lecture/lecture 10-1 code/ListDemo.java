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
		List v = new List();
		v.add(3); v.add(5); v.add(9);
		System.out.println("List after adding 3, 5, 9: " + v);
	}
	
	public static void testAddFirst() {
		System.out.println("\nTesting the addFirst method...");
		List v = new List();
		v.add(5); v.add(9);
		System.out.println("List: " + v);
		v.addFirst(3); v.addFirst(1);
		System.out.println("List after adding 3 and then 1 at the beginning: " + v);
	}

	public static void testIndexOf() {
		System.out.println("\nTesting the indexOf method...");
		List v = new List();
		v.add(3); v.add(5); v.add(9); v.add(15);
		System.out.println("List: " + v);
		System.out.println("Location of value 9 is: " + v.indexOf(9));
	}

	public static void testValueAt() {
		System.out.println("\nTesting the valueAt method...");
		List v = new List();
		v.add(3); v.add(5); v.add(9); v.add(15);
		System.out.println("List: " + v);
		System.out.println("Value at location 1 is: " + v.valueAt(1));
	}

	public static void testRemoveValue() {
		System.out.println("\nTesting the removeValue method:");
		List v = new List();
		v.add(3); v.add(5); v.add(9); v.add(15);
		System.out.println("List: " + v);
		v.removeValue(5);
		v.removeValue(15);
		System.out.println("After removing 5 and then 15: " + v);
	}

	public static void testIterator() {
		System.out.println("\nTesting the iterator method:");
		// Builds a list of some elements
		List v = new List();
		v.add(1); v.add(2); v.add(4); v.add(9);
		System.out.println("List: " + v);
		
		// Uses an iterator to sum up the list values.
		ListIterator itr = v.listIterator();
		int sum = 0;	
		while (itr.hasNext()) {
			sum = sum + itr.next();
		}
		System.out.println("Sum of elements: " + sum);
	}
}
