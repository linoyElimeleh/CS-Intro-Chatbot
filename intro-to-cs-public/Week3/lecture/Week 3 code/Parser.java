// Uses a tokenizer for handling strings of the form "cncncn...", where the single character c 
// represents a character, and the multi-character substring n represents an int value.
// Prints each character value and integer value in a separate line. */
public class Parser {
	public static void main(String[] args) {
		String s = args[0];
		// Initializes the Tokenizer to the given string
		Tokenizer.init(s);
		// Does the tokenizing
		while (Tokenizer.hasMoreChars()) {
			System.out.println(Tokenizer.nextChar());
			// Following the character, there must be an int value
			System.out.println(Tokenizer.nextInt());
		}
	}
}