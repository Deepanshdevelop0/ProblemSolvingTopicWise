package LeetCode.Strings.Problems.Easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Sort_Characters_By_Frequency {

    public static void main(String[] args) {
        Sort_Characters_By_Frequency classObj = new Sort_Characters_By_Frequency();
        System.out.println(classObj.frequencySort("tree"));
        System.out.println(classObj.frequencySort("cccaaa"));
        System.out.println(classObj.frequencySort("Aabb"));
    }

    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sortedByCountDesc = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        StringBuilder str = new StringBuilder();

        for (Character c : sortedByCountDesc.keySet()) {
            for (int i = 0; i < sortedByCountDesc.get(c); i++) {
                str.append(c);
            }
        }

        return str.toString();
    }


}
