/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
		//// Uncomment the version of binomial that you want to test
 
		// Testing the basic binomial implementation:
    	// System.out.println(binomial1(Integer.parseInt(args[0]), Integer.parseInt(args[1])));

		// Testing the optimized binomial implementation:
		// System.out.println(binomial(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
	}

	// Computes the Binomial function, basic version.
	public static int binomial1(int n, int k) { 
		//// Repplace the following comment with your code
		return 0;
	 }
	
	// Computes the Binomial function, efficiently
	public static int binomial(int n, int k) {
		//// This function creates a 2D array, say memo, 
		//// and then initializes all its elements to -1.
		//// It then calls binomial(n, k, memo), which does all the heavy lifiting.
		//// Replace the following statement with your code.
		return 0;
	}

	private static int binomial(int n, int k, int[][] memo) {
		if (memo[n][k] != -1) {
			return memo[n][k];
		}
		// Base case
		if ((k > n)) {
		   	memo[n][k] = 0; 
		   	return 0;
		}
		// Another base case
		if (n == 0 || k == 0) {
		   	memo[n][k] = 1; 
		   	return 1;
		}
		memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
		return memo[n][k];
	}
}
