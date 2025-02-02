// Testing the Tree's Node class
public class TreeTest {
    public static void main(String[] args) {
        Node leaf1 = new Node(7);
        Node leaf2 = new Node(3);
        Node leaf3 = new Node(5);
        Node branch = new Node(0, leaf2, leaf3);
        Node root = new Node(0, leaf1, branch);
        root.print();
    }
}