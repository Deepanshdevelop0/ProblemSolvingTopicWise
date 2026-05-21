package LeetCode.SlidingWindow.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Longest_Substring_with_At_Most_K_Distinct_Characters {

    public static void main(String[] args) {
        Longest_Substring_with_At_Most_K_Distinct_Characters classObj = new Longest_Substring_with_At_Most_K_Distinct_Characters();

        int res = classObj.kDistinctCharsMostOptimal(2, "abcba");
        System.out.println(res);

        int res1 = classObj.kDistinctCharsMostOptimal(2, "abbbbbbc");
        System.out.println(res1);
    }

    public int kDistinctCharsBruteForce(int k, String str) {

        int n = str.length();
        int maxlen  = 0;

        for (int i = 0; i < n; i++) {
            Set<Integer> freqSet = new HashSet<>();

            for (int j = i; j < n; j++) {
                freqSet.add((int) str.charAt(j));

                if (freqSet.size() > k) {
                    break;
                }

                maxlen = Math.max(maxlen, j - i + 1);
            }
        }

        return maxlen;
    }

    public int kDistinctCharsOptimal(int k, String str) {

        int n = str.length();
        int maxlen = 0;

        int low = 0, high = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (high = 0; high < n; high++) {
            int ch = str.charAt(high);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            while (freqMap.size() > k) {
                int lowChar = str.charAt(low);

                freqMap.put(lowChar, freqMap.get(lowChar) - 1);

                if (freqMap.get(lowChar) == 0) {
                    freqMap.remove(lowChar);
                }
                low++;
            }

            maxlen = Math.max(maxlen, high - low + 1);

        }

        return maxlen;

    }

    public int kDistinctCharsMostOptimal(int k, String str) {

        int n = str.length();
        int maxlen = 0;

        int low = 0, high = 0;
        int[] freqMap = new int[26];
        int charCount = 0;

        for (high = 0; high < n; high++) {

            int indx = str.charAt(high) - 'a';

            if (freqMap[indx] == 0) {
                charCount++;
            }

            freqMap[indx]++;

            while (charCount > k) {

                int lowCharIndx = str.charAt(low) - 'a';

                freqMap[lowCharIndx]--;

                if (freqMap[lowCharIndx] == 0) {
                    charCount--;
                }

                low++;
            }

            maxlen = Math.max(maxlen, high - low + 1);

        }

        return maxlen;
    }


}
