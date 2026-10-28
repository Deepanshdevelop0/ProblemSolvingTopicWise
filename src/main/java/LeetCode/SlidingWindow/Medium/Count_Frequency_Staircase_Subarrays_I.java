package LeetCode.SlidingWindow.Medium;

public class Count_Frequency_Staircase_Subarrays_I {

    public static void main(String[] args) {
        Count_Frequency_Staircase_Subarrays_I classObj = new Count_Frequency_Staircase_Subarrays_I();
        int res = classObj.countStaircase(new int[]{2,3,4,4,3,4});
        System.out.println(res);
    }

    public int countStaircase(int[] nums) {
        int n = nums.length;
        int res = 0;

        int[] freq = new int[100005];
        int[] reqFreq = new int[100005];

        for (int i = 0; i < n; i++) {
            int k = 0;
            int j = i;

            for (; j < n; j++) {
                int curr = nums[j];

                // If it's the first time seeing this number in the current window
                if (freq[curr] == 0) {
                    k++;
                    reqFreq[curr] = k;
                }

                freq[curr]++;

                // EARLY BREAK: If an element exceeds its required frequency
                // the current window and all larger windows starting at i are permanently invalid.
                if (freq[curr] > reqFreq[curr]) {
                    break;
                }

                // VALIDITY CHECK: Because we break early if ANY element exceeds its requirement,
                // we just check if the window length equals the expected sum (1 + 2 + ... + k).
                int windowLen = j - i + 1;
                int reqLen = (k * (k + 1)) / 2;

                if (windowLen == reqLen) {
                    res++;
                }
            }

            // cleanup : Reset only the visited elements to 0 instead of re-instantiating
            // the whole array. This keeps the state clearing strictly O(N) instead of O(10^5).
            int maxVisited = (j == n) ? n-1 : j;
            for (int a = i; a <= maxVisited; a++) {
                freq[nums[a]] = 0;
                reqFreq[nums[a]] = 0;
            }
        }

        return res;
    }
}
