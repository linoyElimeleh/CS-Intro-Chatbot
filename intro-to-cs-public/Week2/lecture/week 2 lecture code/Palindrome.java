// Checks is a given string is a palindrome.
public class Palindrome {
	public static void main(String[] args) {
		// Gets the string from the user
		String s = args[0];

		int left = 0;
		int right = s.length() - 1;
		while (s.charAt(left) == s.charAt(right) && (left < right)) {
			left++;    
			right--;   
		}

		if (left < right)
			System.out.println(s + " is not a palindrome");
		else
			System.out.println(s + " is a palindrome");
	}
}
