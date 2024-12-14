public class MutateDemo {
   public static void main(String args[]) {
      char   a1 = 'm';
      char[] a2 = {'m', '&', 'm'};
      String a3 = "m&m"; 
      
      // In each of the following lines we print a variable, 
      // call a function to mutate the variable, and print it again
      // following the call.
      System.out.println(a1);  mutate1(a1);  System.out.println(a1);
      println(a2);             mutate2(a2);  println(a2);
      System.out.println(a3);  mutate3(a3);  System.out.println(a3);
   }

   public static void mutate1(char x) {
      x = 'b';
      System.out.println(x);
   }
   
   public static void mutate2(char[] x) {
      x[0] = 'b'; x[2] = 'b';
      println(x);
   }

   public static void mutate3(String x) {
      x = "b&b";
      System.out.println(x);
   }

   // Prints the given char array​
   public static void println(char[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i] + " ");
      }
      System.out.println();
   }
}