package LeetCode.Arrays.Miscellaneous;

public class Smallest_Stable_Index_II_contest {

    public static void main(String[] args) {
        Smallest_Stable_Index_II_contest classObj = new Smallest_Stable_Index_II_contest();
        System.out.println(classObj.firstStableIndex(new int[]{5,0,1,4}, 3));
    }


    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] maxArr = new int[n];
        int[] minArr = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            maxArr[i] = max;
            minArr[n - 1 - i] = min;
        }

        for (int i = 0; i < n; i++) {
            if (maxArr[i] - minArr[i] <= k) return i;
        }

        return -1;
    }
}
