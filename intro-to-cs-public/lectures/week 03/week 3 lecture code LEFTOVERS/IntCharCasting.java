// Demonstrates that strings are immutable, and arrays are mutable.
public class IntCharCasting {
    public static void main(String args[]) {

       int f = (int)(10 * Math.random());
       char g = (char)(f + '0');
       System.out.println(f);  // lowecase?
       System.out.println(g);  // lowecase?
       System.out.println((c >= '0') && (c <= '9'));  // lowecase?

}