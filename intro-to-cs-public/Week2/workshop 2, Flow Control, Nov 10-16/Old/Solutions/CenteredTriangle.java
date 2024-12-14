public class CenteredTriangle {

    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);;
        int countRows = 1;
        for (int i = 1 ; i <= n ; i ++) {
            int blanks = n - countRows;
            for (int k = 0 ; k < blanks ; k++) {
                System.out.print(' ');
            }
            for (int j = 1 ; j <= countRows * 2 - 1 ; j++) {
                System.out.print('*');
            }
            countRows = countRows + 1;
            System.out.println();
        }
    }
}

