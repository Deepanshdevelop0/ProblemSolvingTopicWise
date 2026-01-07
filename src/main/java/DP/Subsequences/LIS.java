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

3. method : Tabulation (Bottom-Up DP)

TC : O(N^2)

i. Two nested loops: the outer loop runs from n-1 to 0, and the inner loop runs from indx-1 to -1.
ii. Each cell in the 2D DP table is filled exactly once using O(1) operations.

SC : O(N^2)

i. We use a 2D array `dp[n+1][n+1]` to store results of all subproblems.
ii. No recursive stack space is used, unlike Memoization.

====================================================================

4. method : Space Optimized Tabulation (Bottom-Up DP)

TC : O(N^2)

i. Same nested loop structure as standard Tabulation.

SC : O(N)

i. Instead of an entire 2D matrix, we only maintain two rows: `nextDp` (representing the results of the next index)
   and `currDp` (the current index being calculated).
ii. Pointer swapping is used to transition between states, reducing space from O(N^2) to 2 * O(N).

*/

    public static void main(String[] args) {

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LIS classObj = new LIS();

        System.out.println(classObj.lengthOfLIS_TabulationSpaceOptimized(nums, nums.length));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return lengthOfLISMemoized(nums, n, 0, -1, dp);
    }


    public int lengthOfLISRecursive(int[] nums, int n, int indx, int prevIndx) {

        if (indx == n) {
            return 0;
        }

        int take = 0;

        if (prevIndx == -1 || nums[prevIndx] < nums[indx]) {
            take = 1 + lengthOfLISRecursive(nums, n, indx + 1, indx);
        }

        int notTake = lengthOfLISRecursive(nums, n, indx + 1, prevIndx);

        return Math.max(take, notTake);
    }

    public int lengthOfLISMemoized(int[] nums, int n, int indx, int prevIndx, int[][] dp) {

        if (indx == n) {
            return 0;
        }

        if (dp[indx][prevIndx + 1] != -1)
            return dp[indx][prevIndx + 1];

        int take = 0;

        if (prevIndx == -1 || nums[prevIndx] < nums[indx]) {
            take = 1 + lengthOfLISMemoized(nums, n, indx + 1, indx, dp);
        }

        int notTake = lengthOfLISMemoized(nums, n, indx + 1, prevIndx, dp);

        return dp[indx][prevIndx + 1] = Math.max(take, notTake);
    }

    public int lengthOfLIS_Tabulation(int[] nums, int n) {

        int[][] dp = new int[n + 1][n + 1];

        for (int indx = n - 1; indx >= 0; indx--) {
            for (int prevIndx = indx - 1; prevIndx >= -1; prevIndx--) {
                int len = 0 + dp[indx + 1][prevIndx + 1];
                if (prevIndx == -1 || nums[indx] > nums[prevIndx]) {
                    len = Math.max(len, 1 + dp[indx + 1][indx + 1]);
                }
                dp[indx][prevIndx + 1] = len;

            }
        }

        return dp[0][0];
    }

    public int lengthOfLIS_TabulationSpaceOptimized(int[] nums, int n) {

        int[] currDp = new int[n + 1];
        int[] nextDp = new int[n + 1];

        for (int indx = n - 1; indx >= 0; indx--) {
            for (int prevIndx = indx - 1; prevIndx >= -1; prevIndx--) {

                // OPTION 1: Not Take
                int len = 0 + nextDp[prevIndx + 1];

                // OPTION 2: Take
                if (prevIndx == -1 || nums[indx] > nums[prevIndx]) {
                    len = Math.max(len, 1 + nextDp[indx + 1]);
                }

                currDp[prevIndx + 1] = len;
            }

            // SWAP REFERENCES: O(1) complexity
            // No copying, no new memory allocation
            int[] temp = nextDp;
            nextDp = currDp;
            currDp = temp;
        }

        return nextDp[0];
    }

}
