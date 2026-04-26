package LeetCode.Strings.Problems.miscellaneous;

import java.util.*;

public class Sort_Vowels_by_Frequency_contest {

    public static void main(String[] args) {
        Sort_Vowels_by_Frequency_contest solution = new Sort_Vowels_by_Frequency_contest();

        // Test Case 1: The tie-breaker case
        String test1 = "oes";
        System.out.println("Input:    " + test1);
        System.out.println("Output:   " + solution.sortVowels(test1));
        System.out.println("Expected: oes\n");

        // Test Case 2: Standard frequency sorting
        String test2 = "leetcode";
        // e:3, o:1 -> 'e's should come first.
        System.out.println("Input:    " + test2);
        System.out.println("Output:   " + solution.sortVowels(test2));
        System.out.println("Expected: leetcede\n");

        // Test Case 3: Mixed consonants and vowels
        String test3 = "programming";
        // o:1, a:1, i:1. Tied frequency, so keep original order (o, a, i)
        System.out.println("Input:    " + test3);
        System.out.println("Output:   " + solution.sortVowels(test3));
        System.out.println("Expected: programming");
    }

    public String sortVowels(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        // firstIndex tracks the exact index where a vowel FIRST appeared.
        // We need this because if frequencies are tied (e.g., "oes"),
        // the problem demands we maintain their original order of appearance.
        Map<Character, Integer> firstIndex = new HashMap<>();

        // vowelList holds only the vowels found so we can sort them independently.
        List<Character> vowelList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Collect vowel frequencies and their first appearance index
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                vowelList.add(c);

                // time we see this specific vowel. Subsequent 'e's won't overwrite
                // the original index of the first 'e'.
                firstIndex.putIfAbsent(c, i);
            }
        }

        // Sort by frequency (descending), tie-break by first index (ascending)
        Collections.sort(vowelList, (a,b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);

            // Tier 1: If frequencies are different, sort descending.
            // Doing (B - A) forces higher frequencies to move to the front of the list.
            if (freqB != freqA) {
                return freqB - freqA;
            }

            // Tier 2: If frequencies are exactly the same, fall back to the first appearance.
            // Doing (A - B) on the indices sorts them ascending (lower index first),
            // which preserves their original relative order in the input string.
            return firstIndex.get(a) - firstIndex.get(b);
        });

        // Reconstruct the string with sorted vowels
        int j = 0;
        for (char c : s.toCharArray()) {
            if (vowels.contains(c)) {
                // When we hit a vowel slot in the original string, we ignore the original
                // vowel and inject the next correct vowel from our sorted list.
                sb.append(vowelList.get(j++));
            }
            else {
                // Consonants are completely untouched and stay exactly where they were.
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
