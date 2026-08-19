package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number classObj = new Letter_Combinations_of_a_Phone_Number();
        classObj.letterCombinations("213").forEach(System.out::println);
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
                '1', "",
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        backtrack(digits, digits.length(), 0, sb, res, map);

        return res;
    }

    public void backtrack(String digits, int n, int indx, StringBuilder sb, List<String> res, Map<Character, String> map) {
        if (indx == n) {
            if (!sb.isEmpty()) res.add(sb.toString());
            return;
        }

        String combinations = map.get(digits.charAt(indx));

        // handles for '1' with no combinations too
        if (combinations == null || combinations.isEmpty()) {
            backtrack(digits, n, indx+1, sb, res, map);
            return;
        }

        for (int i = 0; i < combinations.length(); i++) {
            sb.append(combinations.charAt(i));
            backtrack(digits, n, indx+1, sb, res, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
