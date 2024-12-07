public class MyString {
	public static void main(String []args) {
		// Converts an int value to a string (let's call it s), and then prints
		// s + s, to illustrate that the returned value is indeed a string.
		int x = 6137;
		String s = intToString1(x);
		System.out.println(s);
	}
	
	/** Returns the string representation of the given integer value.
	 *  Assumes that the integer is greater than or equal to 0. 
	 *  For example, if the given integer is 536, returns the string "536". */
	public static String intToString(int x) {
    	String ans = "";
    	while (x > 0) {
        	int rightMostDigit = x % 10;
        	x = x / 10;
        	char c = (char) (rightMostDigit + '0');
        	ans = c + ans; 
    	}
   		return ans;
	}

	/** Returns the string representation of the given integer value.
	 *  Assumes that the integer is greater than or equal to 0. 
	 *  For example, if the given integer is 536, returns the string "536". */
	public static String intToString1(int x) {
    	String ans = "";
    	while (x > 0) {
        	int rightMostDigit = x % 10;
        	x = x / 10;
        	ans = rightMostDigit + ans; 
    	}
   		return ans;
	}
}