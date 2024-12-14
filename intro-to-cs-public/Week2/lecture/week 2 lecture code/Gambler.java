public class Gambler {
   public static void main(String[] args) {
      int start  = Integer.parseInt(args[0]);
      int goal   = Integer.parseInt(args[1]);
      int T      = Integer.parseInt(args[2]);
      int nFlips = 0;
      int nWins = 0;
      // repeats the experiment T times
      for (int t = 0; t < T; t++) {
    	 // runs one experiment
    	 int cash = start;
	 while ((cash > 0) && (cash < goal)) {
    	       // flips coin and update cash situation
    	       if (Math.random() < 0.5) cash++;
    	       else                     cash--;
    	       nFlips++;
    	 }
    	 if (cash == goal) {
    	     nWins++;
	 }
       } // loops back to start a new game

       System.out.println("percentage of winning games: " + 100 * nWins / T + "%");
       System.out.println("average number of flips in a game: " + nFlips / T);   }
}