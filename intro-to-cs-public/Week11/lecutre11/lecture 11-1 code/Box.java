/** Represents a generic box that holds an object of type T */
 public class Box<T> {
	
    private T x;

    Box(T x) {
        this.x = x;      
    }
	
    public T get() {
        return x;
    }

    public String toString() {
        return "[" + x.toString() + "]";
    }
}