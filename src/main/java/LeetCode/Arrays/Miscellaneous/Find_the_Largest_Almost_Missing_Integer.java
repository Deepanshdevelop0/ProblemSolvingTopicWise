package LeetCode.Arrays.Miscellaneous;

public class Find_the_Largest_Almost_Missing_Integer {

    public static void main(String[] args) {
        Find_the_Largest_Almost_Missing_Integer classObj = new Find_the_Largest_Almost_Missing_Integer();
        int res = classObj.largestInteger(new int[]{3,9,2,1,7}, 3);
        System.out.println(res);
    }

    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51];

        for (int i = 0; i <= nums.length - k; i++) {
            boolean[] seenInSubarray = new boolean[51];
            for (int j = i; j < i+k; j++) {
                if (!seenInSubarray[nums[j]]) {
                    seenInSubarray[nums[j]] = true;
                    count[nums[j]]++;
                }
            }
        }

        for (int i = 50; i >= 0; i--) {
            if (count[i] == 1) return i;
        }

        return -1;
    }
}
