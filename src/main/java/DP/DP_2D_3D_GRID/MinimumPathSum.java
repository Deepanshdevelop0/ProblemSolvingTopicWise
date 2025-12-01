package DP.DP_2D_3D_GRID;

import java.util.Arrays;

public class MinimumPathSum {


/*

method : Tabulation (Bottom-Up DP) - Space Optimized
TC : O(M*N) : M rows, N columns. Each cell is processed once.
SC : O(N) : O(N) for the 1D dp array (auxiliary space).

====================================================================

method : Memoization (Top-Down DP)

TC : O(M*N) : M rows, N columns. Each state (i, j) computed once.
SC : O(M*N) : O(M*N) for memoization table + O(M+N) for recursion stack.

*/

    public static void main(String[] args) {

        MinimumPathSum minimumPathSum = new MinimumPathSum();

        int[][] grid = new int[][]{{1,3,1}, {1,5,1},{4,2,1}};
        int[][] grid1 = new int[][]{{1,2,3}, {4,5,6}};

        System.out.println(minimumPathSum.minPathSum(grid1));

    }

    public int minPathSum(int[][] grid) {

        // grid has equal length rows
        int m = grid.length, n = grid[0].length;

        int[] dp = new int[n+1];

        // DP ko last row or col se start karo as [4+2+1, 2+1, 1]
        for (int i = n-1; i >= 0; i--) {
            dp[i] = grid[m-1][i] + dp[i+1];
        }

        // now we have path sum of last row, similarly process for each row (m-2 -> 0)
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                // Check boundary for the 'right' move, dp[j] holds the path sum from 'down' (i+1, j)
                // dp[j+1] holds the path sum from 'right' (i, j+1)
                int min = (j == n-1) ? dp[j] : Math.min(dp[j], dp[j+1]);
                dp[j] = grid[i][j] + min;
            }
        }

        return dp[0];
    }


    public int minPathSumMemoization(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        int[][] memo = new int[201][201];

        return solve(grid, 0, 0, m, n, memo);
    }

    public int solve(int[][] grid, int i, int j, int m, int n, int[][] memo) {

        if (i == m-1 && j == n-1) {
            return grid[i][j];
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int right = 0, down = 0;

        if (j+1 < n) {
            right = solve(grid, i, j+1, m, n, memo);
        }
        if (i+1 < m) {
            down = solve(grid, i+1, j, m, n, memo);
        }

        memo[i][j] = grid[i][j] + minOf(i, j, m, n, right, down);

        return memo[i][j];
    }

    public int minOf(int i, int j, int m, int n, int right, int down) {

        if (i+1 < m && j+1 < n) {
            return Math.min(right, down);
        }
        else if (i+1 < m) {
            return down;
        }
        else if (j+1 < n) {
            return right;
        }

        return 0;
    }



}
