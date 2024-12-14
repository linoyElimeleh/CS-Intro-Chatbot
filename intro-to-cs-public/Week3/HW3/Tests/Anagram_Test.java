
public class Anagram_Test {
	public static void main(String[] args) {
		testPre("Wubba lubba dub dub!");
		testPre("What? No way!");
		testPre("Is that your final answer?");
		testPre("Bazinga!");
		
		testAnagram("eleven plus two", "twelve plus one");
		testAnagram("eleven minus two", "twelve plus one");
		testAnagram("I am Lord Voldemort", "Tom Marvolo Riddle");
		testAnagram("I am Lord Voldemort", "I am Lord Voldemord");
		testAnagram("abc", "aabbcc");
		testAnagram("aabbcc", "abc");
		testAnagram("aabc", "abbc");
		testAnagram("aabbc", "aabbc");
		
		String a = "Thou shalt not make a machine in the likeness of a human mind";
		String b = "There's no secret to balance. You just have to feel the waves.";
		for (int i = 0; i < 5; i++) {
			String randa = "";
			String randb = "";
			try{
				randa = Anagram.randomAnagram(a);
			} catch(Exception e){
				System.out.println("randomAnagram" + "\tfalse" + "\t exception thrown with inputs: " + b);
			}
			try{
				randb = Anagram.randomAnagram(b);
			} catch(Exception e){
				System.out.println("randomAnagram" + "\tfalse" + "\t exception thrown with inputs: " + b);
			}
			try{
				test("randomAnagram", isAnagram(randa, a) == true, randa, a);
				test("randomAnagram", isAnagram(randb, b) == true, randb, b);
			} catch (Exception e){
				System.out.println("randomAnagram" + "\tfalse" + "\t exception thrown");
			}
			try{
				test("isAnagram", Anagram.isAnagram(randa, a) == true, randa, a);
				test("isAnagram", Anagram.isAnagram(randb, b) == true, randb, b);
				test("isAnagram", Anagram.isAnagram(randb, randa) == false, randb, randa);
			} catch (Exception e){
				System.out.println("isAnagram" + "\tfalse" + "\t exception thrown");
			}
		}
	}
	
	public static void testPre (String input1){
		String func = "preProcess";
		try{
			test(func, Anagram.preProcess(input1).equals(preProcess(input1)), input1, "");
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with input: " + input1);
		}
	}
	
	public static void testAnagram (String input1, String input2){
		String func = "isAnagram";
		try{
			test(func, Anagram.isAnagram(input1, input2) == isAnagram(input1, input2), input1, input2);
		} catch(Exception e){
			System.out.println(func + "\tfalse" + "\t exception thrown with input: " + input1 + ", " + input2);
		}
	}
	
	public static void test (String func, boolean res , String input1, String input2) {
		if (!res) System.out.println(func + "\t" + res +"\t with inputs: " + input1 + " " + input2);
		else System.out.println(func + "\t" + res);
	}
	
	
	public static boolean isAnagram(String str1, String str2) {
		   str1 = preProcess(str1);
		   str2 = preProcess(str2);
		   if (str1.length() != str2.length()){
			   return false;
		   }
		   for (int i = 0; i < str1.length(); i++) {
			   char c = str1.charAt(i);
			   int count1 = 0;
			   int count2 = 0;
			   for (int j = 0; j < str1.length(); j++) {
				   if (str1.charAt(j) == c) count1++;
				   if (str2.charAt(j) == c) count2++;
			   }
			   if (count1 != count2) return false;
		   }
	       return true;
	   }
	   
	   // Returns a preprocessed version of the given string: all the letter characters
	   // are converted to lower-case, and all the other characters are deleted. For example, 
	   // the string "What? No way!" becomes "whatnoway"
	   public static String preProcess(String str) {
		   String ans = "";
		   for (int i = 0; i < str.length(); i++) {
			   char c = str.charAt(i);
			   if (c >= 'a' && c <= 'z') {
				   ans += c;
			   }
			   if (c >= 'A' && c <= 'Z') {
				   ans += (char)(c - ('A' - 'a'));
			   }
		   }
	       return ans;
	   } 
	   
	   // Returns a random anagram of the given string. The random anagram consists of the same
	   // letter characters as the given string, arranged in a random order.
	   // SIDE EFFECT: This implementation destroys the given string. You may either implement
	   // the function this way, or use an implementation that does not destroy the given string
	   // (in which case you should change the function documentation).  
	   public static String randomAnagram(String str) {
		   String ans = "";
		   while (str.length() > 0) {
			   int rand = (int)(str.length() * Math.random());
			   ans += str.charAt(rand);
			   str = str.substring(0, rand) + str.substring(rand + 1);
		   }
	       return ans;
	   }
}
