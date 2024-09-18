/**
 * Execution: java PageRank int (one command-line argument)
 *
 * Computes the PageRanks of a set of given pages. The identifiers of the pages, and the links
 * data, are stored in a file names web.dat. Reads the pages and the links data from the
 * file, and then computes and prints the PageRank of each page. The computation is based on
 * N random walks in the pages, where N is a command-line argument. 
 */

public class PageRank {
    public static void main(String[] args) {
        // Creates an In object for representing the input (file)
        In in = new In("web.dat");
        int N = in.readInt();           // number of pages
        int[][] nLink = new int[N][N];  // nLink[i][j]: number of links from page i to page j
        int[] nLinks = new int[N];      // nLinks[i]: total number of outgoing links from page i

        // Reads the links data and computes the link counts 
        while (!in.isEmpty()) {
            int row = in.readInt(); 
            int col = in.readInt();     
            nLink[row][col]++;
            nLinks[row]++;  
        } 
     
        // Constructs the transition matrix
        double[][] transition = new double[N][N];
        for (int i = 0; i < N; i++)  {
            for (int j = 0; j < N; j++) {
            	transition[i][j] = .10 / N + .90 * ( (double) nLink[i][j] / nLinks[i]); 
            } 
        } 
        
        System.out.println("Transition matrix:"); println(transition); System.out.println();
        
        // Computes the CDF's of the PDF's represented by the transition matrix
        double[][] CDF = new double[N][N];     
        for (int i = 0; i < N; i++)  {
        	CDF[i] = MyRandom.CDF(transition[i]);
        }

        System.out.println("CDF matrix:"); println(CDF); System.out.println();
        
        // Simulates the behavior of a surfer who makes T random moves.
        // In each move, a random page is selected from the current page. 
        // The random selection is made using the CDF of the current page.
        int T = Integer.parseInt(args[0]);     // number of moves
        int page = 0;                          // Starts at page 0
        int[] count = new int[N];
        // Makes T moves
        for (int t = 0; t < T; t++) {
            // Selects randomly which page to go to
            page = MyRandom.rnd(CDF[page]);
            count[page]++;
        }
        
        System.out.println("Page ranks:"); 
        for (int i = 0; i < N; i++) {
           System.out.printf("%7.3f", (double) count[i] / T);
        }
        System.out.println();       
    }
    
    // Prints the given matrix.
    public static void println(double[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N; i++)  {
            for (int j = 0; j < N; j++) {
                System.out.printf("%7.2f ", matrix[i][j]); 
            } 
            System.out.println(); 
        } 
    } 
} 