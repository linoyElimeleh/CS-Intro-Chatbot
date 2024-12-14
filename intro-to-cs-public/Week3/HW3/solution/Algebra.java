// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 < 0) {
			return minus(x1, -x2);
		}
		int result = x1;
		while (x2 > 0) {
			result++;
			x2--;
		}
		return result;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 < 0) {
			return plus(x1, -x2);
		}
		int result = x1;
		while (x2 > 0) {
			result--;
			x2--;
		}
		return result;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x2 < 0) {
			return -times(x1, -x2);
		}
		int result = 0;
		while (x2 > 0) {
			result = plus(result, x1);
			x2--;
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		if (n == 0) return 1;
        int result = 1;
	    do {
	        result = times(result,x);
	    	n--;
	    }
	    while (n > 0);
	    return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 == 0) throw new ArithmeticException("Division by zero");
		if (x1 < 0 && x2 < 0) return div(-x1, -x2);
		if (x1 < 0) return -div(-x1, x2);
		if (x2 < 0) return -div(x1, -x2);
		
		int quotient = 0;
		while (x1 >= x2) {
			x1 = minus(x1, x2);
			quotient++;
		}
		return quotient;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		if (x2 == 0) throw new ArithmeticException("Division by zero");
		if (x1 < 0) return -mod(-x1, x2);
		if (x2 < 0) x2 = -x2;
		
		while (x1 >= x2) {
			x1 = minus(x1, x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		if (x < 0) throw new ArithmeticException("Square root of negative number");
		if (x == 0) return 0;
		
		int result = 1;
		int prev = 0;
		
		while (result != prev && times(result, result) <= x) {
			prev = result;
			result++;
		}
		return minus(result, 1);
	}	  	  
}