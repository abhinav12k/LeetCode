package Recursion;

public class queenCombination2D {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        queenCombination2D(board, 0, 0, 0, 2, "");
    }

    static int count = 0;

    private static void queenCombination2D(boolean[][] board, int row, int col, int qpsf, int tq, String ans) {

        if (qpsf == tq) {
            System.out.println(++count + ". " + ans);
            return;
        }

        if (col == board[0].length) {
            row = row + 1;
            col = 0;
        }

        if (row == board.length) {
            return;
        }

        if (isItSafeToPlace(board, row, col)) {
            board[row][col] = true;
            queenCombination2D(board, row, col + 1, qpsf + 1, tq, ans + "( " + row +
                    "," + col + " )");
            board[row][col] = false;
        }

        queenCombination2D(board, row, col + 1, qpsf, tq, ans);
    }

    private static boolean isItSafeToPlace(boolean[][] board, int row, int col) {

        //checking vertically up
        int r = row - 1;
        while (r >= 0) {
            if (board[r][col]) {
                return false;
            }
            r--;
        }

        //left
        int c = col - 1;
        while (c >= 0) {
            if (board[row][c]) {
                return false;
            }
            c--;
        }

        //diagonally left
        r = row - 1;
        c = col - 1;
        while (r >= 0 && c >= 0) {
            if (board[r][c]) {
                return false;
            }
            r--;
            c--;
        }

        //diagonally right
        r = row - 1;
        c = col + 1;
        while (r >= 0 && c < board[0].length) {
            if (board[r][c])
                return false;
            r--;
            c++;
        }

        return true;
    }

}
