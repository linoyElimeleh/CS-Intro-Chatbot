/** Draws the Koch curve. */
public class KochCurve {

	public static void main(String[] args) {
		kochCurve(Integer.parseInt(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		Double.parseDouble(args[3]), Double.parseDouble(args[4]));
	}
	
	public static void kochCurve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n > 0){
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
		    kochCurve(n - 1, newX1, newY1, x, y);
		    kochCurve(n - 1, x ,y ,newX2, newY2);
		    kochCurve(n - 1, x1, y1, newX1, newY1);
		    kochCurve(n - 1,newX2, newY2, x2, y2);
		}
	}
}
