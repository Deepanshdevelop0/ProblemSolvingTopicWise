package LeetCode.DP.DP_1D;

import java.util.Arrays;

public class House_Robber {

    public static void main(String[] args) {

        House_Robber classObject = new House_Robber();

        int[] nums  = new int[]{1,2,3,1};
        int[] nums1  = new int[]{2,7,9,3,1};
        int[] worstEdgeCase  = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//        System.out.println(classObject.rob(nums));
//        System.out.println(classObject.rob(nums1));
        System.out.println(classObject.rob(worstEdgeCase));

    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        return robMax(nums, 0, n, dp);
    }

    public int robMax(int[] nums, int indx, int n, int[] dp) {
        if (indx >= n) return 0;

        if (dp[indx] != -1) return dp[indx];

        int pick = nums[indx] + robMax(nums, indx+2, n , dp);
        int notPick = robMax(nums, indx+1, n , dp);

        return dp[indx] = Math.max(pick, notPick);
    }


}
