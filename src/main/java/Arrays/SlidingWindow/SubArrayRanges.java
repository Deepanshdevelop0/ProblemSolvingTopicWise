package Arrays.SlidingWindow;

public class SubArrayRanges {

    /* 2104. Sum of Subarray Ranges*/

    public static void main(String[] args) {
        SubArrayRanges classObj = new SubArrayRanges();
        System.out.println(classObj.subArrayRanges(new int[]{1,2,3}));
        System.out.println(classObj.subArrayRanges(new int[]{4,-2,-3,4,1}));
    }

    public long subArrayRanges(int[] nums) {
        long sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int largest = nums[i];
            int smallest = nums[i];
            for (int j = i; j < n; j++) {
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);
                sum += (largest - smallest);
            }
        }

        return sum;
    }

}
