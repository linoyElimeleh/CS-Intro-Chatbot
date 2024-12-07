/** Prints some random numbers */
public class RandomNumbers {
    public static void main(String[] args) {   
        int N = Integer.parseInt(args[0]);
        // Prints N random numbers in [0,1)
        for (int i = 0; i < N; i++) {
            // StdOut.println(Math.random());
            System.out.println(Math.random());
        }
    }
}