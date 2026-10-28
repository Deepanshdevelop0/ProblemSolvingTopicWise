package LeetCode.DP.Revision;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

    public static void main(String[] args) {
        Minimum_Falling_Path_Sum classObj = new Minimum_Falling_Path_Sum();

//        int res = classObj.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
//        int res = classObj.minFallingPathSumTabulation(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
//        int res = classObj.minFallingPathSumTabulationOptimized(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
        int res = classObj.minFallingPathSumInPlace(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});

        System.out.println("Result : " + res);
    }


    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int min = Integer.MAX_VALUE;

        // for memoization
        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, 1000000);
        }

        for (int i = 0; i < n; i++) {
//            min = Math.min(min, minFallingPathSumRecursion(matrix, m, n, 0, i)); // recursion method

            min = Math.min(min, minFallingPathSumMemoization(matrix, m, n, 0, i, dp)); // memoization method
        }

        return min;
    }

    public int minFallingPathSumRecursion(int[][] matrix, int m, int n, int row, int col) {
        if (row == m - 1) {
            return matrix[row][col];
        }

        int min = Integer.MAX_VALUE;

        for (int i = -1; i <= 1; i++) {
            if (col + i < 0 || col + i >= n) {
                continue;
            }
            int nextMin = minFallingPathSumRecursion(matrix, m, n, row + 1, col + i);
            min = Math.min(min, nextMin);
        }

        return matrix[row][col] + min;
    }

    public int minFallingPathSumMemoization(int[][] matrix, int m, int n, int row, int col, int[][] dp) {
        if (row == m - 1) {
            return matrix[row][col];
        }
        if (dp[row][col] != 1000000) {
            return dp[row][col];
        }

        int min = Integer.MAX_VALUE;

        for (int i = -1; i <= 1; i++) {
            if (col + i < 0 || col + i >= n) {
                continue;
            }
            int nextMin = minFallingPathSumMemoization(matrix, m, n, row + 1, col + i, dp);
            min = Math.min(min, nextMin);
        }

        return dp[row][col] = matrix[row][col] + min;
    }

    public int minFallingPathSumTabulation(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i];
        }

        for (int row = m - 2; row >= 0; row--) {
            for (int col = 0; col < n; col++) {

                int left = (col != 0) ? dp[row + 1][col - 1] : 1000000;
                int center = dp[row + 1][col];
                int right = (col != n - 1) ? dp[row + 1][col + 1] : 1000000;

                int min = Math.min(left, Math.min(center, right));
                int curr = matrix[row][col];
                dp[row][col] = curr + min;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            min = Math.min(min, dp[0][col]);
        }

        return min;
    }


    public int minFallingPathSumTabulationOptimized(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = matrix[m - 1][i];
        }

        for (int row = m - 2; row >= 0; row--) {
            int[] temp = new int[n];

            for (int col = 0; col < n; col++) {

                int left = (col != 0) ? dp[col - 1] : 1000000;
                int center = dp[col];
                int right = (col != n-1) ? dp[col + 1] : 1000000;

                int min = Math.min(left, Math.min(center, right));
                temp[col] = matrix[row][col] + min;
            }

            dp = temp;
        }

        int min = Integer.MAX_VALUE;

        for (int i : dp) {
            min = Math.min(min, i);
        }

        return min;
    }


    public int minFallingPathSumInPlace(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int row = m - 2; row >= 0; row--) {

            for (int col = 0; col < n; col++) {

                int left = (col != 0) ? matrix[row + 1][col - 1] : 1000000;
                int center = matrix[row + 1][col];
                int right = (col != n-1) ? matrix[row + 1][col + 1] : 1000000;

                int min = Math.min(left, Math.min(center, right));
                matrix[row][col] = matrix[row][col] + min;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i : matrix[0]) {
            min = Math.min(min, i);
        }

        return min;
    }

}
