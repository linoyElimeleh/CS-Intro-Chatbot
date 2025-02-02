/** Represents a generic node in a generic linked list. */
public class Node<T> {

   T data;        // data (an object of type T)
   Node<T> next;  // pointer

   /** Constructs a node with the given data.
    *  The new node will point to the next node. */
   public Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
   }
	    
   /** Constructs a node with the given data.
    *  The new node will point to null. */
   public Node(T data) {
      this(data, null);
   }

   /** Textual representation of this node. */
   public String toString() {
      return "" + data;
   }
}