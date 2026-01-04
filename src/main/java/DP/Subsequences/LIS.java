package DP.Subsequences;

public class LIS {

    public static void main(String[] args) {

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LIS classObj = new LIS();

        System.out.println(classObj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        return lengthOfLisRecursive(nums, n, 0, -1);
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

}
