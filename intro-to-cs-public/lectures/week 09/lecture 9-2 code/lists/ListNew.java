package lists;

/** A linked list of integers. */
public class List {

    private Node first; // Points to the first node in this list, or null if the list is empty.
    private int size;   // Number of elements in this list

    /** Constructs an empty list. */
    public List() {
        first = null;
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
        return size;
    }

    /** Adds the given value to the beginning of this list. */
    public void addFirst(int val) {
        // Creates a new node with the given value
        Node newNode = new Node(val);
        newNode.next = first; // newNode points to the current first
        first = newNode;      // Update first to point to newNode
        size++;
    }

    /** Adds the given value to the end of this list. */
    public void add(int val) {
        // Creates a new node with the given value
        Node newNode = new Node(val);
        // If the list is empty, the new node becomes the first node
        if (first == null) {
            first = newNode;
        } else {
            // Finds the last node and makes it point to the new node
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /** Textual representation of this list */
    public String toString() {
        if (size == 0) return "()";
        String str = "(";
        // Starting from the first node, iterates through the list
        Node current = first;
        while (current != null) {
            str += current.value + " ";
            current = current.next;
        }
        str = str.substring(0, str.length() - 1); // Removes the trailing space
        str += ")";
        return str;
    }

    /** If the given value is in the list, removes it and return true.
     *  Otherwise, returns false.*/
    public boolean remove(int val) {
        // Finds the node that has to be removed,
        // Using two pointers: prev is one step behind current
        Node prev = null;
        Node current = first;
        while (current != null && current.value != val) {
            prev = current;
            current = current.next;
        }
        if (current == null) return false; // Value not found
        // If the found element is the first, remove it and update first
        if (prev == null) {
            first = first.next;
        } 
        // If the found element is not the first, remove it
        else {
            prev.next = current.next;
        }
        size--;
        return true;
    }

    // Update other methods (indexOf, contains, lastIndexOf, get, set, dispose, toArray, listIterator)
    // to operate without assuming the presence of a dummy node, similar to the adjustments made above.
}