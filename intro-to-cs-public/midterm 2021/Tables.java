public class Tables {
	public static void main(String args[]) {
		// Creates a table, for testing
		int[][] a = { { 1, 2, 4, 0 },
				      { 0, 1, 0, 2 },
				      { 2, 3, 5, 1 }, };
		println(colAverages(a));          
	}

	/** Returns a one-dimensional array containing the averages of the columns of the given two-dimensional array. */
	public static double[] colAverages(int[][] arr) {
		int N = arr.length;    // number of rows
		int M = arr[0].length; // number of columns
		double[] average = new double[M];
		for (int j = 0; j < M; j++) {
			double sum = 0;
			for (int i = 0; i < N; i++) {
				sum = sum + arr[i][j];
			}
			average[j] = sum / N;
		}
		return average;
	}

    /** Prints the given one-dimensional array. */ 
	public static void println(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
