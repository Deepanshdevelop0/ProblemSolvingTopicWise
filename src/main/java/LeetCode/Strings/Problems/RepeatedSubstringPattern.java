package LeetCode.Strings.Problems;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
        RepeatedSubstringPattern classObj = new RepeatedSubstringPattern();
        boolean res = classObj.repeatedSubstringPatternI("aaaaaaab"/*"abcabcabcabc"*/);
        System.out.println(res);


//        String s = "abcabcabcabc";
//
//        String[] arr = s.split("abc");
//
//        if (arr.length == 0) {
//            System.out.println("Empty array!");
//            return;
//        }
//
//        for (String i : arr) {
//            System.out.println(i + " - " + i.length());
//        }

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

    public boolean repeatedSubstringPatternI(String s) {
        int n = s.length();

        if (n <= 1) return false;

        for (int i = n/2; i > 0; i--) {

            if (n % i == 0) {

                String substring = s.substring(0, i);
                StringBuilder str = new StringBuilder();

                for (int j = 0; j < n/i; j++) {
                    str.append(substring);
                }

                if (str.toString().equals(s)) return true;
            }

        }

        return false;
    }

}
