import java.util.HashMap;

/** Map demo, used Java's generic HashMap class. */
public class HashMapDemo2 {

	// A hashmap for memoizing results of the Fibonacci function
	static HashMap<Integer, Long> memoFib = new HashMap<>();

    // Computes the Fibonacci function
	public static long fib(int n) {
        if (n <= 1) return n; // Base case

        // If already computed, returns the stored value
        if (memoFib.containsKey(n)) {
           return memoFib.get(n);
		}

        // Computse and stores in the HashMap
        long result = fib(n - 1) + fib(n - 2);
        memoFib.put(n, result);
        return result;
    }

    public static void main(String[] args) {		
		Timer timer = new Timer();		
		System.out.println("Fibonacci(50): " + fib(50) + 
		                   "; Compute time: " + timer.elapsedTime() + " ms");

		timer.reset();
		System.out.println("Fibonacci(50): " + fib(50) + 
		                   "; Compute time: " + timer.elapsedTime() + " ms");
	}
}