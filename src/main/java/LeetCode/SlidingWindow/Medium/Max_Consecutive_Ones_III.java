package LeetCode.SlidingWindow.Medium;

public class Max_Consecutive_Ones_III {


/*

1. Brute Force Approach

TC : O(N^2) : For every single starting position, it probes as far as it can until it hits the k+1 th zero.

SC : O(1) : Constant space used by pointers and counters.

-----------------------------------------------------------------------

2. Optimal Approach (Sliding Window)

TC : O(N) : Each index i is processed by 'r' once and 'l' once.

SC : O(1) : Constant space used for pointers and counters.

*/
    public static void main(String[] args) {
        Max_Consecutive_Ones_III classObj = new Max_Consecutive_Ones_III();

        System.out.println("Case - I : ");
//        System.out.println(classObj.longestOnesOptimal(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println("Case - II : ");
        System.out.println(classObj.longestOnesOptimal(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
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

    public int longestOnesOptimal(int[] nums, int k) {

        int n = nums.length;
        int l = 0, r = 0, maxLen = 0;

        int zeroCount = 0;

        while (l <= r && r < n) {
            if (nums[r] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                while (zeroCount > k) {
                    if (nums[l] == 0) zeroCount--;
                    l++;
                }
            }

            maxLen = Math.max(maxLen, (r - l) + 1);
            r++;
        }

        return maxLen;
    }

}
