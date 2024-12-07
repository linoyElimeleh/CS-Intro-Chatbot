import java.util.Arrays;

public class ProblemSet4Hints {

    // 3. Sum of array elements
    // Write a function called "sumArray" that takes an array of integers and returns the sum of all elements.
    // Test the function using the "numbers" array from problem 1.
    public static int sumArray(? arr) {
        int sum = 0;
        for (?) {
            sum += ?;
        }
        return sum;
    }

    // 4. Minimum value in an array
    // Write a function called "minValue" that takes an array of integers and returns the smallest value.
    // Test the function using the "numbers" array from problem 1.
    
    public static int minValue(? arr) {
        ? min = ?;
        for (?) {
            if (arr[i] < ?) {
                min = ?;
            }
        }
        return ?;
    }

    // 5. Reversing an array
    // Write a function called "reverseArray" that takes an array of integers and returns a new array with elements in reverse order.
    // Test the function using the "numbers" array from problem 1.
    
    public static ? reverseArray(? arr) {
        ? reversed = ?;
        for (?) {
            ? = arr[ arr.length - 1 - i ];
        }
        return reversed;
    }

    // 7. Searching in an array
    // Write a function called "findElement" that takes an array and an integer as parameters.
    // It should return the index of the first occurrence of the integer in the array, or -1 if the integer is not found.
    
    public static int findElement(? arr, int target) {
        for (?) {
            if ( ?) {
                return ?;
            }
        }
        return -1;
    }

    // 9. Array of characters
    // Write a function called "countVowels" that takes an array of characters and returns the number of vowels (a, e, i, o, u).
    // Test the function with an array of characters: {'h', 'e', 'l', 'l', 'o'}.
    
    public static int countVowels(? chars) {
        int count = 0;
        for (int i = 0; i < ?; i++) {
            char ch = chars[i];
            if (?) {
                count++;
            }
        }
        return count;
    }

    // 10. Array manipulation with doubles
    // Write a function called "scaleArray" that takes an array of doubles and a scaling factor.
    // It should return a new array where each element is multiplied by the scaling factor.
    // Test the function with an array of doubles: {1.5, 2.5, 3.5} and a scaling factor of 2.
    
    public static double[] scaleArray(? arr, ? factor) {
        ? scaled = ?;
        for (?) {
            scaled[i] = ? * ?;
        }
        return scaled;
    }


    public static void main(String[] args) {
        
        // 1. Array creation and initialization
        // Create an array of integers called "numbers" with values 1, 2, 3, 4, 5.
        // Print the array length and the first and last elements.
        
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Array length: " + numbers.?);
        System.out.println("First element: " + numbers[?]);
        System.out.println("Last element: " + numbers[?]);

        // 2. Iterating through an array
        // Write a for loop that prints each element in the "numbers" array from problem 1.
        
        for (int i = 0; i < ?; i++) {
            System.out.println(?);
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
        
        int[][] matrix = {{}, {}};
        for (int i = 0; i < ?; i++) {
            for (int j = 0; j < ?; j++) {
                System.out.print(matrix[?][?] + " ");
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