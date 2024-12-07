public class ProblemSet5 {

    public static void main(String[] args) {


    }
    // 1. Gauss Jordan Elimination

    // As you probably learned in your linear algebra class, Gauss Jordan elimination is a method used to solve systems of linear equations.
    // Write a method called "gaussJordanElimination" that takes a 2D array of doubles as input and returns a 2D array of doubles.
    // The method should perform Gauss Jordan elimination on the input array and return the resulting matrix.
    // You can assume that the input matrix is square and has a unique solution.
    // You may not change the input matrix.
    // 
    // Steps:
    // 1. Create a copy of the input matrix.
    // 2. Iterate through the rows of the matrix.
    // 3. For each row, perform the following operations:
    //    a.Find the pivot element (non-zero) and ensure it's on the diagonal
    //    b.If the pivot is still zero, skip the column
    //    c.Normalize the pivot row via rowScaling, making the pivot 1
    //    d.Zero out the other rows in the pivot column via rowReplacement

    public static double[][] gaussJordanElimination(double[][] mat) {
       // TODO: Implement the gaussJordanElimination method
        return null;   
    }

    //2. Set Matrix Zeroes

    //Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
    //You must change the existing matrix.
    // Steps:
    // 1. Check if the first row contains zero or not.
    // 2. Check if the first column contains zero or not.
    // 3. Use row 0 and column 0 as the flags to store the zero information.
    // 4. Iterate through the matrix and from rowIndex = 1, colIndex = 1. and mark all the rows and columns that need to be set to zero.
    // 5. Set the marked rows to zero
    // 6. Set the marked columns to zero
    // 7. Set the first row to zero if needed
    // 8. Set the first column to zero if needed
    public static double[][] gaussJordanElimination(int[][] mat) {
        // TODO: Implement the gaussJordanElimination method
        return null;   
    }

}