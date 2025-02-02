/** Represents a node in a binary tree. */
public class Node {
    
    int data;
    Node left, right;

    // Constructs a branch node 
    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;  this.right = right;
    }

    // Constructs a leaf node
    Node(int data) {
        this.data = data;
        this.left = null;  this.right = null;
    }

    // Checks if this node is a leaf node
    boolean isLeaf() {
        return ((left == null) &&
                (right == null));
    }

    // Prints all the leaves below this node, L to R
    public void print() {
        if (isLeaf()) {
            System.out.print(data + " ");
        } else {
            left.print();
            right.print();
        }
    }
}
