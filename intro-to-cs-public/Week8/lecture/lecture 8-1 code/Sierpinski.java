// Draws a Sierpinski triangle.
public class Sierpinski {
   public static void main(String[] args) {
	   
      // Gets the number of points to draw
      int N = Integer.parseInt(args[0]);
      StdDraw.setCanvasSize(800,800);

      // Sets the coordinates of the triangle's vertices
      double[] xVertex = { 0.000, 1.000, 0.500 };
      double[] yVertex = { 0.000, 0.000, 0.866 };

      double x = 0.0, y = 0.0;
      for (int i = 0; i < N; i++) {
         // Chooses a random index from (0,1,2)
         int r = (int) (Math.random() * 3);
         // Draws the midpoint
         x = (x + xVertex[r]) / 2.0;
         y = (y + yVertex[r]) / 2.0;
         StdDraw.point(x, y);
      }
   }
}
