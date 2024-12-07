/** Draws a line */
public class DrawLineDemo {
   public static void main(String[] args) {
       double x = Double.parseDouble(args[0]);
       double y = Double.parseDouble(args[1]);
       // draws a line between (0, 0) and (x, y)
       System.out.println(x + " " + y);
       StdDraw.line(0.0, 0.0, x, y);
   }
} 
