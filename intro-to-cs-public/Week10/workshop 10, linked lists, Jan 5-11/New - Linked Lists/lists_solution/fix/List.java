package lists_solution;

/** A linked list of integers. */
public class List {

    private Node first; // Points to first actual node 
    private int size; // Number of elements

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
        Node newNode = new Node(val);
        newNode.next = first;
        first = newNode;
        size++;
    }

    /** Textual representation of this list */
    public String toString() {
        if (size == 0)
            return "()";
        StringBuilder str = new StringBuilder("(");
        Node current = first; 
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
        Node current = first; 
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
        if (size == 0) return false;

        // Special case: removing first element
        if (first.value == val) {
            first = first.next;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while (current != null && current.value != val) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next;
            size--;
            return true;
        }
        return false;
    }

    /** Returns true if this list contains the specified value. */
    public boolean contains(int val) {
        return indexOf(val) > -1;
    }

    /** Returns the index of the last occurrence of the specified value. */
    public int lastIndexOf(int val) {
        Node current = first; 
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
        Node current = first; 
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.value;
    }

    /** Sets the value at the given index to the given value */
    public void set(int index, int val) {
        Node current = first; 
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
        if (size == 0) return;
        
        Node prev = first;
        Node current = first.next;
        while (current != null) {
            prev.next = null;
            prev = current;
            current = current.next;
        }
        first = null;
        size = 0;
    }

    /** Returns an array containing all of the elements in this list. */
    public int[] toArray() {
        int[] arr = new int[size];
        Node current = first; 
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
        if (size == 0)
            return null;
            
        Node current = first; 
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return new ListIterator(current);
    }
}