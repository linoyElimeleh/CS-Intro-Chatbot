/** Represents a node. 
 *  A node has a char value,
 *  and a pointer to another node. */
public class Node {

   char value;  // data
   Node next;   // pointer

   /** Constructs a node with the given value.
    *  The new node will point to the given
    *  next node. */
   public Node(char value, Node next) {
      this.value = value;
      this.next = next;
   }
	    
   /** Constructs a node with the given value.
    *  The new node will point to null. */
   public Node(char value) {
      this(value, null);
   }

   /** Textual representation of this node. */
   public String toString() {
      return "" + value;
   }
}