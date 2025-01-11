/** Checks if a given string is a palindrome. */
public class Palindrome {

	public static void main(String[]args) {
    	System.out.println(isPalindrome(args[0]));
    }
	
	/** Checks if the given string is a palindrome. */
	public static boolean isPalindrome(String s) {
		 // If the string's length is 0 or 1, it's a palindrome
		if (s.length() == 0 || s.length() == 1)
            return true; 
          
		// Checks if the first char equals the last char;
        // If so, checks the substring that remains after removing the first and last chars.
		if (s.charAt(0) == s.charAt(s.length() - 1))
			return isPalindrome(s.substring(1, s.length() - 1));
		else
			return false;
    }

	// Another implementation
	public static boolean isPalindrome1 (String s, int i){
		if (i > s.length() / 2) {
			return true;
		}
		return s.charAt(i) == s.charAt(s.length() - i - 1) && isPalindrome1(s, i + 1);
	}
}