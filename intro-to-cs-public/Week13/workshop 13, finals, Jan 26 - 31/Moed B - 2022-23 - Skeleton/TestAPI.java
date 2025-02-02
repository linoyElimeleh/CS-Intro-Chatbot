// This class was created by Intro to Computer Science staff 2022 - 2023 at Reichman University
// was used for finals moed B 2022-2023
// was given as API to be used in the exam (no need to implement it)
// Implementation wasn't shown in the exam, and could be used regularly in the exam.
// implemented by: Tal Danai, position: Recitation TA
public class TestAPI {
    // The following methods are the same as the ones in the String class
    // could be used in the exam as: str.length(), str.charAt(index), str.substring(start) etc.

    // Returns the length of the given string.
    public static int length(String str) {
        return str.length();
    }

    // Returns the character at the given index in the given string.
    // @param index the index of the character to return
    public static char charAt(String str, int index) {
        return str.charAt(index);
    }

    // Returns the substring of the given string that starts at the given index.
    // @param start the index of the first character in the substring
    public static String substring(String str, int start) {
        return str.substring(start);
    }

    // Returns the substring of the given string that starts at the first given index and ends at the second given index.
    // @param start the index of the first character in the substring
    // @param end the index of the first character after the substring
    public static String substring(String str, int start, int end) {
        return str.substring(start, end);
    }

    // Return 0 if the two given strings are equal, a negative number if the first string is lexicographically smaller than the second string,
    // and a positive number if the first string is lexicographically larger than the second string.
    public static int compareTo(String str1, String str2) {
        return str1.compareTo(str2);
    }

    // retruns the same string but in lower case
    public static String toLowerCase(String str) {
        return str.toLowerCase();
    }


    // Object class methods
    // could be used in the exam as: obj1.equals(obj2), obj1.toString(), obj1.getClass()
    // Returns true if the given objects are equal.
    public static boolean equals(Object obj1, Object obj2) {
        return obj1.equals(obj2);
    }

    // Returns a string representation of the given object.
    public static String toString(Object obj) {
        return obj.toString();
    }

    // Returns the class of the given object.
    public static Class<?> getClass(Object obj) {
        return obj.getClass();
    }
}
