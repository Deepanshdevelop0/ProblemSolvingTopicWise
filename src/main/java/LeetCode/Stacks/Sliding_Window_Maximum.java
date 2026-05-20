package LeetCode.Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Sliding_Window_Maximum {

    public static void main(String[] args) {
        Sliding_Window_Maximum classObj = new Sliding_Window_Maximum();
        int[] res = classObj.maxSlidingWindowOptimal(new int[]{1,3,-1,-3,5,3,6,7}, 3);

        for (var i : res) {
            System.out.print(i + ", ");
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int indx = 0;

        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = i; j < i+k; j++) {
                max = Math.max(max, nums[j]);
            }

            result[indx++] = max;
        }

        return result;
    }


    public int[] maxSlidingWindowOptimal(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int j = 0;

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // clear the front first
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // then clear the last
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            dq.addLast(i);

            if (i >= k-1)
                result[j++] = nums[dq.peekFirst()];
        }

        return result;
    }


}
