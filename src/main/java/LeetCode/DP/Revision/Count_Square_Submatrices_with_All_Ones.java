package LeetCode.DP.Revision;

public class Count_Square_Submatrices_with_All_Ones {

    public static void main(String[] args) {
        Count_Square_Submatrices_with_All_Ones classObj = new Count_Square_Submatrices_with_All_Ones();
//        int res = classObj.countSquaresTabulationOptimized(new int[][]{
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {0, 1, 1, 1}
//        });

        int res = classObj.countSquaresTabulationOptimized(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        });

        System.out.println(res);
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int totalSquares = 0;

        // for memoization
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            totalSquares += matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSquares += countSquaresMemoization(matrix, i, j, dp);
            }
        }

        return totalSquares;
    }

    /* 1. Brute Force Recursion Approach */
    public int countSquaresRecursive(int[][] matrix, int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }

        if (matrix[row][col] != 1) {
            return 0;
        }

        int left = countSquaresRecursive(matrix, row, col - 1);
        int up = countSquaresRecursive(matrix, row - 1, col);
        int diagonal = countSquaresRecursive(matrix, row - 1, col - 1);

        int min = Math.min(left, Math.min(up, diagonal));

        return 1 + min;
    }

    /* 2. Memoization Approach */
    public int countSquaresMemoization(int[][] matrix, int row, int col, int[][] dp) {
        if (row < 0 || col < 0) {
            return 0;
        }

        if (matrix[row][col] != 1) {
            return 0;
        }

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int left = countSquaresMemoization(matrix, row, col - 1, dp);
        int up = countSquaresMemoization(matrix, row - 1, col, dp);
        int diagonal = countSquaresMemoization(matrix, row - 1, col - 1, dp);

        int min = Math.min(left, Math.min(up, diagonal));

        return dp[row][col] = 1 + min;
    }

    /* 3. Tabulation Approach */
    public int countSquaresTabulation(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                int left = dp[i][j - 1];
                int up = dp[i - 1][j];
                int diagonal = dp[i - 1][j - 1];

                int min = Math.min(left, Math.min(up, diagonal));
                dp[i][j] = 1 + min;
            }
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += dp[i][j];
            }
        }

        return sum;
    }

    /* 4. Tabulation Space Optimized Approach */
    public int countSquaresTabulationOptimized(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] dp = new int[n];
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
            totalSum += dp[i];
        }


        for (int i = 1; i < m; i++) {

            int[] temp = new int[n];
            temp[0] += matrix[i][0];
            totalSum += temp[0];

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 1) {
                    continue;
                }
                int left = temp[j-1];
                int up = dp[j];
                int diagonal = dp[j-1];

                int min = Math.min(left, Math.min(up, diagonal));
                temp[j] = 1 + min;
                totalSum += temp[j];
            }

            dp = temp;
        }

        return totalSum;
    }


    /* 4. Tabulation Space Optimized Approach */
    public int countSquaresTabulationInPlace(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int left = matrix[i][j - 1];
                int up = matrix[i - 1][j];
                int diagonal = matrix[i - 1][j - 1];

                int min = Math.min(left, Math.min(up, diagonal));
                matrix[i][j] = min + 1;
            }
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

}
