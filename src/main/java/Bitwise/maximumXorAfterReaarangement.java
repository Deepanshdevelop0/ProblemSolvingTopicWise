package Bitwise;

public class maximumXorAfterReaarangement {

    public static void main(String[] args) {
        maximumXorAfterReaarangement classObj = new maximumXorAfterReaarangement();
        System.out.println(classObj.maximumXor("0110", "1110"));
    }

    public String maximumXor(String s, String t) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (t.charAt(i) == '1') ones++;
        }

        int zeros = n - ones;

        StringBuilder res = new StringBuilder(); // for creating the xor result of s and t

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            if (curr == '0') {

                if (ones > 0) {
                    res.append('1');        // for 0 xor 1 = 1
                    ones--;
                } else {
                    res.append('0');        // for 0 xor 0 = 0
                    zeros--;
                }

            } else {      // curr == '1
                if (zeros > 0) {
                    res.append('1');    // for 1 xor 0 = 1
                    zeros--;
                } else {
                    res.append('0');    // for 1 xor 1 = 0
                    ones--;
                }
            }

        }

        return res.toString();
    }

}
