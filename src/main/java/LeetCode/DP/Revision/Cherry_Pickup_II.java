package LeetCode.DP.Revision;

public class Cherry_Pickup_II {

    public static void main(String[] args) {
        Cherry_Pickup_II classObj = new Cherry_Pickup_II();
        int res = classObj.cherryPickup(new int[][]{
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        });
        System.out.println(res);
    }

    public int cherryPickup(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        // recursive
        // return cherryPickupRecursive(grid, 0, 0, n-1, m, n);

        Integer[][][] dp = new Integer[m][n][n];
        // memoization
         return cherryPickupMemoization(grid, 0, 0, n-1, m, n, dp);
    }

    public int cherryPickupRecursive(int[][] grid, int row, int c1, int c2, int m, int n) {
        if (row == m) {
            return 0;
        }
        if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n) {
            return 0;
        }

        int cherries = grid[row][c1];

        if (c1 != c2) {
            cherries += grid[row][c2];
        }
        int max = 0;

        for (int i = -1; i <= 1; i++) {

            int newC1 = c1 + i;

            for (int j = -1; j <= 1; j++) {
                int newC2 = c2 + j;
                max = Math.max(max, cherryPickupRecursive(grid, row+1, newC1, newC2, m, n));
            }
        }

        return cherries + max;
    }

    public int cherryPickupMemoization(int[][] grid, int row, int c1, int c2, int m, int n, Integer[][][] dp) {
        if (row == m) {
            return 0;
        }
        if (c1 < 0 || c1 >= n || c2 < 0 || c2 >= n) {
            return 0;
        }
        if (dp[row][c1][c2] != null) {
            return dp[row][c1][c2];
        }

        int cherries = grid[row][c1];

        if (c1 != c2) {
            cherries += grid[row][c2];
        }
        int max = 0;

        for (int i = -1; i <= 1; i++) {

            int newC1 = c1 + i;

            for (int j = -1; j <= 1; j++) {
                int newC2 = c2 + j;
                max = Math.max(max, cherryPickupMemoization(grid, row+1, newC1, newC2, m, n, dp));
            }
        }

        return dp[row][c1][c2] = cherries + max;
    }




}
