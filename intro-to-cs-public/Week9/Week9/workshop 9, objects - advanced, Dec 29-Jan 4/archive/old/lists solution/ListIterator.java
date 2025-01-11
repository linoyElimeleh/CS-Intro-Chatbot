package lists;

/** Represents a list iterator. */
public class ListIterator {

    // Current position in the list (cursor)
    Node current;

    /** Constructs a list iterator, starting at the given node. */
    public ListIterator(Node node) {
        // Sets the cursor of this iterator to the given node
        current = node;
    }

    /** Checks if this iterator has more nodes to process */
    public boolean hasNext() {
        return (current != null);
    }
  
    /** Returns the value of the current element in this iteration,
     *  and advances the cursor to the next element.
     *  Should be called only if hasNext is true.
     *  NOTE: The name of this method is a bit confusing.
     *        We use it anyway, following Java conventions. */
    public int next() {
        int val = current.value;
        current = current.next;
        return val;
    }
}