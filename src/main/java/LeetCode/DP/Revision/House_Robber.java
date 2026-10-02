package LeetCode.DP.Revision;

import java.util.Arrays;

public class House_Robber {

    public static void main(String[] args) {

        House_Robber classObject = new House_Robber();

        int[] nums  = new int[]{1,2,3,1};
        int[] nums1  = new int[]{2,7,9,3,1};
        int[] worstEdgeCase  = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        System.out.println(classObject.rob(nums));
//        System.out.println(classObject.rob(nums1));
        System.out.println(classObject.rob(nums));

    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // for recursion
        return robMaxRecursion(nums, n, 0);

        // for dp memoization
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return robMaxMemoized(nums, n, 0, dp);

        // for tabulation
        // return robMaxTabulation(nums, n);

        // for tabulation optimized
        // return robMaxTabulationOptimized(nums, n);

    }

    public int robMaxRecursion(int[] nums, int n, int indx) {
        if (indx >= n) {
            return 0;
        }

        int pick = nums[indx] + robMaxRecursion(nums, n, indx+2);
        int notPick = robMaxRecursion(nums, n, indx+1);

        return Math.max(pick, notPick);
    }

    public int robMaxMemoized(int[] nums, int n, int indx, int[] dp) {
        if (indx >= n) {
            return 0;
        }
        if (dp[indx] != -1) {
            return dp[indx];
        }

        int pick = nums[indx] + robMaxMemoized(nums, n, indx+2, dp);
        int notPick = robMaxMemoized(nums, n, indx+1, dp);

        return dp[indx] = Math.max(pick, notPick);
    }

    public int robMaxTabulation(int[] nums, int n) {

        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        dp[n-2] = Math.max(nums[n-2], nums[n-1]);

        for (int i = n-3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }

        return Math.max(dp[0], dp[1]);
    }

    public int robMaxTabulationOptimized(int[] nums, int n) {

        int[] dp = new int[2];
        dp[1] = nums[n-1];
        dp[0] = Math.max(nums[n-1], nums[n-2]);

        for (int i = n-3; i >= 0; i--) {
            int temp = Math.max(nums[i] + dp[1], dp[0]);
            dp[1] = dp[0];
            dp[0] = temp;
        }

        return Math.max(dp[0], dp[1]);
    }

}
