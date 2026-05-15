package LeetCode.Arrays.TwoPointers;

import java.util.*;

public class Two_Sum {

    public static void main(String[] args) {
        Two_Sum classObj = new Two_Sum();
        for (var i : classObj.twoSumOptimal(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }
    }

    public int[] twoSumBruteForce(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    public int[] twoSumOptimal(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return nums;
    }


    // Note: This only works if you need the VALUES.
    // If you need the original INDICES, you'd need to store index-value pairs before sorting.
    public int[] twoSumOptimalChangedProblemRequirement(int[] nums, int target) {
        int n = nums.length;

        // Note: This only works if you need the VALUES.
        Arrays.sort(nums);

        int left = 0, right = n-1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) return new int[]{nums[left], nums[right]};
            else if (sum < target) left++;
            else right--;
        }

        return new int[]{-1, -1};
    }

}
