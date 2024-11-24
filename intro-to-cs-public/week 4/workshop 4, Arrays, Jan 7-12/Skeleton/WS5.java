// Hey everyone,
// In this exercise we will deal with an one-dimensional arrays
// We have a single file (this one), functions will be added to it one by one, 
// and the main function should be adjusted accordingly.
// 1) we will implement function which prints an given array.
// 2) we will create a simple array
// 3) we will create an arithmetic serie
// 4) we will create a geometric serie
// 5) we will create fibonacci serie
// 6) we wil count vowels in a given string array
class WS5 {
    public static void main(String[] args) {
        // Here you should change functions call
    }

	// Given an array, print its content,
	// note, you shouldn't use System.out.println(arr)
    public static void print(int[] arr) {
        return;
    }

	// The array should have the number i at index i,
	// Example: simple(5) will create the array {0,1,2,3,4}.
    public static int[] simple(int n) {
        return new int[0];
    }

	// Given two natural numbers, a and d, 
	// we define an arithmetic sequence to be all numbers of the form a + i*d,
	// where i is some natural number
	// Examples:
	// a = 0, d = 1:  The sequence we get is 0,1,2,3,4,5
	// a = 2, d = 3:  The sequence we get is 2,5,8,11,14....
    public static int[] arithmetic(int n, int a, int d) {
        return new int[0];
    }
	

	//// we define an geometric sequence to be all numbers of the form a(i) = a(i-1)*d
	//// where i is some natural number
	//// Examples:
	//// a = 1, d = 2:  The sequence we get is 1,2,4,8,16,32
	//// a = 2, d = 3:  The sequence we get is 2,6,18,54,162....
    private static int[] geometric(int n, int a, int d) {
        return new int[0];
    }

	// The Fibonacci sequence is defined the following way:
	// F(0) = 0
	// F(1) = 1
	// And every other element of the sequence is defined as the sum of previous two.
	// F(n) = F(n-1) + F(n-2)
	// Example:
	// 0, 1, 1, 2, 3, 5, 8, 13, 21..
    public static int[] fibo (int n) {
        return new int[0];
    }

	// A vowel is any of the letters {a,e,i,o,u}.
	// The function takes in an array of strings and counts the amount of vowels in all of the strings.
    public static String[] removeVowels (String[] args) {
        return new String[0];
    }
}