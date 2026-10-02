package LeetCode.DP.Revision;

public class Unique_Paths_II {

    public static void main(String[] args) {
        Unique_Paths_II classObj = new Unique_Paths_II();
        int res = classObj.uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        });
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // recursive
        // return findUniquePathsRecursive(obstacleGrid, m, n, 0, 0);

        // dp memoization
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        return findUniquePathsMemoization(obstacleGrid, m, n, 0, 0, dp);

        // tabulation
        // return findUniquePathsTabulation(m, n);

        // tabulation optimized
        // return findUniquePathsTabulationOptimized(m, n);
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
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        // right path
        dp[i][j] += findUniquePathsMemoization(obstacleGrid, m, n, i, j + 1, dp);

        // down path
        dp[i][j] += findUniquePathsMemoization(obstacleGrid, m, n, i + 1, j, dp);

        return dp[i][j];
    }


}
