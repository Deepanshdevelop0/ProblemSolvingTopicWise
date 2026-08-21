package LeetCode.Recursion.Trying_out_all_combos_advanced;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {

    public static void main(String[] args) {
        N_Queens classObj = new N_Queens();
        classObj.solveNQueens(4).forEach(i -> {
            System.out.print("[");
            for (String j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        });
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        solve(n, 0, board, res);

        return res;
    }

    public void solve(int n, int row, char[][] board, List<List<String>> res) {
        if (row == n) {
            res.add(convertToListOfString(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';

                solve(n, row + 1, board, res);

                board[row][col] = '.';
            }
        }

    }

    public boolean isSafe(char[][] board, int row, int col, int n) {

        // check straight up
        int i = row-1, j = col;
        while (i >= 0) {
            if (board[i--][j] == 'Q') return false;
        }

        // check left diagonal
        i = row-1; j = col-1;
        while (i >= 0 && j >= 0) {
            if (board[i--][j--] == 'Q') return false;
        }

        // check right diagonal
        i = row-1; j = col+1;
        while (i >= 0 && j < n) {
            if (board[i--][j++] == 'Q') return false;
        }

        return true;
    }

    public List<String> convertToListOfString(char[][] board) {
        List<String> subList = new ArrayList<>();

        for (char[] arr : board) {
            subList.add(new String(arr));
        }

        return subList;
    }


}
