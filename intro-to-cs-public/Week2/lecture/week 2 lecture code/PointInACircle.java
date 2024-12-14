
// Generates a point (x,y) inside a circle of radius 1 centered at (0,0).
public class PointInACircle {
	public static void main(String[] args) {		
		double x, y;
		do {
			// Generates random x and y, each in [-1,1(
			x = 2.0 * Math.random() - 1.0;
			y = 2.0 * Math.random() - 1.0;
		 } while (x * x + y * y > 1.0);
		 // (x,y) is inside the circle		                                  
		System.out.println("the point generated: (" + x + "," + y + ")");
	}
}
