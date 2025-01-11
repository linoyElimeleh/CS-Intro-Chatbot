public class PointDemo {	
	public static void main(String args[]) {
		
		// All the points that we'll create and manipulate in this demo
		// are within the 2D space [0,1] x [0,1].
		Point p1 = new Point(0.1,0.1);
	    Point p2 = new Point(0.8,0.8);
	    System.out.println("p1 = " + p1);
	    System.out.println("p2 = " + p2);
	    System.out.println("Distance between p1 and p2 is: " + p1.distanceTo(p2));
	    System.out.println("Distance between p2 and p1 is: " + p2.distanceTo(p1));
	    
	    p1.draw();
	    p2.draw();
	    p1.drawLineTo(p2);
	    
	    // Creates and draws N random points.
	    int N = 100; 
	    Point[] points = new Point[N];
	    for (int i = 0; i < N; i++) {
	        points[i] = new Point(Math.random(), Math.random());
	    }	
	    for (int i = 0; i < N; i++) {
    	    points[i].draw();
        }	
	    
	    Point p3 = new Point(0.1,0.1);
	    Point p4 = new Point(0.2,0.2);
	    System.out.println(p3 + " + " + p4 + " = " + p3.add(p4));
	}
}
