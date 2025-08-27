package Strings.Problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

    public static void main(String[] args) {

        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("aabb"));

    }

    public static int firstUniqChar(String s) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }


    public static int firstUniqCharLessOptimal(String s) {

        Map<Character, Pair> countMap = new LinkedHashMap<>();

        int indx = 0;

        for (char ch : s.toCharArray()) {
            Pair curr = countMap.getOrDefault(ch, new Pair(0, indx));
            curr.count++;
            countMap.put(ch, curr);
            indx++;
        }

        for (Map.Entry<Character, Pair> entry : countMap.entrySet()) {
            if (entry.getValue().count == 1) {
                return entry.getValue().index;
            }
        }

        return -1;
    }


    static class Pair {
        long count;
        int index;

        Pair(long count, int index) {
            this.count = count;
            this.index = index;
        }
    }

}
