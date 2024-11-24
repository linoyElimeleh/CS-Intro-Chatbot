// Demonstrates the Collatz conjecture.
public class Collatz {
	public static void main(String args[]) {
	    int N = Integer.parseInt(args[0]); 
		String mode = args[1];
		// Checks the Collatz conjecture for seeds going from 1 to N.
		for (int seed = 1; seed <= N; seed++) {
			int x = seed;
			boolean flag = false;
			String output = x + " ";
			// Generates a hailstorm sequence, until it reaches 1.
			int count = 1;
			while(x != 1 || !flag) {
				if (!flag) {
					flag = true;
				}
				if (x % 2 == 0) {
					x = x / 2;
				} else {
					x = 3 * x + 1;
				}
				output = output + x + " ";
				count++;
			}
			if (mode.equals("v")) {
				System.out.println((output + "(" + count + ")"));
			}
		}
		System.out.println("The first " + N + " hailstone sequences reached 1.");
	}
}