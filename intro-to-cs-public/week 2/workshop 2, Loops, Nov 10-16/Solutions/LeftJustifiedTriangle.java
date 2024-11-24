public class LeftJustifiedTriangle {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int countRow = 1;
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1 ; j <= countRow ; j++) {
                System.out.print('*');
            }
            countRow = countRow + 1;
            System.out.println();
        }
    }
}
