// package lists;
import java.util.Iterator;
import java.util.NoSuchElementException;

// List iterator
public class ListIterator implements Iterator<Integer> {
    private Node current;

    public ListIterator(Node first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        int value = current.value;
        current = current.next;
        return value;
    }
}