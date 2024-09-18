public class TreeNatural {

    public static void drawBranch(double x0, double y0, double length, double angle, int depth) {
        if (depth == 0) return;

        double angleNoise = Math.random() * 20 - 10; // Random noise for angle, within +/- 10 degrees
        double lengthNoise = Math.random() * 0.2 + 0.8; // Random noise for length, between 0.8 and 1.0 times the length

        double x1 = x0 + length * Math.cos(Math.toRadians(angle + angleNoise));
        double y1 = y0 + length * Math.sin(Math.toRadians(angle + angleNoise));

        StdDraw.line(x0, y0, x1, y1);

        drawBranch(x1, y1, length * 0.75 * lengthNoise, angle + 30, depth - 1); // Right branch
        drawBranch(x1, y1, length * 0.75 * lengthNoise, angle - 30, depth - 1); // Left branch
    }

    public static void main(String[] args) {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setScale(-1.0, 1.0);

        double trunkLength = 0.3; // Length of the trunk
        double trunkAngle = 90;   // Angle of the trunk (90 degrees for vertical)
        int depth = 10;           // Depth of recursion

        // Draw the trunk
        drawBranch(0.0, 0.0, trunkLength, trunkAngle, depth);
    }
}
