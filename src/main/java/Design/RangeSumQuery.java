package Design;

public class RangeSumQuery {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0, 2);
        int param_2 = obj.sumRange(2, 5);
        int param_3 = obj.sumRange(0, 5);

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }

}

class NumArray {

    private long[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = sum = nums[i] + sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return (int) (prefixSum[right]);
        }

        return (int) (prefixSum[right] - prefixSum[left - 1]);
    }
}
