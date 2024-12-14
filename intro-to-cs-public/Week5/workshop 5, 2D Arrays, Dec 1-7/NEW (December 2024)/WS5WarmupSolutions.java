public class WS5WarmupSolutions {
    public static void main(String[] args) {

    }

    public static int[][] initializeExample() {
        int[][] arr = new int[3][3];
        return arr;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void initializeChangePrint() {
        int[][] arr = initializeExample();
        arr[1][1] = 1;
        print(arr);
    }
}
