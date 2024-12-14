public class ProblemSet5Sol {

    public static void main(String[] args) {
        double[][] matrix = {
            {2, 1, -1, 8},
            {-3, -1, 2, -11},
            {-2, 1, 2, -3}
        };

        System.out.println("Original Matrix:");
        ProblemSet5Helpers.print2DArray(matrix);

        // Perform Gauss-Jordan Reduction
        double[][] reducedMatrix = gaussJordanReduction(matrix);

        System.out.println("\nReduced Row-Echelon Form:");
        ProblemSet5Helpers.print2DArray(reducedMatrix);
    }

    public static double[][] gaussJordanReduction(double[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Create a copy of the matrix manually
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = mat[i][j];
            }
        }

        for (int pivotRow = 0; pivotRow < rows; pivotRow++) {
            // Find the pivot element (non-zero) and ensure it's on the diagonal
            if (matrix[pivotRow][pivotRow] == 0) {
                for (int swapRow = pivotRow + 1; swapRow < rows; swapRow++) {
                    if (matrix[swapRow][pivotRow] != 0) {
                        ProblemSet5Helpers.rowInterchange(matrix, pivotRow, swapRow);
                        break;
                    }
                }
            }

            // If the pivot is still zero, skip the column
            if (matrix[pivotRow][pivotRow] == 0) {
                continue;
            }

            // Step 1: Normalize the pivot row
            double pivotValue = matrix[pivotRow][pivotRow];
            ProblemSet5Helpers.rowScaling(matrix, pivotRow, 1.0 / pivotValue); // Scaling to make pivot 1

            // Step 2: Zero out the other rows in the pivot column
            for (int otherRow = 0; otherRow < rows; otherRow++) {
                if (otherRow != pivotRow) {
                    double scale = -matrix[otherRow][pivotRow];
                    ProblemSet5Helpers.rowReplacement(matrix, otherRow, pivotRow, scale);
                }
            }
        }

        return matrix;
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // Check if the first row contains zero
        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        } 

        // Check if the first column contains zero
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                firstColHasZero = true; 
                break;
            }
        }

        // Use the first row and column as markers
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        // Set the marked rows to zero
        for (int row = 1; row < rows; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < cols; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        // Set the marked columns to zero
        for (int col = 1; col < cols; col++) {
            if (matrix[0][col] == 0) {
                for (int r = 1; r < rows; r++) {
                    matrix[r][col] = 0;
                }
            }
        }

        // Set the first row to zero if needed
        if (firstRowHasZero) {
            for (int c = 0; c < cols; c++) {
                matrix[0][c] = 0;
            }
        }

        // Set the first column to zero if needed
        if (firstColHasZero) {
            for (int r = 0; r < rows; r++) {
                matrix[r][0] = 0;
            }
        }        
    }
}