package LeetCode.Arrays.Miscellaneous;

public class Minimum_Swaps_to_Move_Zeros_to_End {


    public static void main(String[] args) {

        Minimum_Swaps_to_Move_Zeros_to_End classObj = new Minimum_Swaps_to_Move_Zeros_to_End();

        int res = classObj.minimumSwapsBrute(new int[]{0, 1, 0, 2});
        System.out.println(res);
    }


    public int minimumSwaps(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ops = 0;
        boolean hasZeros = true;

        while (hasZeros) {

            while (low < high && nums[low] > 0) {
                low++;
            }

            while (low < high && nums[high] < 1) {
                high--;
            }

            if (low >= high) {
                break;
            }

            if (nums[low] == 0 && nums[high] > 0) {
                ops++;
                low++;
                high--;
            }
        }

        return ops;
    }

    public int minimumSwapsBrute(int[] nums) {

        int left = 0, right = nums.length - 1;
        int ops = 0;

        while (left < right) {

            if (nums[right] < 1) {
                right--;
                continue;
            } else if (nums[left] == 0) {
                ops++;
                right--;
            }
            left++;
        }

        return ops;
    }

    public int minimumSwapsOptimal(int[] nums) {
        int zeros = 0;

        for (int i : nums) {
            if (i == 0) zeros++;
        }

        int res = 0;
        for (int i = 0; i < nums.length - zeros; i++) {
            if (nums[i] == 0) {
                res++;
            }
        }

        return res;
    }

}
