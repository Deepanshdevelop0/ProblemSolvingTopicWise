package LeetCode.DP.Revision;

public class Maximum_Sum_of_Non_Adjacent_Elements {

    public static void main(String[] args) {
        Maximum_Sum_of_Non_Adjacent_Elements classObj = new Maximum_Sum_of_Non_Adjacent_Elements();

        int res = classObj.nonAdjacent(new int[]{2, 1, 4, 9});
        System.out.println(res);

    }

    public int nonAdjacent(int[] nums) {

        int n = nums.length;

        // for recursion
        // return findMaxSum(nums, n, 0);

        // for dp memoization
        // int[] dp = new int[n];
        // return findMaxSumMemoized(nums, nums.length, 0, dp);

        // for tabulation
        // return findMaxSumTabulation(nums, n);

        // for tabulation optimized
         return findMaxSumTabulationOptimized(nums, n);
    }

    public int findMaxSum(int[] nums, int n, int indx) {
        if (indx >= n) {
            return 0;
        }

        int pick = nums[indx] + findMaxSum(nums, n, indx + 2);
        int notPick = findMaxSum(nums, n, indx + 1);

        return Math.max(pick, notPick);
    }

    public int findMaxSumMemoized(int[] nums, int n, int indx, int[] dp) {
        if (indx >= n) {
            return 0;
        }
        if (dp[indx] != 0) {
            return dp[indx];
        }

        int pick = nums[indx] + findMaxSumMemoized(nums, n, indx + 2, dp);
        int notPick = findMaxSumMemoized(nums, n, indx + 1, dp);

        return dp[indx] = Math.max(pick, notPick);
    }

    public int findMaxSumTabulation(int[] nums, int n) {
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return Math.max(dp[0], dp[1]);
    }

    public int findMaxSumTabulationOptimized(int[] nums, int n) {
        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[2];
        dp[1] = nums[n - 1];
        dp[0] = Math.max(nums[n - 1], nums[n - 2]);

        for (int i = n - 3; i >= 0; i--) {
            int temp = Math.max(nums[i] + dp[1], dp[0]);
            dp[1] = dp[0];
            dp[0] = temp;
        }

        return Math.max(dp[0], dp[1]);
    }


}
