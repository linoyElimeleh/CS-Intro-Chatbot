public class RndTest {
   public static void main(String args[]) {
      // Tests the rnd function
      // The array p represents some probability distribution function (pdf):
      // p[i] represents the probability that i occurs.
      double[] p = {.2, .2, .6};

      // Prints the probability distribution
      System.out.println("Expected distribution:\n");
      for (int i = 0; i < p.length; i++) {
          System.out.println(i + " should occur " + p[i] + " of the time");
      }
    	
      // Number of trials
      int T = Integer.parseInt(args[0]);
      // Counts how many times each event occurred
      int[] count = new int[p.length];
  
      // Generates T random values, and counts
      // how many times each value occurred.
      for (int t = 0; t < T; t++) {
           count[rnd(p)]++;
      }
 	    
      System.out.println("\nActual distribution after " + T + " trials:\n");
      for (int i = 0; i < count.length; i++) {
          System.out.println(i + " occurred " +  ((double) count[i] / T) + " of the time");
      }
   }
    // Generates a random value from a distribution p, represented as array.
    // Returns a value 0,1,...n-1 with probability p[0],p[1],...,p[n-1].
    public static int rnd(double[] p) {
        // Computes the cumulative distribution function (cdf)
        double[] P = new double[p.length];
        P[0] = p[0];
        for (int i = 1; i < p.length; i++)  {
            P[i] = P[i-1] + p[i];
        }
    	    
        // draws a random number in [0,1), and returns where it falls in the cdf
        double r = Math.random();
        for (int i = 0; i < P.length; i++)  {
            if (r <= P[i]) return i;
        }
        return 0;  // compilation requirement
    } 
}
