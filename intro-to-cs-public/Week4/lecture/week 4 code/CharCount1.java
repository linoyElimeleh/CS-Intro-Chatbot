
public class CharCount1 {
	// Computes the frequency of the characters A, T, G and C in a given string​
	public static void main(String args[]) {
		String str = args[0];
		char[] chars = {'A','T','G','C'};   
		int[] freq = new int[chars.length];

		// Scans the string; for each character, if the character​
		// appears in chars, increments its frequency counter.​
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < chars.length; j++) {
				if (str.charAt(i) == chars[j]) {
					freq[j]++;
				}
			}
		}

		// Prints the frequency results​
		for (int i = 0; i < freq.length; i++) {
			System.out.println(chars[i] + " appears " + freq[i] + " times");
		}
	}
}