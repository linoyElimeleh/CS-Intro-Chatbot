// Features matrix operations (add, multiply,...)
public class MatrixOps {
	public static void main(String args[]) {
		// Creates a matrix, for testing
		int[][] a = { { 1, 2, 4, 0 },
				      { 0, 1, 0, 2 },
				      { 2, 3, 5, 1 }, };
		println(colAverages(a));          
	}

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

	public static void println(double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
