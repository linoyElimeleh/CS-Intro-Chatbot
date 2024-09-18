import java.awt.Color;

/** Represents a colored point. */
public class ColoredPoint extends Point {

    // The color of this point.
    private Color color;

    /** Constructs a colored point. */   
    public ColoredPoint(int x, int y, Color color) {
        super(x,y); // calls the super constructor
        this.color = color;
    }

    /** Constructs a point, colored black */   
    public ColoredPoint(int x, int y) {
        this(x, y, Color.black);
    }
 
    /** Textual representation of this point. */
    public String toString() {
        return super.toString() + " " + color;
    }
}