import java.util.Arrays;

public class MyStrings_Tests {

    static final int[] SCRABBLE_LETTER_VALUES = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10 };
	public static void main(String[] args){
		String func = args[0];
		int points = -5;
		boolean flag = false;
		switch (func) {
			case "subsetOf":
				flag = subsetOf(args[1], args[2]) == MyString.subsetOf(args[1], args[2]);
				break;
			case "spacedString":
				flag = spacedString(args[1]).equals(MyString.spacedString(args[1]));
				break;
			case "randomStringOfLetters":
				int n = Integer.parseInt(args[1]);
				String str = MyString.randomStringOfLetters(n);
				flag =  str.length() == n && str.matches("[a-z]+");
				break;
			case "remove":
				String str1 = remove(args[1], args[2]);
				String str2 = MyString.remove(args[1], args[2]);
			    if (str1.length() != str2.length()){
			        break;
			    }
			 
			    char[] a = str1.toCharArray();
			    char[] b = str2.toCharArray();
			    Arrays.sort(a);
			    Arrays.sort(b);
			    flag = Arrays.equals(a, b);
				break;
			case "getWordScore":
				int m = Integer.parseInt(args[2]);
				flag = getWordScore(args[1], m) == (Scrabble.getWordScore(args[1], m));
				break;
			case "countChar":
				flag = countChar(args[1], args[2].charAt(0)) == (MyString.countChar(args[1], args[2].charAt(0)));
				break;		
		}
		
		if(!flag){
			System.out.println("GETFEED: " + func + " failed test. " + points);
		}
	}
	
	public static boolean subsetOf(String str1, String str2) {
        boolean subset = true;
        for (int i = 0; i < str1.length(); i++) {
            int countStr1 = countChar(str1, str1.charAt(i));
            int countStr2 = countChar(str2, str1.charAt(i));
            if (countStr1 > countStr2) {
                subset = false;
            }
        }
        return subset;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for last character of the string, that has no space after it. 
     * Example: if str is "silent", returns "s i l e n t".
     * 
     * @param str - a string
     * @return the characters of 'str', separated by spaces.
     */
    public static String spacedString(String str) {
        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i);
            if (i < str.length() - 1) {
                ans += " ";
            }
        }
        return ans;
    }
  
    /**
     * Returns a string of n lower-case letters. Each letter is selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'.
     * 
     * @param n - a given integer
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String str = "";
        for (int i = 0; i < n; i++) {
            // Draws a random int between 0 and 25
            int rand = (int)(Math.random() * 26);
            // Gets the letter in the randomly drawn index
            char c = (char)(rand + 'a');
            str += c;
        }
        return str;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (wuthout checkinh) that str2 is a subset of str1.
     * Example: "committee" minus "meet" returns "comit". 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return the updated str1, as a new string
     */
    public static String remove(String str1, String str2) {
        for (int i = 0; i < str2.length(); i++) {
            int index = str1.indexOf(str2.charAt(i));
            str1 = str1.substring(0, index) + str1.substring(index + 1);
        }
        return str1;
    }

    // Checks is the given string is in the given array of strings.
    public static boolean inStringArray(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (str.equals(strArr[i])) return true;
        }
        return false;
    }



    // returns the number of times the given character appears in the given string.
    private static int countChar(String s, char c) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) ans++;
        }
        return ans;
    }
    
    public static int getWordScore(String word, int n) {
		int ans = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			ans += SCRABBLE_LETTER_VALUES[c - 'a'];
		}
		ans *= word.length();
		if (word.length() == n) ans += 50;
		return ans;
	}
}
