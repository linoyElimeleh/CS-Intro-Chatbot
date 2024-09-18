public class MyArrays {
	public static void main(String[] args) {
		int[] x = {5, 3, 2}; // for testing​
		println(x);
		System.out.println(sum(x));
		System.out.println(average(x));
		println(x);
		println(reverse(x));
		println(x);
		reverseInPlace(x);
		println(x);
	}

	/** Computes the sum of the elements of the array​ */
	public static int sum(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		return sum;
	}

	/** Computes the average of the elements of the array​ */
	public static double average(int[] arr) {
		return (double) sum(arr) / arr.length;
	}

	/** Returns an array which is the reverse of the given array​ */
	public static int[] reverse(int[] arr) {
		int N = arr.length;
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = arr[N-i-1];
		}
		return result;
	}

	/** Reverses the order the elements in the given array​ */
	public static void reverseInPlace(int[] arr) {
		int N = arr.length;
		for (int i = 0; i < N/2; i++) {
			int temp = arr[i];
			arr[i] = arr[N-1-i];
			arr[N-1-i] = temp;
		}
	}

	/** Prints the given int array​ */
	public static void println(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}