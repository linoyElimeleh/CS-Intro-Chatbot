// Test class for Huffman Compression
public class CompTest {
    public static void main1(String[] args) {
        double[] freq = new double[256];
        freq['a'] = 8; freq['b'] = 3; freq['c'] = 1; freq['d'] = 1;
        freq['e'] = 1; freq['f'] = 1; freq['g'] = 1; freq['h'] = 1;

        Comp.init(freq);

        String text = "abadcab";
        System.out.print("Text: " + text);
        System.out.println(" (length in bits: " + text.length() * 16 + ")");

        String compressedText = Comp.compress(text);
        System.out.print("Compressed text: " + compressedText);
        System.out.println(" (length in bits: " + compressedText.length() + ")");

        System.out.println("Decompressed text: " + Comp.decompress(compressedText));
    }

    public static void main(String[] args) {
        double[] freq = new double[256];
        freq['a'] = 8; freq['b'] = 3; freq['c'] = 1; freq['d'] = 1;
        freq['e'] = 1; freq['f'] = 1; freq['g'] = 1; freq['h'] = 1;

        Comp.init(freq);

        String text = "abadcab";
        System.out.println("Text: " + text);

        String compressedText = Comp.compress(text);
        System.out.println("Compressed text: " + compressedText);

        System.out.println("Decompressed text: " + Comp.decompress(compressedText));
    }
}