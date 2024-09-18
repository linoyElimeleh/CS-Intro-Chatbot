/** Features matrix operations (add, multiply,...) */
public class MatrixOps {
	public static void main(String args[]) {
		// Creates two matrices, for testing
		int[][] a = { { 7, 2, 1 },
				      { 3, 6, 1 },
				      { 5, 1, 4 }, };
		int[][] b = { { 8, 3, 5 },
				      { 1, 4, 1 },
				      { 1, 3, 4 }, };
		println(a);          
		println(b);          
		println(add(a,b));   
		println(mult(a,b));  
	
        // c = a * (a + b)​
	    int[][] c = mult(a,add(a,b));
	}

	/** Returns the matrix addition m1 + m2. Assumes that they have the same dimensions. */
	public static int[][] add(int[][] m1, int[][] m2) {
		int N = m1.length;    // number of rows
		int M = m2[0].length; // number of columns
		int[][] sum = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sum[i][j] = m1[i][j] + m2[i][j];
			}
		}
		return sum;
	}

	/** Returns the matrix multiplication m1 * m2. Assumes that they have the same dimensions. */
	public static int[][] mult(int[][] m1, int[][] m2) {
		// Replace the following statement with your code
		return null;
	}

	/** Prints the given matrix, and moves the cursor to the next line. */
	public static void println(int[][] m) {
		// Put your code here
	}
}
