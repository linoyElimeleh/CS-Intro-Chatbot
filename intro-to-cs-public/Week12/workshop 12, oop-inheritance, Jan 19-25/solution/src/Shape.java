// Base class
public abstract class Shape {
    private String color;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Getters
    public String getColor() {
        return color;
    }

    // Abstract methods to be implemented by subclasses
    public abstract double area();
    public abstract double perimeter();
}