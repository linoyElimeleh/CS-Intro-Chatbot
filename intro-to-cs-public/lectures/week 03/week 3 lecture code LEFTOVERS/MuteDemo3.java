// Demonstrates that strings are immutable, and arrays are mutable.
public class MuteDemo3 {
   public static void main(String args[]) {

      char a1 = 'm';
      String a3 = "m&m"; 
      char[] a2 = {'m&m'};

      System.out.println(a1);
      mutate(a1);
      System.out.println(a1);

      println(a2);
      mutate(a2);
      println(a2);

      System.out.println(a3);
      mutate(a3);
      System.out.println(a3);
   }

   public static void mutate(char x) {
      x = "z";
   }

   public static void mutate(String x) {
      x = "b&b";
   }

   public static void mutate(char[] x) {
      x[0] = 'b'; x[2] = 'b';
   }

   // Prints the given array, and a newLine.
   public static void println(char[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]);
      }
      System.out.println();
   }
}