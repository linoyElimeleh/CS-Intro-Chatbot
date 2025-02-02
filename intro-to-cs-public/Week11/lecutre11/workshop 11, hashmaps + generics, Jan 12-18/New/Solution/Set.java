/** A generic Set class implementation using an ArrayList. */
import java.util.ArrayList;

public class Set<T> {
    private ArrayList<T> elements;

    /** Constructs an empty set. */
    public Set() {
        elements = new ArrayList<>();
    }

    /** Adds an element to the set if it's not already present. */
    public void add(T value) {
        if (!contains(value)) {
            elements.add(value);
        }
    }

    /** Removes an element from the set. */
    public void remove(T value) {
        elements.remove(value);
    }

    /** Checks if the set contains a specific element. */
    public boolean contains(T value) {
        return elements.contains(value);
    }

    /** Returns the size of the set. */
    public int size() {
        return elements.size();
    }

    /** Returns a string representation of the set. */
    @Override
    public String toString() {
        return elements.toString();
    }

    /** Example usage of the Set class. */
    public static void main(String[] args) {
        Set<String> set = new Set<>();

        // Add elements to the set
        set.add("Apple");
        set.add("Banana");
        set.add("Apple"); // Duplicate, won't be added

        // Print the set
        System.out.println("Set: " + set); // Expected: [Apple, Banana]

        // Check if an element exists
        System.out.println("Contains 'Apple': " + set.contains("Apple")); // Expected: true
        System.out.println("Contains 'Cherry': " + set.contains("Cherry")); // Expected: false

        // Remove an element
        set.remove("Apple");
        System.out.println("Set after removal: " + set); // Expected: [Banana]

        // Check the size of the set
        System.out.println("Set size: " + set.size()); // Expected: 1
    }
}
