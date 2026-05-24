package LeetCode.Strings.Problems.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class Password_Strength_contest {

    public static void main(String[] args) {

    }

    public int passwordStrength(String password) {
        Set<Character> usedSet = new HashSet<>();

        int score = 0;

        for (char ch : password.toCharArray()) {
            if (usedSet.contains(ch)) continue;

            if (ch >= 'a' && ch <= 'z') {
                score += 1;
            }
            else if (ch >= 'A' && ch <= 'Z') {
                score += 2;
            }
            else if (ch >= '0' && ch <= '9') {
                score += 3;
            }
            else if (ch == '!' || ch == '@' || ch == '#' || ch == '$') {
                score += 5;
            }

            usedSet.add(ch);
        }

        return score;
    }
}
