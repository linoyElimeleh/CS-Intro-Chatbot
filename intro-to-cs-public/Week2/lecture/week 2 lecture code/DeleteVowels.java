// Deletes vowels from a given string
public class DeleteVowels {
	public static void main(String[] args) {
		String s = args[0];
		String vowels = "aeiou";
		
		String sOut = "";
		int i = 0;
		while (i < s.length()) {
			char c =  s.charAt(i);
			if (vowels.indexOf(c) == -1) {
			    sOut = sOut + c;
			}
			i++;
		}
		System.out.println(sOut);
	}
}