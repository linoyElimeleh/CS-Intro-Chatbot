// Demonstrates that strings are immutable, and arrays are mutable.
public class Demo1 {
   public static void main(String args[]) {

      String s = "foo";
      char[] a = {'f', 'o', 'o'};

      System.out.println(s);
      bar(s);
      System.out.println(s);

      println(a);
      bar(a);
      println(a);

   }

   public static void bar(String str) {
      str = "buz";
   }

   public static void bar(char[] arr) {
      arr[0] = 'b'; arr[1] = 'u'; arr[2] = 'z';
   }

   // Prints the given array, and a newLine.
   public static void println(char[] arr) {
      for (int i = 0; i < arr.length; i++) {
         System.out.print(arr[i]);
      }
      System.out.println();
   }
}