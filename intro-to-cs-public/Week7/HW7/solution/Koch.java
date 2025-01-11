/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {        	
		// Test 1: Tests the curve function:
		// Draws a Koch curve of depth 7 from (0.0,0.0) to (1.0,1.0), on the standard canvass.
		// curve(5, 0.0, 0.0, 1.0, 1.0);        

		// Test 2: Tests the snowflake function:
		// Draws a Koch snowflake of n edges on the standard canvass.
		// n is a command-line argument.
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n > 0) {
			StdDraw.setPenColor(StdDraw.WHITE);
			double newX1 = (2 * x1 + x2) / 3;
			double newY1 = (2 * y1 + y2) / 3;
			double newX2 = (2 * x2 + x1) / 3;
			double newY2 = (2 * y2 + y1) / 3;
			StdDraw.line(newX1, newY1, newX2, newY2);
			StdDraw.setPenColor(StdDraw.BLACK);
			double x = (Math.sqrt(3) / 2.0) * (1.0 / 3.0) * (y1 - y2) + (x1 + x2) / 2;
			double y = (Math.sqrt(3) / 2.0) * (1.0 / 3.0) * (x2 - x1) + (y1 + y2) / 2;
		    StdDraw.line(newX1, newY1, x, y);
		    StdDraw.line(newX2, newY2, x, y);
		    curve(n - 1, newX1, newY1, x, y);
		    curve(n - 1, x ,y ,newX2, newY2);
		    curve(n - 1, x1, y1, newX1, newY1);
		    curve(n - 1,newX2, newY2, x2, y2);
		}
	}

    /** Draws a Koch snowflake of depth n. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.2);
		StdDraw.setXscale(0, 1.2);
		// Draws a Koch snowflake of depth n
		if (n >= 0) {
			double h = Math.sqrt(3) / 2;
			curve(n, 0.0, h, 1.0, h);
			curve(n, 0.5 , 0.0, 0.0, h);
			curve(n, 1.0, h, 0.5, 0.0);
		}
	}
}
