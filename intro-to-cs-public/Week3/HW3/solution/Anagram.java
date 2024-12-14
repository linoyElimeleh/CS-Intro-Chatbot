/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Preprocess both strings
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		
		// Remove spaces for comparison
		str1 = str1.replace(" ", "");
		str2 = str2.replace(" ", "");
		
		// Check lengths after removing spaces
		if (str1.length() != str2.length()) {
			return false;
		}
		
		// For each character in str1
		String checked = "";  // Keep track of already checked characters
		for (int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			
			// Skip if we already checked this character
			if (checked.indexOf(c) >= 0) continue;
			checked += c;
			
			// Count occurrences in both strings
			int count1 = 0;
			int count2 = 0;
			
			// Count in str1
			for (int j = 0; j < str1.length(); j++) {
				if (str1.charAt(j) == c) {
					count1++;
				}
			}
			
			// Count in str2
			for (int j = 0; j < str2.length(); j++) {
				if (str2.charAt(j) == c) {
					count2++;
				}
			}
			
			// If counts don't match, not an anagram
			if (count1 != count2) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// Convert uppercase to lowercase
			if (c >= 'A' && c <= 'Z') {
				c = (char)(c + ('a' - 'A'));
			}
			// Keep only lowercase letters and spaces
			if (c == ' ' || (c >= 'a' && c <= 'z')) {
				ans = ans + c;
			}
		}
		return ans;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String ans = "";
		while (str.length() > 0) {
			int rand = (int)(str.length() * Math.random());
			ans += str.charAt(rand);
			str = str.substring(0, rand) + str.substring(rand + 1);
		}
		return ans;
	}
}