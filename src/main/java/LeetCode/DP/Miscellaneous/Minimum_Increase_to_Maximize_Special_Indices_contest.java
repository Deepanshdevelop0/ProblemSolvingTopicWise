package LeetCode.DP.Miscellaneous;

import java.util.Arrays;

public class Minimum_Increase_to_Maximize_Special_Indices_contest {

    public static void main(String[] args) {
        Minimum_Increase_to_Maximize_Special_Indices_contest classObj = new Minimum_Increase_to_Maximize_Special_Indices_contest();
        System.out.println(classObj.minIncrease(new int[]{1, 2, 2}));
        System.out.println(classObj.minIncrease(new int[]{2,1,1,3}));
        System.out.println(classObj.minIncrease(new int[]{5,2,1,4,3}));
        System.out.println(classObj.minIncrease(new int[]{21, 12, 18, 19}));
    }

    public long minIncrease(int[] nums) {
        int n = nums.length;

        int maxPeaks = (n - 1) / 2;

        long[][] dp = new long[n][maxPeaks + 1];

        for (long[] row : dp) Arrays.fill(row, Long.MAX_VALUE / 2);

        for (int i = 0; i < n; i++) dp[i][0] = 0;

        for (int j = 1; j <= maxPeaks; j++) {
            for (int i = 1; i < n - 1; i++) {
                long cost = Math.max(0, Math.max(nums[i-1], nums[i+1]) + 1 - nums[i]);

                long take = cost + (i >= 2 ? dp[i-2][j-1] : 0);

                long nottake = dp[i-1][j];

                dp[i][j] = Math.min(take, nottake);
            }
        }

        return dp[n - 2][maxPeaks];
    }
}
