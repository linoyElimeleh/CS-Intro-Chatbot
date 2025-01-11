/******************************************************************************
 *  Compilation:  javac BouncingBall.java
 *  Execution:    java BouncingBall
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2D bouncing ball in a (-1, -1) by (1, 1) box.
 ******************************************************************************/

public class BouncingBall {
    public static void main(String[] args) {

        // StdDraw.setCanvasSize(700,700);

        // sets the canvas to be a -1 by -1 square, 
        // and enables offscreen drawing.
        StdDraw.setXscale(-1.0, 1.0);
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering();

        // sets the ball's initial position, velocity, and radius.
        double x = 0.480, y = 0.860; 
        double vx = 0.015, vy = 0.023;   
        double radius = 0.05;    

        // sets the window title
        StdDraw.setTitle("Bouncing Ball Demo");

        // main animation loop
        while (true)  {

            // bounces off a wall according to law of elastic collision
            if (Math.abs(x + vx) > 1.0 - radius) vx = -vx;
            if (Math.abs(y + vy) > 1.0 - radius) vy = -vy;

            // updates position
            x = x + vx;
            y = y + vy;

            // clears the canvas
            StdDraw.clear(StdDraw.LIGHT_GRAY);

            // draws the ball
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(x, y, radius);

            // copies offscreen buffer to onscreen, and pauses briefly
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
