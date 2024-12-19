
public class PrintedFibo {

	public static void main(String[] args) {
		System.out.print(printedFibo(5));
	}

	/**
	* compute the end of Fibbonaci's function with input - n
	*/
	public static int fibo(int n) {
		int ans;
		if (n == 0 || n == 1) {
			ans = n;
		} else {
			ans = fibo(n - 1) + fibo(n - 2);
		}
		return ans;
	}
	
	/**
	* compute the end of Fibbonaci's function with input - n
	* prints the recursion stages while running
	*/
	public static int printedFibo(int n) {
		System.out.println("Start of Fibbonaci's function with input: " + n);
		int ans;
		if (n == 0 || n == 1) {
			System.out.println("Base / stop condition reached");
			ans = n;
		} else {
			ans = printedFibo(n - 1) + printedFibo(n - 2);
		}
		System.out.println("End of Fibbonaci's function with input: " + n);
		return ans;
	}
}

