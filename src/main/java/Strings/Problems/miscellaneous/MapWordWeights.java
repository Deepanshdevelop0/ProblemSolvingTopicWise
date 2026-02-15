package Strings.Problems.miscellaneous;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MapWordWeights {

    /* 3838. Weighted Word Mapping */
    public static void main(String[] args) {
        MapWordWeights classObj = new MapWordWeights();
        System.out.println(
                classObj.mapWordWeightsUsingStreamAndFunctionalInterface(
                        new String[]{"abcd", "def", "xyz"},
                        new int[]{5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2}
                )
        );
    }

    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";

        for (String s : words) {
            int sum = 0;

            for (char c : s.toCharArray()) {
                sum += weights[((int) c - 97)];
            }

            sum = sum % 26;
            // subtract from 26 to get the char starting from z,y,x
            // add 96 to get char using ascii
            sum = (26 - sum) + 96;
            char ch = (char) sum;
            res += ch;
        }

        return res;
    }

    public String mapWordWeightsOptimized(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder(words.length);

        for (String s : words) {
            int sum = 0;

            for (int i = 0; i < s.length(); i++) {
                sum += weights[((int) s.charAt(i) - 'a')];
            }

            // subtract from 'z' to get the char from ending z,y,x
            char ch = (char) ('z' - (sum % 26));
            sb.append(ch);
        }

        return sb.toString();
    }

    public String mapWordWeightsUsingStreamAndFunctionalInterface(String[] words, int[] weights) {

        return Arrays.stream(words)
                .map(s -> {
                    int sum = s.chars()
                            .map(c -> weights[c - 'a'])
                            .sum();
                    char ch = (char) ('z' - (sum % 26));
                    return String.valueOf(ch);
                })
                .collect(Collectors.joining());
    }

}
