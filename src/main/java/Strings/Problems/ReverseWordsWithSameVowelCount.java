package Strings.Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ReverseWordsWithSameVowelCount {

    public static void main(String[] args) {

        ReverseWordsWithSameVowelCount classObj = new ReverseWordsWithSameVowelCount();

        var a = classObj.reverseWordsMoreOptimal("book is nice");
        System.out.println(a);
    }

    public String reverseWordsMoreOptimal(String s) {

        String[] strarr = s.split(" ");
        int n = strarr.length;

        if (n == 1) return strarr[0];

        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int initVowelCount = 0;

        for (char ch : strarr[0].toCharArray()) {
            if (set.contains(ch)) initVowelCount++;
        }


        for (int i = 1; i < n; i++) {
            int currVowelCount = 0;

            for (char ch : strarr[i].toCharArray()) {
                if (set.contains(ch)) currVowelCount++;
            }

            if (currVowelCount == initVowelCount) {
                strarr[i] = new StringBuilder(strarr[i]).reverse().toString();
            }

        }

        return String.join(" ", strarr);
    }

    public String reverseWords(String s) {

        String[] strarr = s.split(" ");
        int n = strarr.length;

        if (n == 1) return strarr[0];

        StringBuilder res = new StringBuilder(strarr[0] + " ");
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int initVowelCount = 0;

        for (char ch : strarr[0].toCharArray()) {
            if (set.contains(ch)) initVowelCount++;
        }


        for (int i = 1; i < n; i++) {
            int currVowelCount = 0;

            for (char ch : strarr[i].toCharArray()) {
                if (set.contains(ch)) currVowelCount++;
            }

            if (currVowelCount == initVowelCount) res.append(reverse(strarr[i], 0, strarr[i].length() - 1));
            else res.append(strarr[i]);

            if (i < n - 1) res.append(" ");
        }

        return res.toString();
    }

    public String reverse(String s, int left, int right) {

        char[] arr = s.toCharArray();

        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }

        return new String(arr);
    }


}
