// Demonstrates that even though strings are immutable,
// A string variable that refers to one string can be
// made to refer to another string.
public class Demo2 {
   public static void main(String args[]) {

      String s = "foo";

      System.out.println(s);
      s = bar(s);
      System.out.println(s);
   }

   public static String bar(String str) {
      str = "buz";
      return str;
   }

}