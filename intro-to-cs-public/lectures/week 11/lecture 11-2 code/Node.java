// Represents an element in a Huffman tree.
class Node {
    
    char ch;           // a character
    double p;          // the character's frequency
    Node left, right;  // pointers to the two nodes "below"

    // Constructs a branch node 
    Node(char ch, double freq, Node left, Node right) {
        this.ch = ch;       this.p = freq;
        this.left  = left;  this.right = right;
    }

    // Constructs a leaf node
    Node(char ch, double freq) {
        this.ch = ch;       this.p = freq;
        this.left  = null;  this.right = null;
    }

    // Checks if this node is a leaf node
    boolean isLeaf() {
        return ((left == null) && (right == null));
    }

    // Prints all the leaves of the tree, from left to right
    public void print() {
        if (isLeaf()) {
            System.out.println(ch + ": " + p);
        } else {
            left.print();
            right.print();
        }
    }
}
