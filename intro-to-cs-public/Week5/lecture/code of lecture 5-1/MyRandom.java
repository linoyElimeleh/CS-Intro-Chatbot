/** Library of statistical and random functions. */
public class MyRandom {
    
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
