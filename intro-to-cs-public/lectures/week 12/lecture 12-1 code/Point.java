/** Represents a point. */
public class Point {

    // The coordinates of this point
    protected int x, y;

    /** Constructs a point. */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Textual representation */
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Point other = (Point) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

    // More Point methods
} 
