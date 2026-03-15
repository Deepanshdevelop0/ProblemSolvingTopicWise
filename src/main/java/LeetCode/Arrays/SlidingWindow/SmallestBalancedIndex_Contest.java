package LeetCode.Arrays.SlidingWindow;

public class SmallestBalancedIndex_Contest {

    public static void main(String[] args) {
        SmallestBalancedIndex_Contest classObj = new SmallestBalancedIndex_Contest();
        classObj.smallestBalancedIndex(new int[]{});
    }


    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];

        long sum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i] = sum;
            sum += nums[i];
        }

        int indx = -1;
        long currProd = 1;
        boolean overflowed = false;
        long maxLimit = 200_000_000_000_000L;

        for (int i = n - 1; i >= 0; i--) {
            if (!overflowed && prefixSum[i] == currProd) {
                indx = i;
            }

            if (!overflowed) {
                if (currProd > maxLimit / nums[i]) {
                    overflowed = true;
                } else {
                    currProd *= nums[i];
                }
            }
        }

        return indx;
    }
}
