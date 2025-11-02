package Arrays.Miscellaneous;

import java.util.Arrays;

public class MaximumProductofThreeElementsAfterOneReplacement {

    public static int[] findMaxTwoAbsOptimal(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements.");
        }

        int n = nums.length;

        Arrays.sort(nums);

        int num0 = nums[0];
        int num1 = nums[1];
        int numN2 = nums[n - 2];
        int numN1 = nums[n - 1];

        Integer[] candidates = {num0, num1, numN2, numN1};

        Arrays.sort(candidates, (a,b) -> Integer.compare(Math.abs(b), Math.abs(a)));

        return new int[]{candidates[0], candidates[1]};
    }


    public static long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int[] arr = findMaxTwoAbsOptimal(nums);
        long product = (long) arr[0] * arr[1];

        return Math.max(product * 100000, product * -100000);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,-0,-7};
        int[] nums1 = new int[]{-100000,-100000,-100000};
        System.out.println(maxProduct(nums));
    }

}
