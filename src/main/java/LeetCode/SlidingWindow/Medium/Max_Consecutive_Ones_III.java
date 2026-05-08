package LeetCode.SlidingWindow.Medium;

public class Max_Consecutive_Ones_III {

    public static void main(String[] args) {
        Max_Consecutive_Ones_III classObj = new Max_Consecutive_Ones_III();

//        System.out.println("Case - I : ");
//        System.out.println(classObj.longestOnesBruteForce(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println("Case - II : ");
        System.out.println(classObj.longestOnesBruteForce(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

    public int longestOnesBruteForce(int[] nums, int k) {
        int n = nums.length, maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            for (int j = i; j < n; j++) {

                if (nums[j] == 0) {
                    zeroCount++;
                }
                if (zeroCount > k) {
                    break;
                }

                maxLen = Math.max(maxLen, (j - i) + 1);
             }
        }

        return maxLen;
    }


}
