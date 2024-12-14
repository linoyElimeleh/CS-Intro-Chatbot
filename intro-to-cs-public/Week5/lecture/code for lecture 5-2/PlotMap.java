/** Reads data points (geographical coordinates) from a file, 
 *   and draws them. */
// Uses classes In, StdDraw
public class PlotMap {
   public static void main(String[] args) {
     In in = new In(args[0]); // Input file reader
     // Sets the canvass physical dimensions a fixed “landscape” frame
     StdDraw.setCanvasSize(1000,800); // (width,height)
     // Scales the canvass logical dimensions according
         // to the min and max values in the data
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