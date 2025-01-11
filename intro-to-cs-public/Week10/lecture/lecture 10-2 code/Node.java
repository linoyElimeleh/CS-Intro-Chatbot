/** Represents a node in a linked list.
 *  The node contains an int value, and a pointer to another node. */
public class Node {

   // Notice that the fields of this class are neither private, nor public.
   // We will have more to say about it later in the course.
   // If a field is declared this way, other classes in the same
   // folder can access the field, obviating the need for get/set methods.
   int value;  // data
   Node next;  // pointer

   /** Constructs a node with the given value.
    *  The new node will point to the next node. */
   public Node(int value, Node next) {
      this.value = value;
      this.next = next;
   }
	    
   /** Constructs a node with the given value.
    *  The new node will point to null. */
   public Node(int value) {
      this(value, null);
   }

   /** Textual representation of this node. */
   public String toString() {
      return "" + value;
   }
}