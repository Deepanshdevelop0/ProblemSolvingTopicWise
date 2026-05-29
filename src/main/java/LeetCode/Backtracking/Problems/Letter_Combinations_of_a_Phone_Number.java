package LeetCode.Backtracking.Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number classObj = new Letter_Combinations_of_a_Phone_Number();
        classObj.letterCombinations("213").forEach(System.out::println);
    }


    public List<String> letterCombinations(String digits) {

        Map<Character, String> keypad = new HashMap<>(Map.of(
                '1', "",
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"));

        int n = digits.length();
        StringBuilder str = new StringBuilder();
        List<String> res = new ArrayList<>();

        backtrack(digits, 0, keypad, n, str, res);

        return res;
    }

    public void backtrack(String digits, int indx, Map<Character, String> keypad, int n, StringBuilder str, List<String> res) {
        // base case
        if (indx == n) {
            if (!str.isEmpty()) {
                res.add(str.toString());
            }
            return;
        }

        char digit = digits.charAt(indx);
        String combinations = keypad.get(digit);

        // THE FIX: If the dial maps to nothing (like 1), skip it.
        // Do NOT loop. Just move indx forward.
        if (combinations == null || combinations.isEmpty()) {
            backtrack(digits, indx+1, keypad, n, str, res);
            return;
        }

        // Normal backtracking for valid characters
        for (char ch : combinations.toCharArray()) {
            str.append(ch);
            backtrack(digits, indx+1, keypad, n, str, res);
            str.deleteCharAt(str.length() - 1);
        }

    }


}
