/** Reads data points (geographical coordinates) from a file, 
 *  and draws them. */
// Uses classes IN, StdDraw
public class PlotMap {
   public static void main(String[] args) {
      // Sets the canvass physical dimensions to “landscape”
      StdDraw.setCanvasSize(1000,800);

      // Scales the canvass logical dimensions according
      // to the min and max values in the data
      In in = new In(args[0]);  // in: represents the given file
      double xMin = in.readDouble(); 
      double yMin = in.readDouble();  
      double xMax = in.readDouble();   
      double yMax = in.readDouble(); 
      StdDraw.setXscale(xMin, xMax);       
      StdDraw.setYscale(yMin, yMax);

      // Draws the data points
      while (!in.isEmpty()) {
          StdDraw.point(in.readDouble(),
                        in.readDouble());
      }
   }
} 