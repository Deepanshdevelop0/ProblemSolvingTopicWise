package DP.DP_2D_3D_GRID;

public class MinimumPathSum {

    public static void main(String[] args) {

        MinimumPathSum minimumPathSum = new MinimumPathSum();

        int[][] grid = new int[][]{{1,3,1}, {1,5,1},{4,2,1}};

        System.out.println(minimumPathSum.minPathSum(grid));

    }

    public int minPathSum(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        return solve(grid, 0, 0, m, n);
    }

    public int solve(int[][] grid, int i, int j, int m, int n /*, int[][] dp*/) {


        int right = 1001, down = 1001;

        if (j+1 < n) {
            right = solve(grid, i, j+1, m, n);
        }
        if (i+1 < m) {
            down = solve(grid, i+1, j, m, n);
        }

        return grid[i][j] + Math.min(right, down);
    }
}
