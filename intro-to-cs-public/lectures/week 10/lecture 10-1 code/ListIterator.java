import java.util.NoSuchElementException;

/** Implements an iteration over the elements of a List. */
public class ListIterator {

    private Node current; // current location of the iteration

    /** Returns an iterator, starting at the given node. */
    public ListIterator(Node first) {
        this.current = first;
    }

    /** Checks if this iteration has more elements. */
    public boolean hasNext() {
        return current != null;
    }

    /** Returns the int value of the next element in this iteration,
     *  and advances the iteration. 
     *  Should be called only if hasNext() is true. 
     *  If hasNext() is not true, throws an exception. */
    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        int value = current.value;
        // Advances this iteration to the next element
        current = current.next; 
        return value;
    }
}
