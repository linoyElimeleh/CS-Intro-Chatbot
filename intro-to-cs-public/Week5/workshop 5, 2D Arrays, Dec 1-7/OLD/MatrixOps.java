public class MatrixOps {

	public static void main(String[] args) {
		
		int[][] matrix = {
            {1, 5},
            {2, 3},
            {1, 7}};

        int[][] matrixToAdd = {
            {2, 4},
            {6, 3},
            {1, 7}};
		
		int[][] matrixToMult = {
            {1, 2, 3, 7},
            {5, 2, 8, 1}};
				  
		int[][] expectedAddResult = {
            {3, 9},
            {8, 6},
            {2, 14}};
				  
		int[][] expectedMultResult = {
            {26, 12, 43, 12},
            {17, 10, 30, 17},
            {36, 16, 59, 14}};
		
		int[][] addResult = add(matrix, matrixToAdd);
		int[][] multResult = mult(matrix, matrixToMult);
		
		System.out.println("expected add result:");
		printMatrix(expectedAddResult);
		System.out.println();
		System.out.println();
		System.out.println("actual add result:");
		printMatrix(addResult);

        System.out.println();
		System.out.println();
		
		System.out.println("expected mult result:");
		printMatrix(expectedMultResult);
		System.out.println();
		System.out.println();
		System.out.println("actual mult result:");
		printMatrix(multResult);
	}
	
	private static void printMatrix(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static int[][]add(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) return null;
		int[][] result = new int[a.length][a[0].length];
		
		for (int row = 0; row < result.length; row++) {
	        for (int col = 0; col < result[row].length; col++) {
                result[row][col] = a[row][col] + b[row][col];
	        }
	    }
	 
	    return result;
	}
	
	// Returns matrix multiplication a X b
	private static int[][] mult(int[][] a, int[][] b) {
		if (a[0].length != b.length) return null;
		
		int[][] result = new int[a.length][b[0].length];
		 
	    for (int row = 0; row < result.length; row++) {
	        for (int col = 0; col < result[row].length; col++) {
	        	for (int k = 0; k < b.length; k++) {
	                result[row][col] += a[row][k] * b[k][col];
	            }
	        }
	    }
	 
	    return result;
	}
}