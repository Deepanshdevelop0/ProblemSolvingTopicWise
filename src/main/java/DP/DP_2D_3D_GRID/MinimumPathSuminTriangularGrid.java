package DP.DP_2D_3D_GRID;

import java.util.ArrayList;
import java.util.List;

public class MinimumPathSuminTriangularGrid {


/*

method : Memoization (Top-Down DP)

TC : O(N^2) : N is the number of rows/columns. Each state (i, j) computed once.
SC : O(N^2) : O(N^2) for memoization table + O(N) for recursion stack.

====================================================================

method : Tabulation (Bottom-Up DP) - Space Optimized

TC : O(N^2) : N is the number of rows/columns. Iterating through the triangle elements.
SC : O(N) : O(N) for the 1D dp array.

*/

    public static void main(String[] args) {

        List<List<Integer>> list = List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3));
        List<List<Integer>> list1 = List.of(List.of(-1), List.of(2, 3), List.of(1, -1, -3));

        MinimumPathSuminTriangularGrid minimumPathSuminTriangularGrid = new MinimumPathSuminTriangularGrid();

        int minPathSum = minimumPathSuminTriangularGrid.minimumTotalTabulationApproach(list);

        System.out.println(minPathSum);

    }

    public int minimumTotalMemoizationApproach(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] memo = new int[n+1][n+1];

        return solve(triangle, 0, 0, n, memo);
    }

    public int minimumTotalTabulationApproach(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n];

        // DP ko last row se start karo
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n-1).get(i);
        }

        // Bottom-up DP (current i += min(down dp[j], diag dp[j+1]))
        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }

        return dp[0];
    }

    public int solve(List<List<Integer>> triangle, int i, int j, int n, int[][] memo) {

        if (i == n-1) {
            return triangle.get(i).get(j);
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int down = solve(triangle, i+1, j, n, memo);
        int diag = solve(triangle, i+1, j+1, n, memo);

        memo[i][j] = triangle.get(i).get(j) + Math.min(down, diag);

        return memo[i][j];
    }

}
