package LeetCode.SlidingWindow.Medium;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters classObj = new Longest_Substring_Without_Repeating_Characters();
        String s = "abcabcbb";
        System.out.println(classObj.lengthOfLongestSubstringBruteForce(s));
    }

    public int lengthOfLongestSubstringBruteForce(String s) {

        if (s == null || s.isEmpty()) return 0;

        int n = s.length(), maxlen = 0;

        for (int i = 0; i < n; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);

                if (set.contains(ch)) {
                    break;
                }
                else {
                    maxlen = Math.max(maxlen, (j - i) + 1);
                    set.add(ch);
                }
            }

        }

        return maxlen;
    }

    public int lengthOfLongestSubstringOptimal(String s) {

        if (s == null || s.isEmpty()) return 0;

        int left = 0, right = 0, maxLen = 0, n = s.length();
        Set<Character> set = new HashSet<>();

        while (left <= right && right < n) {

            char ch = s.charAt(right);

            if (set.contains(ch)) {
                while (set.contains(ch)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            set.add(ch);
            maxLen = Math.max(maxLen, (right - left) + 1);
            right++;
        }

        return maxLen;

    }

}
