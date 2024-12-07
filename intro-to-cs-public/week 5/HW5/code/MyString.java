/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        System.out.println(MyString.subsetOf("sap","space"));
        System.out.println(MyString.subsetOf("spa","space"));
        System.out.println(MyString.subsetOf("pass","space"));
        System.out.println(MyString.subsetOf("c","space"));
        System.out.println("..." + MyString.spacedString("foobar") + "...");
        System.out.println(MyString.randomStringOfLetters(3));
        // Put more tests of your own here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char c) {
        //// Replace the following statement with your code.
        return 0;
    }

    /** Returns true if str1 is a subset string str2, false otherwise.
     *  For example, "spa" is a subset of "space", and "pass" is not
     *  a subset of "space".
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        //// Replace the following statement with your code.
        return false;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for last character of the string, that has no space after it. 
     * Example: if str is "silent", returns "s i l e n t".
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        //// Replace the following statement with your code.
        return null;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        //// Replace the following statement with your code.
        return null;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: "committee" minus "meet" returns "comit". 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        //// Replace the following statement with your code.
        return null;
    }
}
