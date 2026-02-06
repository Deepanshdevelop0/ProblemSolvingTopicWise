package BinarySearch;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {

    public static void main(String[] args) {
        MinimumRemovalsToBalanceArray classObj = new MinimumRemovalsToBalanceArray();
        int res = classObj.minRemoval(new int[]{1, 6, 2, 9}, 3); // 1, 2, 6, 9
        System.out.println(res);
    }

    public int minRemoval(int[] nums, int k) {

        int n = nums.length;
        if (n <= 1) return 0;
        Arrays.sort(nums);

        int maxKeep = 0;

        for (int i = 0; i < n; i++) {
            long target = (long) nums[i] * k;

            int j = binarySearchTarget(i, n-1, nums, target);

            int currWindow = j - i + 1;
            maxKeep = Math.max(maxKeep, currWindow);
        }

        return n - maxKeep;
    }

    public int binarySearchTarget(int start, int end, int[] nums, long target) {

        int left = start, right = end;
        int ans = start;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

}
