package Strings.Problems.miscellaneous;

import java.util.HashSet;
import java.util.Set;

public class PrefixConnectedGroups {

    /* 3839. Number of Prefix Connected Groups */

    public static void main(String[] args) {

        PrefixConnectedGroups classObj = new PrefixConnectedGroups();
        System.out.println(
                classObj.prefixConnected(
                        new String[]{"apple", "apply", "banana", "bandit"},
                        2
                )
        );
    }

    public int prefixConnected(String[] words, int k) {
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();

        for (String s : words) {
            if (s.length() >= k) {
                String tmp = s.substring(0, k);
                if (set.contains(tmp)) {
                    res.add(tmp);
                } else {
                    set.add(tmp);
                }
            }
        }

        return res.size();
    }
}
