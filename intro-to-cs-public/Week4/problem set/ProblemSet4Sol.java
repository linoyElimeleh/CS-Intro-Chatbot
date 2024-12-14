import java.util.Arrays;

public class ProblemSet4Sol {

    // 3. Sum of array elements
    // Write a function called "sumArray" that takes an array of integers and returns the sum of all elements.
    // Test the function using the "numbers" array from problem 1.

    /**Returns the sum of all elements in a given char array */
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // 4. Minimum value in an array
    // Write a function called "minValue" that takes an array of integers and returns the smallest value.
    // Test the function using the "numbers" array from problem 1.
    
    /**Returns the minimal valued element of a given integer array */
    public static int minValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // 5. Reversing an array
    // Write a function called "reverseArray" that takes an array of integers and returns a new array with elements in reverse order.
    // Test the function using the "numbers" array from problem 1.
    
    /**Returns a reversed copy of a given integer array */
    public static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    // 7. Searching in an array
    // Write a function called "findElement" that takes an array and an integer as parameters.
    // It should return the index of the first occurrence of the integer in the array, or -1 if the integer is not found.
    
    /**Retruns the index position of a given int in a given int array. If not found, returns -1 */
    public static int findElement(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // 9. Array of characters
    // Write a function called "countVowels" that takes an array of characters and returns the number of vowels (a, e, i, o, u).
    // Test the function with an array of characters: {'h', 'e', 'l', 'l', 'o'}.
    
    /**Returns the number of vowls found in a given char array */
    public static int countVowels(char[] chars) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    // 10. Array manipulation with doubles
    // Write a function called "scaleArray" that takes an array of doubles and a scaling factor.
    // It should return a new array where each element is multiplied by the scaling factor.
    // Test the function with an array of doubles: {1.5, 2.5, 3.5} and a scaling factor of 2.
    
    /**Returns a copy of a given array where all elements are multiplied by a given facor. */
    public static double[] scaleArray(double[] arr, double factor) {
        double[] scaled = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            scaled[i] = arr[i] * factor;
        }
        return scaled;
    }


    public static void main(String[] args) {
        
        // 1. Array creation and initialization
        // Create an array of integers called "numbers" with values 1, 2, 3, 4, 5.
        // Print the array length and the first and last elements.
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array length: " + numbers.length);
        System.out.println("First element: " + numbers[0]);
        System.out.println("Last element: " + numbers[numbers.length - 1]);

        // 2. Iterating through an array
        // Write a for loop that prints each element in the "numbers" array from problem 1.
        
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 3.
        System.out.println("Sum of array: " + sumArray(numbers));

        // 4.
        System.out.println("Minimum value: " + minValue(numbers));

        // 5.
        int[] reversedNumbers = reverseArray(numbers);
        System.out.println("Reversed array: " + Arrays.toString(reversedNumbers));

        // 6. Multidimensional array
        // Create a 2x3 array of integers called "matrix" and initialize it with values of your choice.
        // Print each element using a nested for loop.
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // 7.
        System.out.println("Index of 3: " + findElement(numbers, 3));
        System.out.println("Index of 6: " + findElement(numbers, 6));

        // 8. String array
        // Create an array of strings called "fruits" with values "apple", "banana", and "cherry".
        // Write a for loop to print each fruit in uppercase.
        
        String[] fruits = {"apple", "banana", "cherry"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i].toUpperCase());
        }

        // 9.
        char[] helloChars = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Number of vowels: " + countVowels(helloChars));

        // 10.
        double[] values = {1.5, 2.5, 3.5};
        double[] scaledValues = scaleArray(values, 2);
        System.out.println("Scaled array: " + Arrays.toString(scaledValues));
    }
}