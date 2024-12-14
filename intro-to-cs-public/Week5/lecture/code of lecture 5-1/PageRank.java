/** Reads all the values in a file, skipping white space, and prints their *   frequency. Precondition: The first value in the file, say N, indicates *   that each value in the file is a non-negative int < N.  */
public class ReadFileDemo {
   public static void main(String[] args) {
      // Creates a new input stream and sets in to refer to it
      In in = new In("demo.dat");
      // Reads the upper-limit of the values
      int N = in.readInt();
      // Creates a frequency array        
      int[] count = new int[N];
      // Reads and counts the values
      while (!in.isEmpty()); {
          int x = in.readInt();
          count[x]++;
      }
      // Prints the frequency array
      for (int i = 0; i < N; i++)
          System.out.println(i + ": " + count[i]); 
    } 
}