package lists_solution;

/** A linked list of integers. */
public class List {

    private Node first; // Points to this list
    private int size; // Number of elements

    /** Constructs an empty list. */
    public List() {
        // Starts with a dummy node
        first = new Node(0);
        size = 0;
    }

    /** Returns the number of elements in this list. */
    public int getSize() {
        return size;
    }

    /** Adds the given value to the beginning of this list. */
    public void addFirst(int val) {
        Node newNode = new Node(val);
        // Inserts the new node between
        // the dummy and the first node.
        newNode.next = first.next;
        first.next = newNode;
        size++;
    }

    /** Textual representation of this list */
    public String toString() {
        if (size == 0)
            return "()";
        StringBuilder str = new StringBuilder("(");
        // Creates a pointer to the first element
        Node current = first.next; // skips the dummy
        while (current != null) {
            str.append(current.value + " ");
            current = current.next;
        }
        // Replaces the last " " with ")"
        str.deleteCharAt(str.length() - 1);
        str.append(")");
        return str.toString();
    }

    /**
     * Returns the index of the first occurrence
     * of the given value, or -1 if not in list.
     */
    public int indexOf(int val) {
        Node current = first.next; // skips the dummy
        int i = 0;
        while (current != null) {
            if (current.value == val) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    /**
     * If the given value is in the list, removes
     * it and returns true. Otherwise, returns false.
     */
    public boolean remove(int val) {
        if (indexOf(val) == -1)
            return false;
        // Creates two lock-step pointers
        Node prev = first;
        Node current = first.next;
        while (current.value != val) {
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
        current = null; // for object recycling
        size--;
        return true;
    }

    /** Returns true if this list contains the specified value. */
    public boolean contains(int val) {
        return indexOf(val) > -1;
    }

    /** Returns the index of the last occurrence of the specified value. */
    public int lastIndexOf(int val) {
        Node current = first.next; // skips the dummy
        int i = 0;
        int last = -1;
        while (current != null) {
            if (current.value == val) {
                last = i;
            }
            current = current.next;
            i++;
        }
        return last;
    }

    /** Returns the value at the specified position in this list. */
    public int get(int index) {
        Node current = first.next; // skips the dummy
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.value;
    }

    /** Sets the value at the given index to the given value */
    public void set(int index, int val) {
        Node current = first.next; // skips the dummy
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        current.value = val;
    }

    /**
     * Disposes this list. Goes through the list and
     * sets the next field of each node to null.
     */
    public void dispose() {
        // Creates two lock-step pointers
        Node prev = first;
        Node current = first.next;
        while (current != null) {
            prev.next = null;
            prev = current;
            current = current.next;
        }
        size = 0;
    }

    /** Returns an array containing all of the elements in this list. */
    public int[] toArray() {
        int[] arr = new int[size];
        Node current = first.next; // skips the dummy
        int i = 0;
        while (current != null) {
            arr[i++] = current.value;
            current = current.next;
        }
        return arr;
    }

    /**
     * Returns an iterator over the elements in this list,
     * starting at the given index.
     */
    public ListIterator listIterator(int index) {
        // If the list is empty, there is nothing to iterate
        if (size == 0)
            return null;
        // Gets the element in position index of this list
        Node current = first.next; // skips the dummy
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        // Returns an iterator that starts in that element
        return new ListIterator(current);
    }
}