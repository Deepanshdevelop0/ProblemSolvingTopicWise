package LeetCode.Recursion.Trying_out_all_combos_advanced;

public class Sudoku_Solver {

/**

Solves a 9x9 Sudoku board using an optimized Backtracking algorithm.

Optimization: Uses 2D boolean arrays to cache the state of rows, columns,
and 3x3 sub-boxes, allowing for O(1) constant-time constraint checking.

TC: O(9^k)
 where 'k' is the number of empty cells. In the worst case,
 we explore 9 possible digits for each empty cell. Because the board
 is strictly bounded to 9x9 (k <= 81), this is technically O(1).

SC: O(k)
 for the recursion call stack, bounded by a maximum depth of 81.
 The auxiliary boolean arrays take O(1) constant space (3 x 90 booleans).
 Overall, strictly bounded to O(1).

*/

    public static void main(String[] args) {
        Sudoku_Solver classObj = new Sudoku_Solver();

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        classObj.solveSudoku(board);

        for (char[] row : board) {
            for (char ch : row) {
                System.out.print(ch + ", ");
            }
            System.out.println();
        }

    }

    public void solveSudoku(char[][] board) {

        boolean[][] rowCheck = new boolean[9][10];
        boolean[][] colCheck = new boolean[9][10];
        boolean[][] boxCheck = new boolean[9][10];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') continue;
                int digit = board[row][col] - '0';

                int boxIndx = (row / 3) * 3 + (col / 3);

                rowCheck[row][digit] = true;
                colCheck[col][digit] = true;
                boxCheck[boxIndx][digit] = true;
            }
        }

        solve(0, 0, rowCheck, colCheck, boxCheck, board);

    }

    public boolean solve(int row, int col, boolean[][] rowCheck, boolean[][] colCheck, boolean[][] boxCheck, char[][] board) {
        if (row == 8 && col == 9) return true;
        if (col > 8) return solve(row+1, 0, rowCheck, colCheck, boxCheck, board);
        if (board[row][col] != '.') return solve(row, col+1, rowCheck, colCheck, boxCheck, board);

        int boxIndx = (row / 3) * 3 + (col / 3);

        for (int digit = 1; digit <= 9; digit++) {
            if (!rowCheck[row][digit] && !colCheck[col][digit] && !boxCheck[boxIndx][digit]) {

                board[row][col] = (char) (digit + '0');

                rowCheck[row][digit] = true;
                colCheck[col][digit] = true;
                boxCheck[boxIndx][digit] = true;

                if (solve(row, col+1, rowCheck, colCheck, boxCheck, board)) {
                    return true;
                }

                board[row][col] = '.';

                rowCheck[row][digit] = false;
                colCheck[col][digit] = false;
                boxCheck[boxIndx][digit] = false;
            }
        }

        return false;
    }


}
