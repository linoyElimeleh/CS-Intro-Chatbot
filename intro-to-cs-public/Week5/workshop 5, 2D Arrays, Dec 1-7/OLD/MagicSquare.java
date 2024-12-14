
public class MagicSquare {

	static int n;

	public static void main(String[] args)
	{
		int[][] arr = {{16,3,2,13},
						  {5,10,11,8},
						  {9,6,7,12},
						  {4,15,14,1}};
		
		if (isMagicSquare(arr)) {
			System.out.println("This arr is a Magic Square!");
		} else {
			System.out.println("This arr is NOT a Magic Square...");
		}
	}
	
	public static boolean isMagicSquare(int[][] arr) {
		if (arr.length != arr[0].length) return false;
		
		int magicNum = calcMagicNumber(arr.length);
		boolean sumRows = false;
		boolean sumCols = false;
		boolean sumDiagonals = false;
		
		for (int i = 0; i < arr.length; i++) {
			sumRows = (sumRow(arr, i) == magicNum);
			sumCols = (sumCol(arr, i) == magicNum);
			if (!sumRows || !sumCols) return false;
		}
		
		sumDiagonals = ((sumMainDiagonal(arr) == magicNum) &&
				        (sumSecondaryDiagonal(arr) == magicNum));
		
		return sumRows && sumCols && sumDiagonals;	
	}
	
	private static int calcMagicNumber(int n) {
		return (n * ((n * n) + 1)) / 2;
	}
	
	private static int sumRow(int[][] arr, int row) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[row][i];
		}

		return sum;
	}
	
	private static int sumCol(int[][] arr, int col) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][col];
		}

		return sum;
	}
	
	private static int sumMainDiagonal(int[][] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];
		}

		return sum;
	}
	
	private static int sumSecondaryDiagonal(int[][] arr) {
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][arr.length - 1 - i];
		}

		return sum;
	}

	public static void printSquare(int[][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; i < n; i++) {
			    System.out.print(arr[i][j] + " ");
			}

			System.out.println();
		}	
	}
}
