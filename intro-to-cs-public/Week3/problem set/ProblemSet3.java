
public class ProblemSet3 {

    // 1. Basic Function
    // Write a function called "greet" that takes no parameters and prints "Hello, World!".
    // Call the function inside the main method.

    // Put your code here:

    // 2. Function with Parameters
    // Write a function called "add" that takes two integers as parameters and returns their sum.
    // Call the function with two numbers and print the result.
    
    // Put your code here:

    // 3. Function with Return Type
    // Write a function called "multiply" that takes two doubles as parameters, multiplies them, and returns the result.
    // Call the function and store the result in a variable called "product".
    
    // Put your code here:

    // 4. Function Overloading
    // Write two overloaded functions called "max". 
    // One should take two integers and return the larger of the two.
    // The other should take two doubles and return the larger of the two.
    // Test both functions by calling them in the main method.
    
    // Put your code here:

    // 5. String Manipulation
    // Write a function called "reverseString" that takes a String as a parameter and returns the reversed version of the string.
    // Example: reverseString("hello") should return "olleh".
    
    // Put your code here:

    // 6. Character Count in String
    // Write a function called "countChar" that takes a string and a character as parameters and returns the number of times that character appears in the string.
    // Example: countChar("apple", 'p') should return 2.
    
    // Put your code here:

    // 7. Function with Default Return
    // Write a function called "isVowel" that takes a char as a parameter and returns true if the character is a vowel (a, e, i, o, u), and false otherwise.
    
    // Put your code here:

    // 8. Function with String Array
    // Write a function called "printChars" that takes a string and prints each of its chars on a new line.
    // Test the function by passing a string.
    
    // Put your code here:

    // 9. Palindrome Checker
    // Write a function called "isPalindrome" that takes a string and returns true if the string is a palindrome (the same forwards and backwards), and false otherwise.
    // Example: isPalindrome("racecar") should return true.
    
    // Put your code here:

    // 10. Function Returning Character
    // Write a function called "firstNonRepeatingChar" that takes a string and returns the first character that doesn't repeat.
    // Example: firstNonRepeatingChar("swiss") should return 'w'.
    
    // Put your code here:
    

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