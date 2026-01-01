package DP.Subsequences;

public class LIS {

    public static void main(String[] args) {

        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        LIS classObj = new LIS();

        System.out.println(classObj.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int max = 0;

        for (int i = 0; i < n; i++) {
            int tempMax = 1, temp = nums[i];

            for (int j = i + 1; j < n; j++) {
                if (nums[j] > temp) {
                    tempMax++;
                    temp = nums[j];
                }
            }

            max = Math.max(max, tempMax);
        }

        return max;
    }

}
