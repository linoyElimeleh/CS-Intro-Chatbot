public class Square {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        int count = 0;
        while (count < 	n){
            count = count + 1;
            int countRow = 0;
            while (countRow < n){
                countRow = countRow + 1;
                System.out.println('*');
            }
            System.out.println();
        }

    }

}
