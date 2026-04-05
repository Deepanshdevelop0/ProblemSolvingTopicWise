package LeetCode.Arrays.Miscellaneous;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class mirrorFrequency_contest {

    public static void main(String[] args) {
        mirrorFrequency_contest classObj = new mirrorFrequency_contest();
        int res = classObj.mirrorFrequency("ab1z9");
        System.out.println(res);
        int res1 = classObj.mirrorFrequency("363");
        System.out.println(res1);

    }

    public int mirrorFrequency(String s) {
        Map<Character, Character> mirrorMap = new HashMap<>();
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                char mirror = (char) (('z' - c) + 'a');
                mirrorMap.putIfAbsent(c, mirror);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            else if (c >= '0' && c <= '9') {
                char mirror = (char) (('9' - c) + '0');
                mirrorMap.putIfAbsent(c, mirror);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
        }

        int absDiff = 0;

        Set<Character> set = new HashSet<>();
        for (Map.Entry<Character, Character> entry : mirrorMap.entrySet()) {
            char c = entry.getKey();
            char m = entry.getValue();
            if (set.contains(c)) continue;
            set.add(m);
            absDiff += Math.abs(freqMap.getOrDefault(c, 0) - freqMap.getOrDefault(m, 0));
        }

        return absDiff;
    }
}
