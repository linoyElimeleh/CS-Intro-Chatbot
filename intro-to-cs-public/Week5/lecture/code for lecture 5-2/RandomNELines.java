public class RandomNELines {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]); // Number of lines
        int delay = Integer.parseInt(args[1]); // Delay in milliseconds

        // Set canvas size and scale
        StdDraw.setCanvasSize(500, 500);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);

        // Draw n random lines going from (0,0) to a random point within the northeast quadrant of the unit square
        for (int i = 0; i < n; i++) {
            // Generate a random endpoint for x and y within the range [0, 1]
            double endX = Math.random();
            double endY = Math.random();

            // Draw the line
            StdDraw.line(0, 0, endX, endY);

            // Pause for the specified delay
            StdDraw.pause(delay);
        }
    }
}
