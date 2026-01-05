package DP.Subsequences;

import java.util.Arrays;

public class LIS {


/*

1. method : Recursion (Brute Force)

TC : O(2^N)

i. At each index, you make two recursive calls (take, notTake)
ii. This creates a binary recursion tree with a depth of n

SC : O(N)

i. The space is determined by the recursion stack (depth of tree would be n)

====================================================================

2. method : Memoization (Top-Down DP)

TC : O(N^2)

i. There are two changing variables in the state: indx (ranges from 0 to n) and prevIndx (ranges from -1 to n-1). The total number of unique states is n x (n+1).
   Since each state is calculated only once and takes O(1) time to process, the total time is O(n^2).
 
SC : O(N^2) + O(N)

i. To store 2D Dp Array
ii. Recursive stack space

====================================================================

method : Tabulation (Bottom-Up DP)

TC : O(N^2)
SC : O(N)
*
*/

    public static void main(String[] args) {

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LIS classObj = new LIS();

        System.out.println(classObj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n+1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return lengthOfLisMemoized(nums, n, 0, -1, dp);
    }


    public int lengthOfLisRecursive(int[] nums, int n, int indx, int prevIndx) {

        if (indx == n) {
            return 0;
        }

        int take = 0;

        if (prevIndx == -1 || nums[prevIndx] < nums[indx]) {
            take = 1 + lengthOfLisRecursive(nums, n, indx+1, indx);
        }

        int notTake = lengthOfLisRecursive(nums, n, indx+1, prevIndx);

        return Math.max(take, notTake);
    }

    public int lengthOfLisMemoized(int[] nums, int n, int indx, int prevIndx, int[][] dp) {

        if (indx == n) {
            return 0;
        }

        if (dp[indx][prevIndx+1] != -1)
            return dp[indx][prevIndx+1];

        int take = 0;

        if (prevIndx == -1 || nums[prevIndx] < nums[indx]) {
            take = 1 + lengthOfLisMemoized(nums, n, indx+1, indx, dp);
        }

        int notTake = lengthOfLisMemoized(nums, n, indx+1, prevIndx, dp);

        return dp[indx][prevIndx + 1] = Math.max(take, notTake);
    }


}
