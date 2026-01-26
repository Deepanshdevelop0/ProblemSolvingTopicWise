package Arrays.Miscellaneous;

public class MinimumPrefixRemovaltoMakeArrayStrictlyIncreasing {

    public static void main(String[] args) {
        MinimumPrefixRemovaltoMakeArrayStrictlyIncreasing classObj = new MinimumPrefixRemovaltoMakeArrayStrictlyIncreasing();
        int[] nums = new int[]{1,-1,2,3,3,4,5};
        int res = classObj.minimumPrefixLength(nums);
        System.out.println(res);
    }

    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        int i = n-1;
        while (i > 0 && nums[i] > nums[i-1]) {
            i--;
        }

        return i;
    }

}
