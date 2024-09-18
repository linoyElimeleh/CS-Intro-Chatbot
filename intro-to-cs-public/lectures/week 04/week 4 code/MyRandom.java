public class MyRandom {
    public static void main(String args[]) {
        // Tests the CDF and rnd functions by generating events and observing their actual distribution
        // The array p represents a probability distribution function (PDF):
        // p[i] represents the probability that event i occurs.
        double[] p = {.2, .2, .6};

        double[] p = {.2, .2, .6};
        
        // Prints the probability distribution
        System.out.println("Expected distribution:\n");
        for (int i = 0; i < p.length; i++) {
            System.out.println(i + " should occur " + p[i] + " of the time");
        }
        
        // Number of trials
        int T = Integer.parseInt(args[0]);
        // Stores how many times each event occurred
        int[] count = new int[p.length];
        
        // Creates the Cumulative Distribution Function of p
        double[] P = CDF(p);
        
        // Generates T random values, and counts how many times each value occurred.
        for (int t = 0; t < T; t++) {
            count[rnd(P)]++;
        }
        
        System.out.println("\nActual distribution after " + T + " trials:\n");
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " occurred " +  ((double) count[i] / T) + " of the time");
    }

    /** Creates and returns a Cumulative Distribution Function from a given distribution function. */
    public static double[] CDF(double[] p) {
        double[] P = new double[p.length];
        P[0] = p[0];
        for (int i = 1; i < p.length; i++)  {
            P[i] = P[i-1] + p[i];
        }
        return P;
    }

    /** Generates a random integer 0,1,...n-1 from a given CDF of size n. */
    public static int rnd(double[] P) {   	    
        // draws a random number in [0,1), and returns where it falls in the CDF
        double r = Math.random();
        for (int i = 0; i < P.length; i++)  {
            if (r <= P[i]) return i;
        }
        return 0;  // compilation requirement
    } 
}
