
public class PrintedFactorial {

	public static void main(String[] args) {
		System.out.print(printedFactorial(4));
	}
	
	/**
	* Compute the factorial of a given number - n
	*/
	public static int factorial(int n) {
		int ans;
		if (n == 0) {
			ans = 1;
		} else {
			ans = n * factorial(n - 1);
		}
		return ans;
	}
	
	/**
	* Compute the factorial of a given number - n
	* prints the recursion stages while running
	*/
	public static int printedFactorial(int n) {
		System.out.println("Start of factorial function with input: " + n);
		int ans;
		if (n == 0) {
			System.out.println("Base / stop condition reached");
			ans = 1;
		} else {
			ans = n*printedFactorial(n - 1);
		}
		System.out.println("End of factorial function with input: " + n);
		return ans;
	}
}
