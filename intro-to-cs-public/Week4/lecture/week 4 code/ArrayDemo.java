
// Illustrates some array operations.
public class ArrayDemo {
	public static void main(String[] args) {

		// Builds a small array, for testing purposes​
		int[] sales = {22, 37, 24, 40, 32, 36};

		// Computes and prints the sales average​
		int sum = 0;
		for (int i = 0; i < sales.length; i++) {
			sum += sales[i]; // same as sum = sum + sales[i];​
		}
		System.out.println("The sales average is " + sum / sales.length);

		// Prints the largest sales figure​
		int max = sales[0];
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] > max) {
				max = sales[i];
			}
		}
		System.out.println("Largest sale figure: " + max);

		// Prints the smallest sales figure, and the index of the least-selling region
		int min = sales[0];
		int minIndex = 0;
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] < min) {
				min = sales[i];
				minIndex = i;
			}
		}
		System.out.println("Region " + minIndex +
                           " had the least sales, with " + min + " units sold");

		// Increases all sales by 10%, rounding to int
		for (int i = 0; i < sales.length; i++) {
			sales[i] = (int) (sales[i] * 1.1);
		}

		// Prints all the sales
		for (int i = 0; i < sales.length; i++) {
			System.out.print(sales[i] + " ");
		}
		System.out.println();
	}
}