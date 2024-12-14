/** A tokenizer for strings of the form "cncncn...", where the single character c
 *  represents a character, and the multi-character substring n represents an int value. */
public class Tokenizer {

    private static String str; // the string to parse
    private static int N;      // size of the string (number of characters)
    private static int cursor; // current position in the string
    
    /** Initializes the given string for parsing. */
    public static void init(String s) {
	    str = s;
	    N = str.length();
	    cursor = 0;
    }

    /** Returns true if there are more characters to process, false otherwise. */
    public static boolean hasMoreChars() {
        return false;
    }

    /** Returns the next character in the string.
    /*  Should be called only if hasMoreChars() is true. */
    // Side effect: advances the cursor just beyond the character.
    public static char nextChar() {
        return 0;
    }

    /** Returns the next integer in the text.
    *  Should be called only if hasMoreChars() is true, and if the next character is a digit. */
    // Side effect: advances the cursor just beyond the integer.
    public static int nextInt() {
        return 0;
    }

    // Returns true if the given character is a digit, false otherwise.
    private static boolean isDigit(char c) {
        return false;
    }
}