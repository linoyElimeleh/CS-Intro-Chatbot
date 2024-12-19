
public class Printing {
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40};
		print(arr);
		System.out.println();
		printReverse(arr);
	}

	/**
	* Prints the array elements
	*/
	public static void print(int[] arr) {
		print(arr, 0);
	}
	
	public static void print(int[] arr, int i) {
		if (i < arr.length) {
			System.out.print(arr[i] + " ");
			print(arr, i + 1);
		}
	}
	
	/**
	* Prints the array elements	in reverse order
	*/
	public static void printReverse(int[] arr) {
		printReverse(arr, 0);
	}
	
	public static void printReverse(int[] arr, int i) {
		if (i < arr.length) {
			printReverse(arr, i + 1);
			System.out.print(arr[i] + " ");
		}
	}

}
