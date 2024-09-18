package lists;

/** Represents a node in a generic list. 
 *  A node holds an object of type T, and a pointer to another node. */
public class Node<T> {

   T value;    // data
   Node next;  // pointer

   /** Constructs a node with the given value.
    *  The new node will point to the given next node. */
   public Node(T value, Node next) {
      this.value = value;
      this.next = next;
   }
	    
   /** Constructs a node with the given value.
    *  The new node will point to null. */
   public Node(T value) {
      this(value, null);
   }

   /** Textual representation of this node. */
   public String toString() {
      return "" + value;
   }
}