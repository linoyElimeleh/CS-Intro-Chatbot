public class MultTable {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 1 ; i <= N ; i++) {
            for (int j = 1 ; j <= N ; j++) {
                System.out.printf("%,5d", i * j);
            }
            System.out.println();
        }
    }
}