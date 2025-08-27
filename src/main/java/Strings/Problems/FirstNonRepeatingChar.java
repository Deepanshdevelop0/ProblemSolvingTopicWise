package Strings.Problems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        System.out.println(nonRepeatingCharMostOptimal("geeksforgeeks"));
        System.out.println(nonRepeatingCharMostOptimal("racecar"));
        System.out.println(nonRepeatingCharMostOptimal("aabbccc"));
        System.out.println(nonRepeatingCharMostOptimal("hello"));

    }

    public static char nonRepeatingChar(String s) {
        int[] arr = new int[26];

        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            if (arr[ch - 'a'] == 1) {
                return ch;
            }
        }

        return '$';
    }

    public static char nonRepeatingCharMostOptimal(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            arr[index] = (arr[index] == -1) ? i : -2;
        }

        /* to track min index from all non repeating characters */
        int idx = -1;

        for (int i = 0; i < 26; i++) {
            // update idx in case its the first >0 index char found (when idx = -1),
            // or when the currIndex is less than the previous non repeating char index so as to return first char
            if (arr[i] >= 0 && (idx == -1 || arr[i] < idx)) {
                idx = arr[i];
            }
        }

        return idx == -1 ? '$' : s.charAt(idx);
    }


    public static char nonRepeatingCharLessOptimal(String s) {

        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char ch : s.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '$';
    }


}
