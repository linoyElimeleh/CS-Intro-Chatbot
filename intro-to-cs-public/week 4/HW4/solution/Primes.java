public class Primes {
    public static void main(String[] args) {

        // Gets the limit up to which we wish to find all the prime numbers
        int n = Integer.parseInt(args[0]);

        // Initializes a boolean array of size n + 1
        boolean[] isPrime = new boolean[n + 1];
        for (int i=0; i < isPrime.length; i++) isPrime[i] = true;
        isPrime[0] = false;
        isPrime[1] = false;

        int limit = (int) Math.sqrt(n);

        // Eliminates all the multiples of each prime
        int p = 2;
        while (p <= limit) {
            if (isPrime[p]) {
                // Eliminates all multiples of p
                int multiple = p + p;
                while (multiple <= n) {
                    isPrime[multiple] = false;
                    multiple += p;
                }
            }
            p++; // Move to the next number
        }

        // Print the "surviving" prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        int numPrimes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i);
                numPrimes++;
            }
        }
        System.out.println("There are " + numPrimes + " primes between 2 and " + n + " (" + (int) (100 * (double) numPrimes / n) + "% are primes)");
    }
}