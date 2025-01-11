/** A linked list of characters. */
public class List {

    private Node first; // Points to the first element of this list

    private Node last;  // Points to the last element of this list

    private int size;   // Number of elements in this list
	
    /** Constructs an empty list. */
    public List() {
        // Starts with a dummy node
        first = new Node('a');
        last = first;
        size = 0;
    }
    
    /** Returns the number of elements in this list. */
    public int getSize() {
 	      return size;
    }

    /** Adds the given value to the beginning of this list. */
    public void addFirst(char val) {
        Node newNode = new Node(val);
        // Inserts the new node between
        // the dummy and the first node.
        newNode.next = first.next;
        first.next = newNode;
        size++;
    }

    
    // LETS TALK ABOUT THIS METHOD
    /** Adds the given value to the end of this list. */
    public void addLast(char val) {
        Node newNode = new Node(val);
        Node current = first.next; // skips the dummy
        if(current == null) {
        	this.first.next = newNode;
        	this.size++;
        	return;
        }
        
        while (current.next != null)  // skip to the last Node in the list
        	current = current.next;
        current.next = newNode;
        this.size++;
    }
    
    /*
     * Implementation with last field
    public void addLast(char val) {
		Node newNode = new Node(val);
		last.next = node;
		last = node;		
		this.size++;
	}
	*/
    
    
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
    
    /** Returns the index of the first occurrence
     *  of the given value, or -1 if not in list. */
    public int indexOf(char val) {
	      Node current = first.next; // skips the dummy 
	      int i = 0;
	      boolean found = false;
        // while ((current.value != val) || (current != null)) {
        while (current != null) {
    	      if (current.value == val) {
    		        found = true;
    		        break;
    	      }
            current = current.next;
            i++;
        }
        if (found) return i;
        else return -1;
    }

    /** Returns the value at the specified position in this list. */
    public char get(int index) {
    	if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("There is no element " + index + 
                                                " in this list.");
        }
        Node current = first.next; // skips the dummy 
        int i = 0;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.value;
    }

    /** Returns an array containing all of the elements in this list. */
    public char[] toArray() {
	    char[] arr = new char[size];
	    Node current = first.next; // skips the dummy 
	    int i = 0;
        while (current != null) {
    	    arr[i++]  = current.value;
    	    current = current.next;
        }
        return arr;
    }

    /** Returns an iterator over the elements in this list,
     *  starting at the given index. */
    public ListIterator listIterator(int index) {
	    // If the list is empty, there is nothing to iterate   
	    if (size == 0) return null;
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