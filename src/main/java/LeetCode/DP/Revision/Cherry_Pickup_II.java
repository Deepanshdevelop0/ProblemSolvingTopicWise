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
        return cherryPickupRecursive(grid, 0, 0, n - 1, m, n);
    }

    public int cherryPickupRecursive(int[][] grid, int row, int c1, int c2, int m, int n) {
        if (c1 < 0 || c2 < 0 || c1 >= n || c2 >= n) {
            return 0;
        }
        if (row == m) {
            return 0;
        }

        int cherry = grid[row][c1];
        // if both robots are not on same index
        if (c1 != c2) {
            cherry += grid[row][c2];
        }

        int max = 0;

        for (int i = -1; i < 2; i++) {

            for (int j = -1; j < 2; j++) {
                int new_c1 = c1 + i;
                int new_c2 = c2 + j;
                max = Math.max(max, cherryPickupRecursive(grid, row+1, new_c1, new_c2, m, n));
            }
        }

        return cherry + max;
    }


}
