/** Recieves a command line string and prints all the possible permutations of that string. */
public class Permutations {
	
	public static void main	(String[] args) {
		permutations(args[0]);
	}
	
	public static void permutations(String s) {
		permutations(s, "");
	}
	
	public static void permutations(String s, String acc) {
		if (s.length() == 0) {
			StdOut.println(acc);
		}
		else{
			for (int i = 0; i < s.length(); i++){
				permutations(s.substring(0, i) + s.substring(i+1, s.length()), acc + s.charAt(i));
			}
		}
	}
}
