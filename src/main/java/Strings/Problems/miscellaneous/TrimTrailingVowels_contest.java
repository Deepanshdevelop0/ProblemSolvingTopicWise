package Strings.Problems.miscellaneous;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TrimTrailingVowels_contest {

    /* 3838. Weighted Word Mapping */
    public static void main(String[] args) {
        TrimTrailingVowels_contest classObj = new TrimTrailingVowels_contest();
        System.out.println(classObj.trimTrailingVowels("idea"));
    }

    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (vowels.contains(ch)) {
                sb.deleteCharAt(i);
            } else {
                break;
            }
        }

        return sb.toString();
    }




}
