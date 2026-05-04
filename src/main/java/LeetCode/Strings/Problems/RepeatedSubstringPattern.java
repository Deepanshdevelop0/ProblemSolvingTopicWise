package LeetCode.Strings.Problems;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern classObj = new RepeatedSubstringPattern();
        boolean res = classObj.repeatedSubstringPattern("abab"/*"abcabcabcabc"*/);
        System.out.println(res);

    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        if (n <= 1) return false;

        String pattern = "";

        for (int i = 0; i < n; i++) {
            pattern += s.charAt(i);

            if (i+pattern.length()+1 > n) break;

            String next = s.substring(i+1, i+pattern.length()+1);

            if (next.equals(pattern)) {
                int size = pattern.length();
                int j = i;

                while (j + size < n && s.substring(j+1, j+size+1).equals(pattern)) {
                    j += size;
                }

                if (j == n-1) {
                    return true;
                }
            }
        }

        return false;
    }

}
