/** Represents a point in a plain. A mix of math and drawing methods. */
public class Point {
   // The coordinates of this point
   private double x;
   private double y;

   /** Constructs a point */
   public Point(double x, double y) {
      this.x = x;
      this.y = y;
   }

   /** Returns the addition of this and the other point, as a Point object. */
   public Point add(Point other) {
      return new Point((x + other.x),(y + other.y));
   }

   /** Returns the distance between this and the other point. */
   public double distanceTo(Point other) {
      double dx = this.x - other.x;
      double dy = y - other.y;       // Better style
      return Math.sqrt(dx * dx + dy * dy);
   }

   /** Returns a textual representation of this point. */
   public String toString() {
      return ("(" + x + "," + y + ")");
   }

   /** Draws this point. */
   public void draw() {
      StdDraw.filledCircle(x, y, 0.01);
   }

   /** Draws a line between this and the other point. */
   public void drawLineTo(Point other) {
      StdDraw.line(x, y, other.x, other.y);
   }
}

