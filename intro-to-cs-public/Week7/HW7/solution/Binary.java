/** Prints the binary representation of a given integer. */
public class Binary {

	public static void main (String[] args) {
		int x = Integer.parseInt(args[0]);
		System.out.println(toBinary(x));
    }

	public static String toBinary(int x) {
	    return toBinary(x, "");
	}
	
	public static String toBinary(int x, String str) {
	    if (x > 0) {
	        str = toBinary(x / 2, str) + (x % 2);
	    	////System.out.println(s);  // debug
	    }
	    return str;
	}
}
