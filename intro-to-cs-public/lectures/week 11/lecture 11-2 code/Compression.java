// LinkedList is a generic Java class which is very similar to 
// the List class implemented in the IDC Intro to CS course. 
import java.util.LinkedList;

// Provides compression and decompression services,
// using Huffman codes. Works in test most: Instead of using
// a data-driven frequencies array, uses a small array, for
// testing and illustration purposes.
public class Compression {

    public static void main(String[] args) {

        // Builds a frequencies array, for testing
        double[] freq = new double[256];
        // Stores the frequencies data shown in the lecture 13-1 example
        freq['a'] = 8; freq['b'] = 3;
        freq['c'] = 1; freq['d'] = 1; freq['e'] = 1;  
        freq['f'] = 1; freq['g'] = 1; freq['h'] = 1;  

        // Builds a Huffman tree from the frequencies array
        Node tree = buildTree(freq);
        tree.print();
        System.out.println();

        // Builds a codebook from the given Huffman tree
        String[] codeBook = new String[freq.length];
        buildCodes(tree, codeBook, "");
        printCodeBook(codeBook);
        System.out.println();

        // Tests the compression method
        String text = "abadcab";
        System.out.println("Text: " + text);
        System.out.println("Text length in bits: " + text.length() * 16);
        System.out.println();

        String compressedText = compress(text, codeBook);
        System.out.println("Compressed text: " + compressedText);
        System.out.println("Compressed text length in bits: " + compressedText.length());
        System.out.println();

        // Test 1 of the decompress method
        System.out.println("Decompressed text: " + decompress(compressedText, tree));

        // Test 2, illustrates the lossless nature of the compression
        String source = "gafaggbacdaggfabbabffafgbadcaffdagcadaacbaaabcafgdaggad";
        // Checks if decompress(compress(source)) == source
        System.out.println(decompress(compress(source,codeBook),tree).equals(source));
    }

    // Builds a Huffman tree from the given array of frequencies, 
    // and returns the tree.
    private static Node buildTree(double[] freq) {
        LinkedList<Node> tree = new LinkedList<Node>();
        // If a frequency is greater than 0, adds a node to the list
        for (char ch = 0; ch < freq.length; ch++) {
            double p = freq[ch];
            if (p > 0) {
                Node leaf = new Node(ch, p);
                tree.add(leaf);
            }
        }

        // Removes the two nodes with the minimal frequencies, merges their 
        // contents into a new node, and adds the new node to the list.
        // Keeps doing this until the tree has only one element.
        // (This loop turns the list into a Huffman tree)
        while (tree.size() > 1) {
            Node min1 = removeMin(tree);
            Node min2 = removeMin(tree);
            Node branch = new Node(' ', min1.p + min2.p, min1, min2);
            tree.add(branch);
        }

        // Returns the tree's root
        return tree.getFirst();
    }

    // Builds codes for all the leaves below the given node.
    // The code starts with the given code prefix.
    // If this method is called on the root, it should be called
    // with the initial prefix "".
    private static void buildCodes(Node node, String[] codeBook, String code) {
        // If the node is a branch
        if (!node.isLeaf()) {
            // Builds the code recursively, inside the method calls:
            // Builds the code on the left
            buildCodes(node.left, codeBook, code + '0');
            // Builds the codes on the right
            buildCodes(node.right, codeBook, code + '1');
        }
        // The node is a leaf:
        else {            
            // Adds the character and its code to the codebook
            codeBook[node.ch] = code;
        }
    }

    // Compresses the given text into a string of 0 and 1 bits,
    // Using the given codebook. Returns the compressed text.
    private static String compress(String text, String[] codeBook) {
        StringBuilder codedText = new StringBuilder();
        // For each character in the given text,
        // appends the code of that character to the codedText
        for (char i = 0; i < text.length(); i++) {
            codedText.append(codeBook[text.charAt(i)]);
        }
        return codedText.toString();
    }

    // Decompresses the given comptessed text, back to the 
    // uncompressed text, using the given Huffman tree.
    private static String decompress(String compressed, Node root) {
        StringBuilder text = new StringBuilder();
        Node node = root;
        // Creates an array of characters (0's and 1's) out of the compressed string.
        // This allows iterating the array using a for-each loop, instead of iterating
        // using a regular for-loop over the string, which is slightly more cumbersome
        // and less readable. 
        char[] compressedChars = compressed.toCharArray();
        for (char ch : compressedChars) {
            if (ch == '0') {
                node = node.left;
            } else { // ch == '1'
                node = node.right;
            }

            if (node.isLeaf()) {
                text.append(node.ch);
                // Returns to the root, in preparation for handling 
                // the next character in the iteration (0 or 1).
                node = root;
            }
        }
        return text.toString();
    }

    // This method is used by the buildTree method. It finds the first node
    // in the given list that has a minimal frequency (p value). It then 
    // removes this node from the list, and returns the node. 
    private static Node removeMin(LinkedList<Node> list) {
        Node minNode = list.getFirst();
        for (Node node : list) {
            if (node.p < minNode.p) {
                minNode = node;
            }
        }
        list.remove(minNode);
        return minNode;
    }

    // Compresses the given text into a string of codes ('0' and '1' characters),
    // Using the given codebook.
    private static void printCodeBook(String[] codeBook) {

        for (char ch = 0; ch < codeBook.length; ch++) {
            String code = codeBook[ch];
            if (code != null)
                System.out.println((char) ch + ": " + codeBook[ch]);
        }
    }
}