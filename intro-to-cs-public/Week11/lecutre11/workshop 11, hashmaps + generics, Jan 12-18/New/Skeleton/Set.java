/** Skeleton for a generic Set class using an ArrayList. */
import java.util.ArrayList;

public class Set<T> {
    private ArrayList<T> elements;

    /** Constructs an empty set. */
    public Set() {
        // TODO: Initialize the internal list
    }

    /** Adds an element to the set if it's not already present. */
    public void add(T value) {
        // TODO: Implement this
    }

    /** Removes an element from the set. */
    public void remove(T value) {
        // TODO: Implement this
    }

    /** Checks if the set contains a specific element. */
    public boolean contains(T value) {
        // TODO: Implement this
        return false; // Placeholder
    }

    /** Returns the size of the set. */
    public int size() {
        // TODO: Implement this
        return 0; // Placeholder
    }

    /** Returns a string representation of the set. */
    @Override
    public String toString() {
        // TODO: Implement this
        return null; // Placeholder
    }

    /** Example usage of the Set class. */
    public static void main(String[] args) {
        Set<String> set = new Set<>();

        // Example TODOs for testing:
        // set.add("Apple");
        // set.add("Banana");
        // System.out.println("Set: " + set);
    }
}
