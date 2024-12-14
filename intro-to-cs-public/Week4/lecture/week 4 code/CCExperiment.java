
//Computes How many times you have to draw random integers between​
//0 and N-1 until all integers 0,1,2 ,…, N-1 have been drawn​
public class CCExperiment {
	
	public static void main(String[] args) {
		final int N = Integer.parseInt(args[0]);  // number of objects​
		final int T = Integer.parseInt(args[1]);  // number of trials​
		double sum = 0;
		for (int t=0; t<T; t++) {
			sum = sum + couponCollector(N);
		}
		System.out.println("Average number of trials to obtain " + N
				+ " values: " + sum / T );
	}

	// Computes How many times you have to draw random integers between ​
	// 0 and N-1 until all the integers 0,1,2,…N-1 have been drawn​
	public static int couponCollector(int N) {

		int count = 0;     // number of values drawn so far​
		int nDistinct = 0; // number of distinct values drawn so far​

		boolean[] found = new boolean[N];
		for (int i=0; i<N; i++) found[i] = false;

		// Runs the simulation​
		while (nDistinct < N) { 
			// Draws a random integer between 0 and N-1, and updates the relevant counters​
			int val = (int) (Math.random() * N);
			count++;
			if (!found[val]) {
				nDistinct++;
				found[val] = true;
			}
		}
		return count;
	}
}