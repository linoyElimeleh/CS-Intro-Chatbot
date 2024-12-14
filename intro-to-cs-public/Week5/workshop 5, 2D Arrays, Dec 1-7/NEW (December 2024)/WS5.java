public class WS5 {
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
        System.out.println("Are both squares white? " + areTwoSquaresWhite(row1, col1, row2, col2));
        System.out.println("Are both squares the same color? " + areTwoSquaresSameColor(row1, col1, row2, col2));

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

    /**
     * Validates if the given chess square position is valid.
     *
     * @param pos the chess position string in standard notation (e.g., "e2").
     * @return {@code true} if the position is valid (within the board bounds);
     *         {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
     * (index 1)  7  { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
     * (index 7)  1  { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidPosition("e2")} returns {@code true}.</li>
     *         <li>{@code isValidPosition("i9")} returns {@code false}.</li>
     *         </ul>
     */
    public static boolean isValidPosition(String pos) {
        // implement
        return false;
    }

    /**
     * Converts a chess square position to row-column indices for
     * internal representation.
     *
     * @param position the chess position string (e.g., "e2").
     * @return an integer array of size 2, where:
     *         - {@code res[0]} is the row index (0-based from the top of the
     *         board).
     *         - {@code res[1]} is the column index (0-based from the left of the
     *         board).
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', '.', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code convertPositionToRowCol("e2")} returns
     *         {@code [6, 4]}.</li>
     *         <li>{@code convertPositionToRowCol("a8")} returns
     *         {@code [0, 0]}.</li>
     *         </ul>
     */
    public static int[] convertPositionToRowCol(String position) {
        // implement
        return new int[2];
    }

    /**
     * Determines if a given square on the chessboard is white.
     *
     * @param row the 0-based row index.
     * @param col the 0-based column index.
     * @return {@code true} if the square is white; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', '.', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isWhiteSquare(0, 0)} returns {@code true}.</li>
     *         <li>{@code isWhiteSquare(0, 1)} returns {@code false}.</li>
     *         <li>{@code isWhiteSquare(7, 7)} returns {@code true}.</li>
     *         </ul>
     */
    public static boolean isWhiteSquare(int row, int col) {
        // implement
        return false;
    }

    /**
     * Checks if both squares are white.
     *
     * @param row1 the row index of the first square.
     * @param col1 the column index of the first square.
     * @param row2 the row index of the second square.
     * @param col2 the column index of the second square.
     * @return {@code true} if both squares are white; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', '.', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code areTwoSquaresWhite(0, 0, 0, 1)} returns {@code false}
     *         (because (0,1) is black).</li>
     *         <li>{@code areTwoSquaresWhite(0, 0, 1, 1)} returns
     *         {@code true}.</li>
     *         </ul>
     */
    public static boolean areTwoSquaresWhite(int row1, int col1, int row2, int col2) {
        // implement
        return false;
    }

    /**
     * Checks if two given squares on the chessboard are of the same color.
     *
     * @param row1 the row index of the first square.
     * @param col1 the column index of the first square.
     * @param row2 the row index of the second square.
     * @param col2 the column index of the second square.
     * @return {@code true} if both squares are of the same color; {@code false}
     *         otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', '.', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code areTwoSquaresSameColor(0, 0, 1, 1)} returns
     *         {@code true}.</li>
     *         <li>{@code areTwoSquaresSameColor(0, 0, 0, 1)} returns
     *         {@code false}.</li>
     *         </ul>
     */
    public static boolean areTwoSquaresSameColor(int row1, int col1, int row2, int col2) {
        // implement
        return false;
    }

    /**
     * Checks if a given row and column are within the bounds of the chessboard.
     *
     * @param row the row index to check.
     * @param col the column index to check.
     * @return {@code true} if the row and column are within the bounds (0-7);
     *         {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', '.', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isInBounds(0, 0)} returns {@code true}.</li>
     *         <li>{@code isInBounds(8, 8)} returns {@code false}.</li>
     *         <li>{@code isInBounds(0, 8)} returns {@code false}.</li>
     *         </ul>
     */
    public static boolean isInBounds(int row, int col) {
        // implement
        return false;
    }

    /**
     * Determines if a given chess piece is white.
     *
     * @param piece the character representing a chess piece (e.g., 'P' for white
     *              pawn).
     * @return {@code true} if the piece is white; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
     * (index 1)  7  { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
     * (index 7)  1  { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isWhitePiece('P')} returns {@code true}.</li>
     *         <li>{@code isWhitePiece('p')} returns {@code false}.</li>
     *         </ul>
     */
    public static boolean isWhitePiece(char piece) {
        // implement
        return false;
    }

    /**
     * Determines if a given chess piece is black.
     *
     * @param piece the character representing a chess piece (e.g., 'p' for black
     *              pawn).
     * @return {@code true} if the piece is black; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
     * (index 1)  7  { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
     * (index 7)  1  { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isBlackPiece('P')} returns {@code false}.</li>
     *         <li>{@code isBlackPiece('p')} returns {@code true}.</li>
     *         </ul>
     */
    public static boolean isBlackPiece(char piece) {
        // implement
        return false;
    }

    // ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎ PART 1 ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎
    // -----------------------------------------------
    // ⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎ PART 2 ⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎⬇︎

    /**
     * Validates if a given pawn move is legal.
     *
     * @param pawn     the character representing the pawn ('P' for white, 'p' for
     *                 black).
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @param board    the current state of the chessboard as a 2D char array.
     * @return {@code true} if the pawn move is valid; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', 'p', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', 'p', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', 'P', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', '.', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidPawnMove('P', 6, 1, 4, 1, board)} returns
     *         {@code true} for white pawn moving two steps forward.</li>
     *         <li>{@code isValidPawnMove('P', 6, 1, 5, 1, board)} returns
     *         {@code true} for white pawn moving one step forward.</li>
     *         <li>{@code isValidPawnMove('p', 1, 6, 3, 6, board)} returns
     *         {@code false} because black pawns move downward.</li>
     *         <li>{@code isValidPawnMove('P', 6, 1, 5, 2, board)} returns
     *         {@code true} for white pawn capturing a black pawn.</li>
     *         </ul>
     */
    public static boolean isValidPawnMove(char pawn, int startRow, int startCol, int endRow, int endCol,
            char[][] board) {
        // implement
        return false;
    }

    /**
     * Checks if the path between two points on the chessboard is clear of other
     * pieces - !for straight or diagonal moves only!
     *
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @param board    the current state of the chessboard as a 2D char array.
     * @return {@code true} if the path is clear; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { 'r', '.', '.', '.', '.', '.', '.', 'r' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', 'P', '.', '.', '.', '.', 'P', '.' },
     * (index 7)  1  { 'R', '.', '.', '.', '.', '.', '.', 'R' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isPathClear(1, 0, 3, 0, board)} returns {@code true}.</li>
     *         <li>{@code isPathClear(0, 0, 7, 0, board)} returns {@code false}
     *         because the pawn at b7 blocks the path.</li>
     *         </ul>
     */
    public static boolean isPathClear(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        // implement
        return false;
    }

    /**
     * Validates if a given rook move is legal.
     *
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @param board    the current state of the chessboard as a 2D char array.
     * @return {@code true} if the rook move is valid; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', 'R', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidRookMove(7, 2, 7, 7, board)} returns
     *         {@code true}.</li>
     *         <li>{@code isValidRookMove(7, 2, 5, 4, board)} returns {@code false}
     *         because the move is diagonal.</li>
     *         </ul>
     */
    public static boolean isValidRookMove(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        // implement
        return false;
    }

    /**
     * Validates if a given knight move is legal.
     *
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @return {@code true} if the knight move is valid; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', 'N', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidKnightMove(7, 2, 5, 3)} returns {@code true}.</li>
     *         <li>{@code isValidKnightMove(7, 2, 7, 4)} returns {@code false}
     *         because the move is not L-shaped.</li>
     *         </ul>
     */
    public static boolean isValidKnightMove(int startRow, int startCol, int endRow, int endCol) {
        // implement
        return false;
    }

    /**
     * Validates if a given bishop move is legal.
     *
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @param board    the current state of the chessboard as a 2D char array.
     * @return {@code true} if the bishop move is valid; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', 'B', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidBishopMove(7, 2, 5, 4, board)} returns
     *         {@code true}.</li>
     *         <li>{@code isValidBishopMove(7, 2, 7, 4, board)} returns
     *         {@code false} because the move is not diagonal.</li>
     *         </ul>
     */
    public static boolean isValidBishopMove(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        // implement
        return false;
    }

    /**
     * Validates if a given queen move is legal.
     *
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @param board    the current state of the chessboard as a 2D char array.
     * @return {@code true} if the queen move is valid; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', 'Q', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidQueenMove(7, 2, 5, 4, board)} returns
     *         {@code true}.</li>
     *         <li>{@code isValidQueenMove(7, 2, 7, 4, board)} returns
     *         {@code true}.</li>
     *         <li>{@code isValidQueenMove(7, 2, 6, 4, board)} returns {@code false}
     *         because the move is not diagonal or straight.</li>
     *         </ul>
     */
    public static boolean isValidQueenMove(int startRow, int startCol, int endRow, int endCol, char[][] board) {
        // implement
        return false;
    }

    /**
     * Validates if a given king move is legal.
     *
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @return {@code true} if the king move is valid; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 1)  7  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 7)  1  { '.', '.', 'K', '.', '.', '.', '.', '.' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isValidKingMove(7, 2, 6, 3)} returns {@code true}.</li>
     *         <li>{@code isValidKingMove(7, 2, 7, 3)} returns {@code true}.</li>
     *         <li>{@code isValidKingMove(7, 2, 5, 4)} returns {@code false} because
     *         the move is too far.</li>
     *         </ul>
     */
    public static boolean isValidKingMove(int startRow, int startCol, int endRow, int endCol) {
        // implement
        return false;
    }

    /**
     * Validates if a move is legal on the chessboard based on the current board
     * state.
     *
     * @param board    the current state of the chessboard as a 2D char array.
     * @param startRow the row index of the starting square.
     * @param startCol the column index of the starting square.
     * @param endRow   the row index of the destination square.
     * @param endCol   the column index of the destination square.
     * @return {@code true} if the move is legal; {@code false} otherwise.
     *
     *         <br>
     *         <br>
     *         Example Board:
     * 
     *         <pre>
     * char[][] board = {
     * (index 0)  8  { 'r', '.', '.', '.', 'k', '.', '.', 'r' },
     * (index 1)  7  { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
     * (index 2)  6  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 3)  5  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 4)  4  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 5)  3  { '.', '.', '.', '.', '.', '.', '.', '.' },
     * (index 6)  2  { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
     * (index 7)  1  { 'R', '.', '.', '.', 'K', '.', '.', 'R' }
     *                  a    b    c    d    e    f    g    h
     * (indices:        0    1    2    3    4    5    6    7)
     * };
     *         </pre>
     *
     *         Examples:
     *         <ul>
     *         <li>{@code isMoveLegal(board, 6, 4, 4, 4)} returns {@code true} for a
     *         pawn move from e2 to e4.</li>
     *         <li>{@code isMoveLegal(board, 0, 4, 1, 4)} returns {@code false} for
     *         an invalid king move.</li>
     *         </ul>
     */
    public static boolean isMoveLegal(char[][] board, int startRow, int startCol, int endRow, int endCol) {
        // implement
        return false;
    }

    // ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎ PART 2 ⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎⬆︎
}
