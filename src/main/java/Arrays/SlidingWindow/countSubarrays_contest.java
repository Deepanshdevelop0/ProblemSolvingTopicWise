package Arrays.SlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

public class countSubarrays_contest {

    public static void main(String[] args) {
        countSubarrays_contest classObj = new countSubarrays_contest();
        long res = classObj.countSubarrays(new int[]{1,3,2}, 4);
        System.out.println(res);
    }

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        long totalCount = 0;
        int left = 0;

        // Deques store indices to help us find window min/max in O(1)
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            // Update Max Deque (descending)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(right);

            // Update Min Deque (ascending)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.removeLast();
            }
            minDeque.addLast(right);

            // Shrink window from the left if cost exceeds k
            while (left <= right) {
                long maxVal = nums[maxDeque.peekFirst()];
                long minVal = nums[minDeque.peekFirst()];
                long length = (right - left + 1);

                // Use long to prevent overflow during multiplication
                long currentCost = (maxVal - minVal) * length;

                if (currentCost <= k) {
                    break;
                }

                // Move left pointer and remove out-of-bounds indices from deques
                left++;
                if (maxDeque.peekFirst() < left) maxDeque.removeFirst();
                if (minDeque.peekFirst() < left) minDeque.removeFirst();
            }

            // All subarrays starting from 'left' to 'right' and ending at 'right' are valid
            totalCount += (right - left + 1);
        }

        return totalCount;
    }



}
