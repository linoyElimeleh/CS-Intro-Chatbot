/** A library of string functions. */ 
public class MyString {
   public static void main(String args[]) {
      System.out.println(upCase(args[0]));  
   }

   /** Capitalizes the first letter in every word in the string. */
   public static String upCase(String str) {
      String ans = "" + (char) (str.charAt(0) - 32);
      int i = 1;
      while (i < str.length()) {
         char ch = str.charAt(i);
         if (ch == ' ') {
            ans = ans + ch + (char) (str.charAt(i + 1) - 32);
            i++;
         } else {
            ans = ans + ch;
         }
         i++;
      }
      return ans;
   }
}