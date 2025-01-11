public class Node {
    int data;
    Node next;


    // Constructor to initialize the node with data, and next
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    // Constructor to initialize the node with data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}