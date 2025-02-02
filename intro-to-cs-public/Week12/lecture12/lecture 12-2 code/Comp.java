import java.util.LinkedList;

/** Provides text compression and decompression methods. 
 *  Before using, the init method must be called. */
public class Comp {
    static Node root;          // top node
    static String[] codeBook;  // array of character codes

    /** Initializes data structures based on the given letter frequencies. */
    public static void init(double[] freq) {
        // Sets root to the Huffman tree
        root = buildTree(freq);   
        // Sets codeBook to the array of Huffman codes           
        codeBook = new String[freq.length];
        populateCodeBook(root, "", codeBook);          
    }

    /** Compresses the given text into a string of 0's and 1's. */
    public static String compress(String text) {
        StringBuilder codedText = new StringBuilder();
        // for each character in the given text, appends its code from the code book
        for (int i = 0; i < text.length(); i++) {
            codedText.append(codeBook[text.charAt(i)]);
        }
        return codedText.toString();
    }

    /** Decompresses the given coded text into the original text. */
    public static String decompress(String codedText) {
        StringBuilder text = new StringBuilder();
        Node node = root;
        for (int i = 0; i < codedText.length(); i++) {
            char ch = codedText.charAt(i); 
            // if 0, go left; if 1, go right 
            if (ch == '0') {
                node = node.left;
            } else { 
                node = node.right;
            }
            // if leaf node, appends the character
            if (node.isLeaf()) {
                text.append(node.ch);  
                // Resets to the root, for the next sequence of 0's and 1's
                node = root;           
            }
        }
        // Returns the decompressed text
        return text.toString();  
    }

    /** Returns a Huffman tree, built from the given letter frequencies. */
    private static Node buildTree(double[] freq) {
        // Builds the initial, flat tree (list of Node elements)
        LinkedList<Node> tree = new LinkedList<>();
        // If a letter frequency is greater than 0, adds a new node
        for (char ch = 0; ch < freq.length; ch++) {
            if (freq[ch] > 0) {
                tree.add(new Node(ch, freq[ch]));
            }
        }
        // Main loop: Removes the two nodes with the minimal frequencies, 
        // merges them into a new node, and adds the new node to the tree.
        // Keeps doing this until the tree has only one node.
        while (tree.size() > 1) {
            Node min1 = removeMin(tree);
            Node min2 = removeMin(tree);
            tree.add(new Node(' ', min1.freq + min2.freq, min1, min2));
        }
        return tree.getFirst(); // Returns the root node
    }

    /** Finds, removes, and returns the node with the minimal frequency. */
    private static Node removeMin(LinkedList<Node> list) {
        Node minNode = list.getFirst();
        for (Node node : list) {
            if (node.freq < minNode.freq) {
                minNode = node;
            }
        }
        list.remove(minNode);
        return minNode;
    }

    /** Populates the codeBook by assigning binary codes to each character.
     *  Side effect: Modifies the codeBook static variable. */
    private static void populateCodeBook(Node node, String code, String[] codeBook) {
        // Assigns the codes, using DFS
        if (node.isLeaf()) {
            // When teaching a leaf, the code is complete; 
            // Assigns the code to the character, and exits
            codeBook[node.ch] = code; 
            return;
        }
        // Builds the code recursively, by going left or right
        populateCodeBook(node.left, code + '0', codeBook);
        populateCodeBook(node.right, code + '1', codeBook);
    }

    /** Prints the codeBook (for debugging). */
    public static void printCodeBook() {
        for (char ch = 0; ch < codeBook.length; ch++) {
            String code = codeBook[ch];
            if (code != null) {
                System.out.println((char) ch + ": " + code);
            }
        }
    }
}
