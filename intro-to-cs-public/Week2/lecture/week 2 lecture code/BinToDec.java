public class BinToDec {
   public static void main (String[] args) {
      String s = args[0];
      int N = s.length();
      int val = 0;
      int power;
      for (int i = 0; i < N; i++) {
         if (s.charAt(i) == '1') {
            power = N - i - 1;
            val = val + (int) Math.pow(2, power);
         }
      }
      System.out.println(val);
   }
}