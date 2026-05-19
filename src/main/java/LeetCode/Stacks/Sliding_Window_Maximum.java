package LeetCode.Stacks;

public class Sliding_Window_Maximum {

    public static void main(String[] args) {
        Sliding_Window_Maximum classObj = new Sliding_Window_Maximum();
        int[] res = classObj.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

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

}
