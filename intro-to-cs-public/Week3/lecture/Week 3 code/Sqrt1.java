// Computes an approximate square root by sequential search
public class Sqrt1 {
   public static void main(String args[]) {
      double x = 16; // We’ll find the (approx.) square root of x
      double epsilon = 0.01, increment = 0.0001;
      double g = 1.0;
      int itrCounter = 0;
      while (Math.abs(g * g - x) >= epsilon) {
         g += increment;
         itrCounter++;
      }
      System.out.println("Square root (approx.) = " + g);
      System.out.println("Number of iterations = " + itrCounter);
   }
}