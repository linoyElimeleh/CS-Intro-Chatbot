public class RightJustifiedTriangle {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int countRow = 1;
        for (int i = 1 ; i <= n ; i ++) {
            int blanks = n - i;
            for (int j = 1 ; j <= blanks ; j++) {
                System.out.print(' ');
            }
            for (int k = 1 ; k <= i ; k++) {
                System.out.print('*');
            }
            countRow = countRow + 1;
            System.out.println();
        }
    }
}
