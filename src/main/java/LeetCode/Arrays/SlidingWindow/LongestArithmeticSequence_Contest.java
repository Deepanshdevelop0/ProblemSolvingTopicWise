package LeetCode.Arrays.SlidingWindow;

import java.util.*;

public class LongestArithmeticSequence_Contest {

    public static void main(String[] args) {
        LongestArithmeticSequence_Contest classObj = new LongestArithmeticSequence_Contest();
        int res = classObj.longestArithmetic(new int[]{9, 7, 5, 10, 1});
        System.out.println(res);
    }

    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        // left[i][d] = length of arithmetic subarray ending at i with difference d
        Map<Integer, Integer>[] left = new HashMap[n];
        // right[i][d] = length of arithmetic subarray starting at i with difference d
        Map<Integer, Integer>[] right = new HashMap[n];

        for (int i = 0; i < n; i++) {
            left[i] = new HashMap<>();
            right[i] = new HashMap<>();
        }

        int maxLen = 2; // Minimum possible is 2 (any two elements)

        // Fill left-to-right
        for (int i = 1; i < n; i++) {
            int d = nums[i] - nums[i - 1];
            int len = left[i - 1].getOrDefault(d, 1) + 1;
            left[i].put(d, len);
            maxLen = Math.max(maxLen, len + (i < n - 1 ? 1 : 0)); // +1 for potentially changing next
        }

        // Fill right-to-left
        for (int i = n - 2; i >= 0; i--) {
            int d = nums[i + 1] - nums[i];
            int len = right[i + 1].getOrDefault(d, 1) + 1;
            right[i].put(d, len);
            maxLen = Math.max(maxLen, len + (i > 0 ? 1 : 0)); // +1 for potentially changing previous
        }

        // Check the "Bridge" case: changing nums[i] to connect two sequences
        for (int i = 1; i < n - 1; i++) {
            // Check if nums[i-1] and nums[i+1] can be connected with a middle element
            // Condition: (nums[i+1] - nums[i-1]) must be even for an integer bridge
            int totalDiff = nums[i + 1] - nums[i - 1];
            if (totalDiff % 2 == 0) {
                int d = totalDiff / 2;
                int lenL = left[i - 1].getOrDefault(d, 1);
                int lenR = right[i + 1].getOrDefault(d, 1);
                maxLen = Math.max(maxLen, lenL + 1 + lenR);
            }
        }

        return maxLen;
    }
}
