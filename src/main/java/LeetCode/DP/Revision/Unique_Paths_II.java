package LeetCode.DP.Revision;

import java.util.Arrays;

public class Unique_Paths_II {

    public static void main(String[] args) {
        Unique_Paths_II classObj = new Unique_Paths_II();
        int res = classObj.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
                /*{0, 1},
                {0, 0}*/
        });
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // recursive
        // return findUniquePathsRecursive(obstacleGrid, m, n, 0, 0);

        // dp memoization
        // int[][] dp = new int[m][n];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // dp[m - 1][n - 1] = 1;
        // return findUniquePathsMemoization(obstacleGrid, m, n, 0, 0, dp);

        // tabulation
        // return findUniquePathsTabulation(obstacleGrid, m, n);

        // tabulation optimized
         return findUniquePathsTabulationOptimized(obstacleGrid, m, n);
    }

    public int findUniquePathsRecursive(int[][] obstacleGrid, int m, int n, int i, int j) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int pathCount = 0;

        // right path
        pathCount += findUniquePathsRecursive(obstacleGrid, m, n, i, j + 1);

        // down path
        pathCount += findUniquePathsRecursive(obstacleGrid, m, n, i + 1, j);

        return pathCount;
    }

    public int findUniquePathsMemoization(int[][] obstacleGrid, int m, int n, int i, int j, int[][] dp) {
        if (i >= m || j >= n) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // right path
        dp[i][j] = findUniquePathsMemoization(obstacleGrid, m, n, i, j + 1, dp);

        // down path
        dp[i][j] += findUniquePathsMemoization(obstacleGrid, m, n, i + 1, j, dp);

        return dp[i][j];
    }

    public int findUniquePathsTabulation(int[][] obstacleGrid, int m, int n) {

        int[][] dp = new int[m][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 0) {
                dp[m - 1][i] = 1;
            } else {
                break;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[0][0];
    }

    public int findUniquePathsTabulationOptimized(int[][] obstacleGrid, int m, int n) {

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 0) {
                dp[i] = 1;
            } else {
                break;
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j + 1];
                }
            }
        }

        return dp[0];
    }


}
