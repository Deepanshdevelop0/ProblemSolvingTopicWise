package Greedy.Problems;

import java.util.HashSet;
import java.util.Set;

public class MinimumOpstoReachTargetArray {

    public static void main(String[] args) {
        MinimumOpstoReachTargetArray solver = new MinimumOpstoReachTargetArray();

        // Example 1
        System.out.println("Example 1: " + solver.minOperations(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        // Output: 2

        // Example 2
        System.out.println("Example 2: " + solver.minOperations(new int[]{4, 1, 4}, new int[]{5, 1, 4}));
        // Output: 1

        // Example 3
        System.out.println("Example 3: " + solver.minOperations(new int[]{7, 3, 7}, new int[]{5, 5, 9}));
        // Output: 2
    }

    public int minOperations(int[] nums, int[] target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target[i]) {
                set.add(nums[i]);
            }
        }

        return set.size();
    }


}
