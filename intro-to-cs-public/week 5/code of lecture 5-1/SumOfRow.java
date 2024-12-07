// Computes the sums of the rows in a table.
// Stores the sums in the rightmost column.
public class SumOfRow {
    public static void main(String[] args) {
        // Defines a 5 by 4 2D array, and puts random values in the
        // range 0...19 in the leftmost 3 columns, for testing
        int[][] arr = new int[5][4];

        for (int i = 0; i < 5; i++)  {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = (int) (20 * Math.random()); 
            } 
        }
        // Stores the sum of each row at the rightmost column
        for (int i = 0; i < 5; i++)  {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum = sum + arr[i][j]; 
            }
            arr[i][3] = sum; 
        }
        // Prints the array
        for (int i = 0; i < 5; i++)  {
            for (int j = 0; j < 4; j++) {
                System.out.printf("%4s", arr[i][j]);
            } 
            System.out.println(); 
        } 
    } 
} 