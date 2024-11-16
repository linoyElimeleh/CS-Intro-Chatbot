// A library of mathematical functions
public class MyMath {
   public static void main(String args[]) {
      // Tests the square root function with various precisions:
      System.out.println(Math.sqrt(2));   // benchmark value
      System.out.println(sqrt(2, 0.5)); 
      System.out.println(sqrt(2, 0.1));    
      System.out.println(sqrt(2, 0.001));
      System.out.println(sqrt(2, 1e-7));  // 0.00000001

      // Computes the distance between (2,1) and (5,4)
      double d = hypot(2,1,5,4);  
      System.out.println(d);  
   }

   /** Computes the Euclidean distance between the two given points */
   public static double hypot(double x1, double y1, double x2, double y2) {
      double dx = x2 - x1;
      double dy = y2 - y1;
      return sqrt(dx*dx + dy*dy); 
   }

   /** Square root of x with precision epsilon */
   public static double sqrt(double x, double epsilon) {
      if (x < 0) return Double.NaN;
      double g = x;
      while (Math.abs(g * g - x) > epsilon) {
         g = g - (g * g - x) / (2 * g);
      }
      return g;
   }
    
   /** Square root of x with default precision 0.001 */
   public static double sqrt(double x) {
      return sqrt(x, 0.001);
   }
}