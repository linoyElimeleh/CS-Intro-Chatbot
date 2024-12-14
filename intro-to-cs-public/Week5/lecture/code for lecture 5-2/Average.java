/** Reads some numbers from standard input and prints their average. */
public class Average {
	public static void main(String[] args) {
		// Creates an In object for representing standard input
		In in = new In();
		// Assumption: At least one value
		double x = in.readDouble();
		int count = 1; 
		double sum = x;  // running total
		while (!in.isEmpty()) {
			x = in.readDouble();
			sum += x;
			count++;
		}
		System.out.println("Average: " + sum / count);
	}
}