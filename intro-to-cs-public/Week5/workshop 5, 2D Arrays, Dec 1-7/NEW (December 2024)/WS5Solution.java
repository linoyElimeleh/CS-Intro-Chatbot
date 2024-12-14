public class WS5Solution {

    public static final int BOARD_SIZE = 3;
    public static final char EMPTY_PLACE = '.';

    public static void main(String[] args) {
        String square1 = args[0];
        String square2 = args[1];

        // Convert positions to row-column indices
        int[] pos1 = convertPositionToRowCol(square1);
        int[] pos2 = convertPositionToRowCol(square2);

        int row1 = pos1[0];
        int col1 = pos1[1];
        int row2 = pos2[0];
        int col2 = pos2[1];

        // Check square properties
        System.out.println("Are both squares white? " + areTwoSquaresWhite(row1,
                col1, row2, col2));
        System.out.println("Are both squares the same color? " +
                areTwoSquaresSameColor(row1, col1, row2, col2));

        // Initialize a simple chessboard
        char[][] board = {
                { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
                { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.' },
                { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
                { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' }
        };

        // Check if the move is legal
        if (isMoveLegal(board, row1, col1, row2, col2)) {
            System.out.println("The move is legal.");
        } else {
            System.out.println("The move is illegal.");
        }
    }

    // ⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎ PART 1 ⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎

    public static boolean isValidPosition(String pos) {
        if (pos.length() != 2) {
            return false;
        }

        char col = pos.charAt(0);
        char row = pos.charAt(1);

        int rowUpperLimit = '1' + BOARD_SIZE - 1; // we subtract 1 because the board is 0-indexed
        int colUpperLimit = 'a' + BOARD_SIZE - 1; // we subtract 1 because the board is 0-indexed

        return (row >= '1' && row <= rowUpperLimit) && (col >= 'a' && col <= colUpperLimit);
    }

    public static int[] convertPositionToRowCol(String position) {
        int[] res = new int[2];
        res[0] = BOARD_SIZE - (position.charAt(1) - '0'); // Convert '1'-'8' to 7-0
        res[1] = position.charAt(0) - 'a'; // Convert 'a'-'h' to 0-7
        return res;
    }

    public static boolean isWhiteSquare(int row, int col) {
        // A square is white if the sum of its row and column indices is even
        return (row + col) % 2 == 0;
    }

    public static boolean areTwoSquaresWhite(int row1, int col1, int row2, int col2) {
        // Both squares are white if both satisfy the white square condition
        return isWhiteSquare(row1, col1) && isWhiteSquare(row2, col2);
    }

    public static boolean areTwoSquaresSameColor(int row1, int col1, int row2, int col2) {
        // Two squares are the same color if the parity of their row + column sums is
        // the same
        return (row1 + col1) % 2 == (row2 + col2) % 2;
    }

    public static boolean isInBounds(int row, int col) {
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }

    public static boolean isWhitePiece(char piece) {
        return "PRNBQK".indexOf(piece) >= 0;
    }

    public static boolean isBlackPiece(char piece) {
        return "prnbqk".indexOf(piece) >= 0;
    }

    // ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎ PART 1 ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎
    // -----------------------------------------------
    // ⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎ PART 2 ⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎

    public static boolean isValidPawnMove(char pawn, int startRow, int startCol, int endRow, int endCol,
            char[][] board) {
        int direction = isWhitePiece(pawn) ? -1 : 1;
        int startRowPawn = isWhitePiece(pawn) ? 6 : 1;
        if (startCol == endCol) {
            if (board[endRow][endCol] == EMPTY_PLACE && (endRow == startRow + direction ||
                    (startRow == startRowPawn && endRow == startRow + 2 * direction
                            && board[startRow + direction][startCol] == '.'))) {
                return true;
            }
        } else if (Math.abs(endCol - startCol) == 1 && endRow == startRow + direction && board[endRow][endCol] != '.') {
            return true;
        }
        return false;
    }

    public static boolean isPathClear(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        int rowStep = 0;
        int colStep = 0;

        if (endRow > startRow) {
            rowStep = 1;
        } else if (endRow < startRow) {
            rowStep = -1;
        }

        if (endCol > startCol) {
            colStep = 1;
        } else if (endCol < startCol) {
            colStep = -1;
        }

        // Traverse the path
        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        while (currentRow != endRow || currentCol != endCol) {
            if (board[currentRow][currentCol] != EMPTY_PLACE) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }

        return true;
    }

    public static boolean isValidRookMove(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        if (startRow != endRow && startCol != endCol) {
            return false;
        }
        return isPathClear(startRow, startCol, endRow, endCol, board);
    }

    public static boolean isValidKnightMove(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

    public static boolean isValidBishopMove(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        if (Math.abs(startRow - endRow) != Math.abs(startCol - endCol)) {
            return false;
        }
        return isPathClear(startRow, startCol, endRow, endCol, board);
    }

    public static boolean isValidQueenMove(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        return isValidRookMove(startRow, startCol, endRow, endCol, board) ||
                isValidBishopMove(startRow, startCol, endRow, endCol, board);
    }

    public static boolean isValidKingMove(int startRow, int startCol, int endRow, int endCol) {
        return Math.abs(startRow - endRow) <= 1 && Math.abs(startCol - endCol) <= 1;
    }

    public static boolean isMoveLegal(char[][] board, int startRow, int startCol, int endRow, int endCol) {
        // Validate indices
        if (!isInBounds(startRow, startCol) || !isInBounds(endRow, endCol)) {
            return false;
        }

        char piece = board[startRow][startCol];
        if (piece == '.') {
            return false; // No piece to move
        }

        // Check if moving to a friendly square
        if (isWhitePiece(piece) && isWhitePiece(board[endRow][endCol]) ||
                isBlackPiece(piece) && isBlackPiece(board[endRow][endCol])) {
            return false;
        }

        // Validate move for each piece type
        if (piece == 'P' || piece == 'p') {
            return isValidPawnMove(piece, startRow, startCol, endRow, endCol, board);
        }
        if (piece == 'R' || piece == 'r') {
            return isValidRookMove(startRow, startCol, endRow, endCol, board);
        }
        if (piece == 'N' || piece == 'n') {
            return isValidKnightMove(startRow, startCol, endRow, endCol);
        }
        if (piece == 'B' || piece == 'b') {
            return isValidBishopMove(startRow, startCol, endRow, endCol, board);
        }
        if (piece == 'Q' || piece == 'q') {
            return isValidQueenMove(startRow, startCol, endRow, endCol, board);
        }
        if (piece == 'K' || piece == 'k') {
            return isValidKingMove(startRow, startCol, endRow, endCol);
        }

        return false;
    }

    // ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎ PART 2 ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎
}
