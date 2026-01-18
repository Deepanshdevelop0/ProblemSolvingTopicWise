package Strings.Problems;

import java.util.Set;

public class vowelConsonantScore {

    public static void main(String[] args) {

        vowelConsonantScore classObj = new vowelConsonantScore();

        int res = classObj.vowelConsonantScore("cooear    12");
        System.out.println(res);
    }

    public int vowelConsonantScore(String s) {
        int v = 0, c = 0;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                v++;
            }
            else if (ch >= 'a' && ch <= 'z') {
                c++;
            }
        }

        return (v == 0 || c == 0) ? 0 : v/c;
    }

}
