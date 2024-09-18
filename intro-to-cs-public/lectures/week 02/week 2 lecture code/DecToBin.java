public class DecToBin {
    public static void main (String[] args) {
        int x = Integer.parseInt(args[0]);
        String s = "";
        while (x > 0) {
            if ((x % 2) == 0) {
                s = "0" + s;
            }
            else {
                s = "1" + s;
            }
            x = x / 2;  // integer division
        }
        System.out.println(s);
    }
}
