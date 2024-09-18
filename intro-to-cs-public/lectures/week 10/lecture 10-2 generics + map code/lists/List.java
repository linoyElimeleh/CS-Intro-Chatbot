package lists;

/** A generic list of objects of type T. */
public class List<T> {

    private Node<T> first; // Points to this list
    private int size;      // Number of elements
	
    /** Constructs an empty list. */
    public List() {
        // Starts with a dummy node
        first = new Node<T>(null);
        size = 0;
    }
    
    /** Returns the number of elements in this list. */
    public int getSize() {
 	   return size;
    }

    /** Adds the given value to the beginning of this list. */
    public void addFirst(T val) {
       Node<T> newNode = new Node<T>(val);
       // Inserts the new node between
       // the dummy and the first node.
       newNode.next = first.next;
       first.next = newNode;
       size++;
    }
    
    /** Textual representation of this list */
    public String toString() {
       if (size == 0) return "()";
       StringBuilder str = new StringBuilder("(");
       // Creates a pointer to the first element
       Node current = first.next; // skips the dummy  	    
       while (current != null) {
            str.append(current.value + " ");
            current = current.next; 
       }
       // Replaces the last " " with ")"
       str.deleteCharAt(str.length()-1);
       str.append(")");
       return str.toString();
    }
}