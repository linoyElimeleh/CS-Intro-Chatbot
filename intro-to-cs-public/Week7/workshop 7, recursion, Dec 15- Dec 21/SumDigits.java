
public class SumDigits {

	public static void main(String[] args) {
		System.out.println(sumDigits(987));

	}
	
	/**
	* calculate the sum of digits of a given positive integer - n
	*/
	public static int sumDigits(int n) {
		if (n == 0) return 0;
		return n % 10 + sumDigits(n / 10); 
	}

}
