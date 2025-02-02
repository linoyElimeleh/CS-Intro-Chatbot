/** Represents a node in a Huffman tree. The node has a character, 
 *  a character frequency, and two child nodes (left and right), that can be null. */
public class Node {
    char ch;           // character
    double freq;       // character's frequency
    Node left, right;  // pointers to child nodes
   
    /** Constructs a branch (interim) node */
    Node(char ch, double freq, Node left, Node right) {
        this.ch = ch;      this.freq = freq;
        this.left = left;  this.right = right;
    }

    /**  Constructs a leaf (terminal) node */
    Node(char ch, double freq) {
        this.ch = ch;      this.freq = freq;
        this.left = null;  this.right = null;
    }

    /** Checks if this node is a leaf (terminal) node */
    boolean isLeaf() {
        return ((left == null) && (right == null));
    }

    /** Prints all the leaves below this node, from left to right */
    // Algorithm: Depth First Search (DFS) tree traversal
    public void print() {
        if (isLeaf()) {
            System.out.println(ch + ": " + freq);
        } else {
            left.print();
            right.print();
        }
    }
}
