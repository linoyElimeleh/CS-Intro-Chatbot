/** A generic list of objects of any type. */
public class List<T> {

    private Node<T> first; // Pointer to the first list element
    private int size;      // Number of elements

    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
        return size;
    }

    /** Adds the given data (an object) to the end of this list. */
    public void add(T data) {
        // Creates a new node, containing the given data
        Node<T> newNode = new Node<T>(data);
        // If the list is empty, the new node becomes the first node
        if (first == null) {
            first = newNode;
        } else {
            // Iterates to the end of this list
            Node<T> current = first;
            while (current.next != null) {
                current = current.next;
            }
            // Points the last element to the new node
            current.next = newNode;
        }
        size++;
    }

    /** Returns a string representation of this list, 
    *  in the form of (element element , ..., element) */
    public String toString() {
        String str = "(";
        Node<T> current = first;
        while (current != null) {
            str += current.data + " ";
            current = current.next;
        }
        return str.substring(0, str.length() - 1) + ")";
    }
}