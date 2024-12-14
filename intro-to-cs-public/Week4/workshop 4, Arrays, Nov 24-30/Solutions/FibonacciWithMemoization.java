import java.util.Arrays;
import java.util.Scanner;

public class FibonacciWithMemoization {

    private static long[] arr;
    private static int index;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Please enter number: ");
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }
            printFibonacciSequence(n);
        }
    }

    private static void printFibonacciSequence(int n) {
        if (n == 0 || n == 1) {
            System.out.println(n);
        }

        if (arr == null) {
            initializeArray(n);
        }

        if (n <= index) {
            returnAlreadyCalculatedValue(arr[n - 1]);
            return;
        } else while (n > arr.length) {
            enlargeArray();
        }

        calculateFibonacci(n);
        System.out.println(Arrays.toString(arr));
    }

    private static void calculateFibonacci(int n) {
        System.out.println("Calculating Fibonacci series from " + index + " to " + n);
        for (int i = index; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        index = n;
    }

    private static void enlargeArray() {
        System.out.println("Enlarging the array, as it is not big enough");
        long[] newArr = new long[arr.length*2];
        System.arraycopy(arr, 0, newArr, 0, index);
        arr = newArr;
    }

    private static void returnAlreadyCalculatedValue(long x) {
        System.out.println("Returning already calculated value");
        System.out.println(x);
    }

    private static void initializeArray(int n) {
        System.out.println("Initializing the array");
        System.out.println("Calculating Fibonacci series from 0 to 2");
        if (n == 1) {
            n = 2;
        }
        arr = new long[n];
        arr[0] = 1;
        arr[1] = 1;
        index = 2;
    }
}
