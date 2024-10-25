// Prints the powers of 2 up to 2^N
public class PowersOf2 {
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int i = 0;  // loop control counter
		int v = 1;  // current power of two
		while (i <= N) {
		    System.out.println(i + " " + v);
		    i = i + 1;
		    v = 2 * v;
		}
	}
}
