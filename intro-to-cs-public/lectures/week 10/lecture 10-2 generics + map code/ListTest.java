/** Tests the generic List class. */

import lists.*;

public class ListTest {
		
	public static void main(String args[]) {
		// Constructs a list of fractions (Fraction objects)
		List<Fraction> fList = new List<Fraction>();
		// Adds two fractions to the list
		fList.addFirst(new Fraction(1,2));
		fList.addFirst(new Fraction(3,4));
		// Adds a few more fractions to the list
		for (int i = 1; i < 8; i++) {
		    fList.addFirst(new Fraction(i , i + 1));
		}
		// Prints the list
		System.out.println(fList);
	}
}
