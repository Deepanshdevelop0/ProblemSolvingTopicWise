package Strings.Problems.miscellaneous;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MergeCloseCharacters_Contest {

    public static void main(String[] args) {
        MergeCloseCharacters_Contest classObj = new MergeCloseCharacters_Contest();
        String res = classObj.mergeCharacters("yybyzybz", 2);
        System.out.println(res);

    }

    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (i < sb.length()) {
            char curr = sb.charAt(i);
            boolean merged = false;
            int max = Math.max(0, i - k);

            for (int j = max; j < i; j++) {
                if (sb.charAt(j) == curr) {
                    sb.deleteCharAt(i);
                    merged = true;
                    break;
                }
            }

            i = (merged) ? 0 : i + 1;
        }

        return sb.toString();
    }
}
