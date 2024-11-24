
public class ProblemSet3Sol {

    // 1. Basic Function
    // Write a function called "greet" that takes no parameters and prints "Hello, World!".
    // Call the function inside the main method.

    /**Prints a greeting message */
    public static void greet() {
        System.out.println("Hello, World!");
    }

    // 2. Function with Parameters
    // Write a function called "add" that takes two integers as parameters and returns their sum.
    // Call the function with two numbers and print the result.
    
    /**Returns the addition of two numbers */
    public static int add(int a, int b) {
        return a + b;
    }

    // 3. Function with Return Type
    // Write a function called "multiply" that takes two doubles as parameters, multiplies them, and returns the result.
    // Call the function and store the result in a variable called "product".
    
    /**Returns the multiplication of two numbers */
    public static double multiply(double x, double y) {
        return x * y;
    }

    // 4. Function Overloading
    // Write two overloaded functions called "max". 
    // One should take two integers and return the larger of the two.
    // The other should take two doubles and return the larger of the two.
    // Test both functions by calling them in the main method.
    
    /**Returns the maxmial value berween two integers */
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**Returns the maxmial value berween two doubles */
    public static double max(double a, double b) {
        return a > b ? a : b;
    }

    // 5. String Manipulation
    // Write a function called "reverseString" that takes a String as a parameter and returns the reversed version of the string.
    // Example: reverseString("hello") should return "olleh".
    
    /**Returns a reversed copy of a given string */
    public static String reverseString(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    // 6. Character Count in String
    // Write a function called "countChar" that takes a string and a character as parameters and returns the number of times that character appears in the string.
    // Example: countChar("apple", 'p') should return 2.
    
    /**Returns the number of times a given character appears in a given string */
    public static int countChar(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    // 7. Function with Default Return
    // Write a function called "isVowel" that takes a char as a parameter and returns true if the character is a vowel (a, e, i, o, u), and false otherwise.
    
    /**Checks if a given character is a vowel ('a', 'e', 'i', 'o', 'u') */
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // 8. Function with String Array
    // Write a function called "printChars" that takes a string and prints each of its chars on a new line.
    // Test the function by passing a string.
    
    /**Prints the characters of a given string in consecutive separate lines */
    public static void printChars(String word) {
        for (int i = 0; i < word.length(); i++) {
            System.out.println(word.charAt(i));
        }
    }

    // 9. Palindrome Checker
    // Write a function called "isPalindrome" that takes a string and returns true if the string is a palindrome (the same forwards and backwards), and false otherwise.
    // Example: isPalindrome("racecar") should return true.
    
    /**Check if a given string is a palindrom */
    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return reversed.equals(str);
    }

    // 10. Function Returning Character
    // Write a function called "firstNonRepeatingChar" that takes a string and returns the first character that doesn't repeat.
    // Example: firstNonRepeatingChar("swiss") should return 'w'.
    
    /**Returns the first non repeating character in a given string. If one does not exists, returns '_' */
    public static char firstNonRepeatingChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (countChar(str, ch) == 1) {
                return ch;
            }
        }
        return '_';  // Return '_' if no non-repeating character is found
    }

    public static void main(String[] args) {
        // 1  .
        greet();

        // 2.
        int result = add(3, 5);
        System.out.println("Sum: " + result);

        // 3.
        double product = multiply(4.5, 2.3);
        System.out.println("Product: " + product);

        // 4.
        System.out.println("Max of 5 and 8: " + max(5, 8));
        System.out.println("Max of 4.5 and 3.7: " + max(4.5, 3.7));

        // 5.
        System.out.println("Reversed string: " + reverseString("hello"));

        // 6.
        System.out.println("Count of 'p' in 'apple': " + countChar("apple", 'p'));

        // 7.
        System.out.println("Is 'a' a vowel? " + isVowel('a'));
        System.out.println("Is 'b' a vowel? " + isVowel('b'));

        // 8.
        String word = "banana";
        printChars(word);

        // 9.
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));

        // 10.
        System.out.println("First non-repeating char in 'swiss': " + firstNonRepeatingChar("swiss"));
    }
}