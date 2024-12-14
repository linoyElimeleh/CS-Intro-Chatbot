// Computes the frequency of the characters A, T, G and C in a given string​
public class CharCount2 {	
	public static void main(String args[]) {
		String str = args[0];
		int[] freq = new int[4];

		// Scans the string; for each character, if the character​
		// appears in chars, increments its frequency counter.​
		for (int i = 0; i < str.length(); i++) {
		    freq["ATGC".indexOf(str.charAt(i))]++;
		}

		// Prints the frequency results​
		for (int i = 0; i < freq.length; i++) {
			System.out.println("ATGC".charAt(i) + " appears " + freq[i] + " times");
		}
	}
}