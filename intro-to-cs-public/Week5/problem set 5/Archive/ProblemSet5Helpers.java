public class ProblemSet5Helpers {
    public static void main(String[] args) {
        
    }

    public static void printArray(double[] array){
        System.out.print('{'); 
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i]);
            char c = i != array.length - 1 ? ',' : '}';
            System.out.print(c);
        }
        System.out.println();
    }
    
    public static void print2DArray (double[][] arr) {
        System.out.println('{'); 
        for (int i = 0; i < arr.length; i++) {
            printArray(arr[i]);
        }
        System.out.println('}');
    }

    public static void rowInterchange(double[][] mat, int row1, int row2) {
        double[] temp = mat[row1];
        mat[row1] = mat[row2];
        mat[row2] = temp;
    }

    public static void rowScaling(double[][] mat, int row, double scale) {
        for(int i = 0; i < mat[row].length ; i++){
            mat[row][i] *= scale;
        } 
    }
    
    public static void rowReplacement(double[][] mat, int row1, int row2, double scale) {
        for(int i = 0; i < mat[row1].length ; i++){
           mat[row1][i] += (mat[row2][i] * scale);
        } 
    }
}
