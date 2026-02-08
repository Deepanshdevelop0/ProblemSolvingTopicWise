package Arrays.Miscellaneous;

public class countDominantIndices_Contest {

    public static void main(String[] args) {
        countDominantIndices_Contest classObj = new countDominantIndices_Contest();
        int res = classObj.dominantIndices(new int[]{5,4,3});
        System.out.println(res);

    }

    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int[] presum = new int[n];

        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] =  nums[i] + presum[i-1];
        }

        int count = 0;

        for (int i = 0; i < n-1; i++) {
            int sum = (presum[n-1] - presum[i]);
            double avg = (double) sum / (n - (i+1));
            if (nums[i] > avg) count++;
        }

        return count;
    }
}
