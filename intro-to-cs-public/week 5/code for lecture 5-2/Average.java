/** Reads some numbers from standard input and prints their average. */
public class Average {
	public static void main(String[] args) {
		// Creates an In object for representing standard input
		In in = new In();
		double sum = 0.0;  // running total
		int n = 0;         // number of values
		double x = in.readDouble();
		while (x != -1 && !in.isEmpty()) {
			sum = sum + x;
			n++;
			x = in.readDouble();
		}

		System.out.println("The average is: " + sum / n);
	}
}