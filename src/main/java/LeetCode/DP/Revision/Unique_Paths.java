package LeetCode.DP.Revision;

import java.util.Arrays;

public class Unique_Paths {

    public static void main(String[] args) {
        Unique_Paths classObj = new Unique_Paths();
        int res = classObj.uniquePaths(3, 7);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {

        // recursive
        //  return findUniquePathsRecursive(0, 0, m, n);

        // dp memoization
        // int[][] dp = new int[m][n];
        // dp[m-1][n-1] = 1;
        // return findUniquePathsMemoization(dp, 0, 0, m, n);

        // tabulation
        // return findUniquePathsTabulation(m, n);

        // tabulation optimized
        return findUniquePathsTabulationOptimized(m, n);
    }

    public int findUniquePathsRecursive(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }

        int pathCount = 0;

        // right path
        pathCount += findUniquePathsRecursive(i, j + 1, m, n);

        // down path
        pathCount += findUniquePathsRecursive(i + 1, j, m, n);

        return pathCount;
    }

    public int findUniquePathsMemoization(int[][] dp, int i, int j, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int pathCount = 0;

        // right path
        pathCount += findUniquePathsMemoization(dp, i, j+1, m, n);

        // down path
        pathCount += findUniquePathsMemoization(dp, i+1, j, m, n);

        return dp[i][j] = pathCount;
    }

    public int findUniquePathsTabulation(int m, int n) {

        int[][] dp = new int[m][n];

        // fill bottom row with 1
        for (int i = 0; i < n; i++) {
            dp[m-1][i] = 1;
        }
        // fill end col with 1
        for (int i = 0; i < m; i++) {
            dp[i][n-1] = 1;
        }

        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }

    public int findUniquePathsTabulationOptimized(int m, int n) {

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // By using a single 1D array of size n and updating it in place (dp[j] += dp[j+1]),
        // dp[j] acts as the "cell below" (from the previous loop iteration),
        // and dp[j+1] acts as the "cell to the right" (just updated in the current iteration).
        // that's why we used it as just right of current index
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[j] += dp[j+1];
            }
        }

        return dp[0];
    }

}
