/** Completed generic Pair class implementation. */
public class Pair<K, V> {
    private K key;
    private V value;

    /** Constructs a new Pair with the given key and value. */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /** Returns the key. */
    public K getKey() {
        return key;
    }

    /** Returns the value. */
    public V getValue() {
        return value;
    }

    /** Sets a new key. */
    public void setKey(K key) {
        this.key = key;
    }

    /** Sets a new value. */
    public void setValue(V value) {
        this.value = value;
    }

    /** Returns a string representation of the Pair. */
    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    /** Example usage of the Pair class for different use cases. */
    public static void main(String[] args) {
        // Coordinate Pair Example
        Pair<Double, Double> coordinatePair = new Pair<>(3.5, 7.2);
        System.out.println("Coordinate Pair: " + coordinatePair);

        // Student-Grade Pair Example
        Pair<String, Integer> studentGradePair = new Pair<>("Alice", 95);
        System.out.println("Student-Grade Pair: " + studentGradePair);
    }
}
