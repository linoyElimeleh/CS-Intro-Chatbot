// package lists;
import java.util.NoSuchElementException;

public class ListIterator {
    private Node current;

    public ListIterator(Node first) {
        this.current = first;
    }

    /** Returns true if the iteration has more elements. */
    public boolean hasNext() {
        return current != null;
    }

    /** Returns the next element in the iteration. */
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        int value = current.value;
        current = current.next; // Move to the next element
        return value;
    }
}
