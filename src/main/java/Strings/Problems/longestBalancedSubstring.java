package Strings.Problems;

public class longestBalancedSubstring {

    public static int longestBalancedSubstring1(String s) {
        int n = s.length();
        int maxLen = 0;

        // Try all possible number of unique characters
        for (int unique = 1; unique <= 26; unique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int uniqueCount = 0;

            while (right < n) {
                // expand window
                int rIndex = s.charAt(right) - 'a';
                freq[rIndex]++;
                if (freq[rIndex] == 1) uniqueCount++;
                right++;

                // shrink if too many unique characters
                while (uniqueCount > unique) {
                    int lIndex = s.charAt(left) - 'a';
                    freq[lIndex]--;
                    if (freq[lIndex] == 0) uniqueCount--;
                    left++;
                }

                // check if current window is balanced
                if (uniqueCount == unique && isBalanced(freq)) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen;
    }

    private static boolean isBalanced(int[] freq) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int f : freq) {
            if (f > 0) {
                min = Math.min(min, f);
                max = Math.max(max, f);
            }
        }
        return min == max;
    }

    public static int longestBalancedSubstring(String s) {

        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE, max = 0;
                for (int f : freq) {
                    if (f > 0) {
                        min = Math.min(min, f);
                        max = Math.max(max, f);
                    }
                }

                if (min == max) {
                    maxLen = Math.max(maxLen, j-i+1);
                }

            }

        }

        return maxLen;
    }
    public static void main(String[] args) {
        System.out.println(longestBalancedSubstring("abbac"));   // 4 ("abba")
        System.out.println(longestBalancedSubstring("zzabccy")); // 4 ("zabc")
    }

}
