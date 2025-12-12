package Arrays.Miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class MirrorPersonalities_FightingPairs_Swiggy {

/*

1. SolutionOptimal :

* TC: O(N)
Dominated by O(N) string traversal for frequency calculation. The subsequent O(26) loop is constant time.

* SC: O(1)
Constant space due to the fixed-size array (26 integers) used for character counts.

2. SolutionLessOptimal :

* TC: O(N) (Average Case)
Dominated by O(N) average time for building the HashMap. The subsequent iteration over Map keys is O(26), constant time.

* SC: O(1)
Constant space due to the HashMap storing at most 26 entries. Note: Higher memory overhead than the array approach.

*/


    public static void main(String[] args) {

        // test case 1
        System.out.println(solutionOptimal(8, "axmzaxmn"));

        // test case 1
        System.out.println(solutionOptimal(10, "wjlahohpec"));
    }

    public static char findMirror(char ch) {

        int indx = ch - 'a';
        int mirrorIndx = 25 - indx;

        return (char) ('a' + mirrorIndx);
    }


    /**
     * @param N is the length of string
     * @param S is the input string of personalities
     * @return total no of fighting pairs
     */
    public static long solutionOptimal(int N, String S) {
        if (N < 2) return 0;

        int[] count = new int[26];
        for (char ch : S.toCharArray()) {
            count[ch - 'a']++;
        }

        long totalFightingPairs = 0;

        // We only need to iterate through the first half of the alphabet ('a' through 'm')
        // to avoid double-counting the pairs (e.g., counting 'a'-'z' and then 'z'-'a').
        for (char ch = 'a'; ch <= 'm'; ch++) {
            int mirrorIndx = findMirror(ch) - 'a';

            totalFightingPairs += ((long) count[ch - 'a'] * count[mirrorIndx]);
        }

        return totalFightingPairs;
    }




    public static long solutionLessOptimal(int N, String S) {
        if (N < 2) return 0;

        Map<Character, Long> freqMap = new HashMap<>();

        for (char ch : S.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0L) + 1);
        }

        long totalFightingPairs = 0;

        for (Map.Entry<Character, Long> entry : freqMap.entrySet()) {
            char key = entry.getKey();
            char mirror = findMirror(key);

            if (freqMap.containsKey(mirror)) {
                totalFightingPairs += entry.getValue() * freqMap.get(mirror);
                freqMap.put(mirror, 0L);
            }
        }

        return totalFightingPairs;
    }



}
