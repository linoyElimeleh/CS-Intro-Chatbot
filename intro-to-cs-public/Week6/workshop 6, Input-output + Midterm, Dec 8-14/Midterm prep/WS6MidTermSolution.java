public class WS6MidTermSolution {
    public static void main(String[] args) {
        
    }

    /**
     * The following function reverses a string
     * @param str - the string to reverse
     * @return
     * Example: "Hello" -> "olleH"
     * Example: "World" -> "dlroW"
     * Example: "Java" -> "avaJ"
     * Example: "racecar" -> "racecar"
     */
    public static String reverseString(String str){
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

       
    /**
     * The following function check if a string is a palindrome
     * a palindrome is a word that reads the same forwards and backwards
     * @param str - the string to check if it is a palindrome
     * @return
     * Example: "racecar" -> true
     * Example: "hello" -> false
     * Example: "madam" -> true
     * Example: "Java" -> false
     * Example: "level" -> true
     * Example: "noon" -> true
     */
    public static boolean isPalindrome(String str){
        return str.equals(reverseString(str));
    }
    /**
     * The following function receives a string containing words separated by single spaces
     * and returns a string with the words in reverse order
     * @param str - the string to reverse order the words
     * @return
     * Example: "Hello World" -> "World Hello"
     * Example: "Hello World Java" -> "Java World Hello"
     */
    public static String reverseWordsOrderString(String str){
        String result = "";
        String currentWord = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                result = currentWord + " " + result;
                currentWord = "";
            } else {
                currentWord += str.charAt(i);
            }
        }
        return result;
    }

    /**
     * The following function receives a string containing words separated by single spaces
     * and returns a string with each word reversed
     * @param str - the string to reverse
     * @return
     * Example: "Hello World" -> "olleH dlroW"
     * Example: "Hello World Java" -> "olleH dlroW avaJ"
     * Example: "racecar" -> "racecar"
     */
    public static String reverseWordsString(String str){
        String result = "";
        String currentWord = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                result += reverseString(currentWord) + " ";
                currentWord = "";
            } else {
                currentWord += str.charAt(i);
            }
        }
        return result;
    }


    /**
     * The following function receives a string containing words 
     * The function reverses the case of each character in the string
     * Such that all uppercase letters are converted to lowercase and vice versa
     * @param str - the string to reverse case
     * @return
     * Example: "Hello World" -> "hELLO wORLD"
     * Example: "tHis IS My StRiNg" -> "ThIS is mY sTrInG"
     * Example: "fOoBar" -> "FoObAR"
     */
    public static String reverseCaseString(String str){
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (isLowerCase(currentChar)){
                result += letterToUpper(currentChar);
            } else if (isUpperCase(currentChar)){
                result += letterToLower(currentChar);
            } else {
                result += currentChar;
            }
        }
        return result;
    }


    public static boolean isLowerCase(char c){
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isUpperCase(char c){
        return c >= 'A' && c <= 'Z';
    }

    public static char letterToUpper(char chr){
        return ('a' <= chr && chr <= 'z') ? (char) (chr - ' ') : chr;
    }

    public static char letterToLower(char chr){
        return ('A' <= chr && chr <= 'Z') ? (char) (chr + ' ') : chr;
    }


        
    /**
     * Find the Smallest Missing Positive Integer
     * The following function receives an array of integers
     * The function returns the smallest positive integer that is missing
     * @param arr - the array of integers
     * @return
     * Example: [1, 2, 3, 4, 5] -> 6
     * Example: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] -> 11
     * Example: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12] -> 11
     * Example: [1, -1, -2, -3, -4, -5] -> 2
     * Example: [1, -1, 3, 4] -> 2
     * Example: [-1, 3, 4, 1] -> 2
     */
    public static int findSmallestMissingPositiveInteger(int[] arr){
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && arr[i] <= n){
                present[arr[i]] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]){
                return i;
            }
        }
        return n + 1;
    }  
    
    /**
     * The following function recieves a couple of integer set arrays
     * I.E every element in unique in the array
     * The function returns if the first set is a subset of the second set
     * @param set1 - the first set
     * @param set2 - the second set
     * @return
     * Example: {1, 2, 3} {1, 2, 3, 4, 5} -> true
     * Example: {1, 2, 3} {1, 2, 4, 5} -> false
     * Example: {1, 2, 3} {1, 2, 3} -> true
     * Example: {1, 2, 3, 4, 5} {1, 2, 3} -> false
     */
    public static boolean isSubset(int[] set1, int[] set2){
        for (int i = 0; i < set1.length; i++) {
            boolean found = contains(set2, set1[i]);
            if (!found){
                return false;
            }
        }
        return false;
    }
    public static boolean contains(int[] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return true;
            }
        }
        return false;
    }   
}
