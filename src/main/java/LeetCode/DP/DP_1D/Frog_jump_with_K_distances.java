package LeetCode.DP.DP_1D;


import java.util.Arrays;

public class Frog_jump_with_K_distances {

    public static void main(String[] args) {

        Frog_jump_with_K_distances frogJumpWithKDistances = new Frog_jump_with_K_distances();

        int[] heights = new int[]{10, 5, 20, 0, 15};
        int[] heights1 = new int[]{15, 4, 1, 14, 15};
//        System.out.println(frogJumpWithKDistances.frogJump(heights, 2));
//        System.out.println(frogJumpWithKDistances.frogJump(heights1, 3));

        // tabulation test
        System.out.println(frogJumpWithKDistances.frogJumpTabulation(heights1, 3));

    }

    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

//        return jumpRecursive(heights, k, heights.length, 0);
        return jumpRecursiveMemoized(heights, k, heights.length, 0, dp);
    }

    public int jumpRecursive(int[] heights, int k, int n, int indx) {
        if (indx == n - 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k && indx + i < n; i++) {
            int next = jumpRecursive(heights, k, n, indx + i);
            int diff = Math.abs(heights[indx] - heights[indx + i]);
            min = Math.min(min, diff + next);
        }

        return min;
    }


    public int jumpRecursiveMemoized(int[] heights, int k, int n, int indx, int[] dp) {

        if (dp[indx] != -1) {
            return dp[indx];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= k && i + indx < n; i++) {
            int next = jumpRecursiveMemoized(heights, k, n, indx + i, dp);
            int diff = Math.abs(heights[indx] - heights[indx + i]);
            min = Math.min(min, next + diff);
        }

        return dp[indx] = min;
    }

    public int frogJumpTabulation(int[] heights, int k) {

        int n = heights.length;

        int[] dp = new int[n];
        dp[n-1] = 0;

        for (int indx = n - 2; indx >= 0; indx--) {

            int min = Integer.MAX_VALUE;

            for (int i = 1; i <= k && i + indx < n; i++) {
                int next = dp[indx + i];
                int diff = Math.abs(heights[indx] - heights[indx + i]);
                min = Math.min(min, next + diff);
            }

            dp[indx] = min;
        }


        return dp[0];
    }
    public int frogJumpTabulationOptimized(int[] heights, int k) {

        int n = heights.length;

        int[] dp = new int[n];
        dp[n-1] = 0;

        for (int indx = n - 2; indx >= 0; indx--) {

            int min = Integer.MAX_VALUE;

            for (int i = 1; i <= k && i + indx < n; i++) {
                int next = dp[indx + i];
                int diff = Math.abs(heights[indx] - heights[indx + i]);
                min = Math.min(min, next + diff);
            }

            dp[indx] = min;
        }


        return dp[0];
    }

}
