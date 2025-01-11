/** Reads a command line string and checks if it's a palindrome. VERSION 2 */
public class isPalindrome1 {
	public static void main(String[] args){
		System.out.print(palindrome (args[0],0));
	}
	
	public static boolean palindrome (String s, int i){
			if (i > s.length() / 2){
				return true;
			}
			return s.charAt(i) == s.charAt(s.length() - i - 1) && palindrome(s, i + 1);
	}
}