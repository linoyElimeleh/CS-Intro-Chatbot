
public class CatalanNumbers {

	public static void main(String[] args) {
		System.out.println(catalan(15));

	}
	
	/**
	* calculate the n'th Catalan Number
	*/
	public static int catalan (int n){
		if (n == 0) return 1;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += catalan(i) * catalan(n - 1 - i);
		}
		return ans;
	}

}
