public class Sudoku {

	public static void main(String[] args) {		

		// Tests the containsAllNumbers method, using some arbitrary arrays:
		int[] v1 = {1,2,3,4};  System.out.println(containsAllNumbers(v1));
		int[] v2 = {2,1,4,3};  System.out.println(containsAllNumbers(v2));
		int[] v3 = {1,2,3,1};  System.out.println(containsAllNumbers(v3));
		
		// Creates a Soduku square:
		int[][] m = { { 5, 3, 4, 6, 7, 8, 9, 1, 2 } ,
			      { 6, 7, 2, 1, 9, 5, 3, 4, 8 } ,
			      { 1, 9, 8, 3, 4, 2, 5, 6, 7 } ,
			          { 8, 5, 9, 7, 6, 1, 4, 2, 3 } ,
		          { 4, 2, 6, 8, 5, 3, 7, 9, 1 } ,
		          { 7, 1, 3, 9, 2, 4, 8, 5, 6 } ,
		          { 9, 6, 1, 5, 3, 7, 2, 8, 4 } ,
			      { 2, 8, 7, 4, 1, 9, 6, 3, 5 } ,
			      { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
	
		// Tests the class methods, using the m matrix:
		print(getColumn(m,4));         // Column 4
		print(getSquare(m,0,0,3));     // The 3x3 square anchored at (0,0) 
		print(getSquare(m,6,6,3));     // The 3x3 square anchored at (6,6) 
		System.out.println(soduku(m)); // Is m a valid soduku square?
	}
	
    // Checks if the given square array is a sudoku square
	private static boolean sudoku(int[][] arr){
		//TODO
		return false;
	}
	
	// Checks if the given array, which is of size N, contains all the numbers 1,2,3...,N.
	// (remember that the array index is 0,1,2,...N-1)
	private static boolean containsAllNumbers(int[] arr) {
		//TODO
	    return false;
    }
    
    // Given a 2-dimensional array and a column number,
    // returns an array containing the values in this column.
	// Assumes that col is a valid column number -- no need to check it.
    private static int[] getColumn(int[][] arr, int col) {
    	//TODO
    	return new int[0];
	}
    
    // Given a 2-dimensional array, a (row,col) location, and a size n, 
    // returns a 1-dimensional array of size n*n.
    // The returned array contains all the arr values that appear in
    // the square of size n whose top-left coordinate is (row,col).
    // Assumes that row, col, and n are all valid -- no need to check it.
    private static int[] getSquare(int[][] arr, int row, int col, int n){
    	//TODO
		return new int[0];
	}
    
    // Prints the given array.  Used for debugging purposes.
    private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
