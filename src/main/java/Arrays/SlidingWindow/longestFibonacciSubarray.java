package Arrays.SlidingWindow;

public class longestFibonacciSubarray {

    public static void main(String[] args) {

        System.out.println(longestSubarray(new int[]{1,1,1,1,2,3,5,1}));
    }

    public static int longestSubarray(int[] nums) {

        int n = nums.length;
        if (n <= 2) return n;

        int currLen = 2, maxLen = 2;

        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i-1] + nums[i-2]) {
                currLen++;
                maxLen = Math.max(currLen, maxLen);
            }
            else {
                currLen = 2;
            }
        }

        return maxLen;
    }

}
