//package lists;

import java.util.Iterator;

/** A linked list of integer values. */
public class List implements Iterable<Integer> {

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

    /** Returns a string representation of this list, 
     *  in the form of (element element , ..., element) */
    public String toString() {
        if (size == 0) return "()";
        String str = "(";
        // Starting from the first node, iterates through this list
        Node current = first;
        while (current != null) {
            str += current.value + " ";
            current = current.next;
        }
        //str = str.substring(0, str.length() - 1); // Removes the trailing space
        //str += ")";
        return str.substring(0, str.length() - 1) + ")";
    }

    /** Adds the given value to the beginning of this list. */
    public void addFirst(int val) {
        // Creates a new node with the given value
        Node newNode = new Node(val);
        newNode.next = first; // new node -> first node
        first = newNode;      // first -> new node
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

    /** Inserts the given value in location i of this list. */
    public void add(int i, int val) {
    }

    /** Returns the index of the first location of the given value in this list.
     *  If such value is not found, returns -1. */
    public int indexOf(int val) {
        return -1;
    }

    /** If the given value is in the list, removes it and return true.
     *  Otherwise, returns false.*/
    public boolean removeValue(int val) {
        // Finds the node that has to be removed,
        // Using two pointers: prev is one step behind current
        Node prev = null;
        Node current = first;
        while (current != null && current.value != val) {
            prev = current;
            current = current.next;
        }
        if (current == null) return false; // Value not found
        // Remove the element. If it's the first element, update first
        if (prev == null) { // it's the first element
            first = first.next;
        } 
        else {
            prev.next = current.next;
        }
        size--;
        return true;
    }

    /** Removes the element at index i in this list.
     *  Returns true if the element was removed, otherwise returns false. */
    public boolean remove(int i) {
        if (size == 0 || i >= size) return false;
        // If its the first element, removes it and updates first
        if (i == 0) {
            first = first.next;
            size--;
            return true;
        } 
        // Iterates over i elements, using two pointers:
        // prev points to the element before the current element
        Node prev = null;
        Node current = first;
        int j = 0;
        while (j < i) {
            prev = current;
            current = current.next;
            j++;
        }
        // Element i was reached. Removes the element
        prev.next = current.next;
        size--;
        return true;
    }

    /** Return a ListIterator over the elements in this list */
    @Override
    public Iterator<Integer> iterator() {
        return new ListIterator(first);
    }

    // Update other methods (indexOf, contains, lastIndexOf, get, set, dispose, toArray, listIterator)
    // to operate without assuming the presence of a dummy node, similar to the adjustments made above.
}