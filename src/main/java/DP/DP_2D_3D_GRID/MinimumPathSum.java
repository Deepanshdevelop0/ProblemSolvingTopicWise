package DP.DP_2D_3D_GRID;

public class MinimumPathSum {

    public static void main(String[] args) {

        MinimumPathSum minimumPathSum = new MinimumPathSum();

        int[][] grid = new int[][]{{1,3,1}, {1,5,1},{4,2,1}};

        System.out.println(minimumPathSum.minPathSum(grid));

    }

    int[][] memo = new int[201][201];
    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        return solve(grid, 0, 0, m, n);
    }

    public int solve(int[][] grid, int i, int j, int m, int n /*, int[][] dp*/) {

        if (i == m-1 && j == n-1) {
            return grid[i][j];
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int right = 0, down = 0;

        if (j+1 < n) {
            right = solve(grid, i, j+1, m, n);
        }
        if (i+1 < m) {
            down = solve(grid, i+1, j, m, n);
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
