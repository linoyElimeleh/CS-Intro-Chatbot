public class Recursion {

	public static void main(String []args){
		// System.out.println(factorial(5));
		// System.out.println(fibonacci(5));
		// System.out.println(reverse("abcd"));
        printReverse();
	    // drawH(.5, .5, .5, 5);
		// listPerms("abcd");
	}

	// Returns the factorial (n!) of the given n (recuresively)
	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n-1);
	}

	// Returns the factorial (n!) of the given n (iteratively)
	public static long factorial1 (int n) {
		int fact = 1;
		for (int i=1; i<=n; i++) {
			fact *= i;
		}
		return fact;
	}

	
	// Retunrs the n'th Fibonacci number (recursively)
	public static int fibonacci (int n) {
		if (n <= 1) return n;
			return fibonacci(n-1) + fibonacci(n-2);
	}

	// Retunrs the n'th Fibonacci number (iteratively)
	public static int fibonacci1 (int n) {
		if (n <= 1) return n;
		int fprev = 1, fprevprev = 1, f = 0;
		for (int i = 2; i <= n; i++) {
			f = fprev + fprevprev;
			fprevprev = fprev;
			fprev = f;
		}
		return f;
	}
	
	// Returns x^n
	public static int power(int x, int n) {
		if (n == 0) return 1;
			return x * power(x,n-1);
	}
	
	// Returns x^n, efficiently
	public static int power1(int x, int n) {
		if (n == 0) return 1;
		if ((n % 2) == 0) {
			int t = power1(x, n/2);
			return t * t;
		}
		return x * power1(x, n-1);
	}
	
	// Reverses the given string
	public static String reverse(String str) {
		if (str.length() <= 1) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}

	// Gets some numbers from the user.
	// When 0 is entered, prints the numbers in revrese order.
	public static void printReverse() {
		In in = new In();
		System.out.print("Enter a number: ");
		int x = in.readInt();
		if (x != 0) {
			printReverse();
			System.out.println(x);
		}
	}
	
	// Draws an H-fractal, centered at x,y, of the given size and depth.
	public static void drawH(double x, double y, double size, int n) {
		if (n == 0) return;
		double x0 = x - size/2, x1 = x + size/2;
		double y0 = y - size/2, y1 = y + size/2;
		// Draws the H figure
		StdDraw.line(x0, y, x1, y);
		StdDraw.line(x0, y0, x0, y1);
		StdDraw.line(x1, y0, x1, y1);
		// Draws 4 H figures of half the size,
		// located at the 4 tips of the current H figure
		drawH(x0, y0, size/2, n-1);
		drawH(x0, y1, size/2, n-1);
		drawH(x1, y0, size/2, n-1);
		drawH(x1, y1, size/2, n-1);
	}

    // Draws an infinite H-fractal, centered at x,y, of the given size.
    // This version of the function has no base / stop consition.
    // Results in a runtime error, because the infinite drawing leads
    // to drawing anomalies at extreme values. 
	public static void drawH1(double x, double y, double size) {
		double x0 = x - size/2, x1 = x + size/2;
		double y0 = y - size/2, y1 = y + size/2;
		// Draws the H figure
		StdDraw.line(x0, y, x1, y);
		StdDraw.line(x0, y0, x0, y1);
		StdDraw.line(x1, y0, x1, y1);
		// Draws 4 H figures of half the size,
		// located at the 4 tips of the current H figure
		drawH1(x0, y0, size/2);
		drawH1(x0, y1, size/2);
		drawH1(x1, y0, size/2);
		drawH1(x1, y1, size/2);
	}

    // Prints all the permutations of the given string
	public static void listPerms (String s) {
        listPerms("", s);
    }

	// Prints the given prefix, followed by all the permutations of s
	private static void listPerms (String prefix, String s) {
		if (s.length() == 0) {
			System.out.println(prefix);
		}
		else {
			for (int i = 0; i < s.length(); i++) {
			    // Gets the i'th character of the string s
				char ch = s.charAt(i);
				// Gets the string s minus this character
				String rest = s.substring(0,i) + s.substring(i+1);
				
				// Debugging print:
				// System.out.println("calling lp(" + (prefix + ch) +", " + rest + ")");
				listPerms(prefix + ch, rest);
			}
		}
	}
}
