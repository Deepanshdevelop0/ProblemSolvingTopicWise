package LeetCode.Arrays.TwoPointers;

import java.util.Arrays;

public class AssignCookies {

    public static void main(String[] args) {
        AssignCookies classObj = new AssignCookies();
        System.out.println(classObj.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(classObj.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, count = 0;

        for (; i < s.length && j < g.length; i++) {
            if (s[i] >= g[j]) {
                count++;
                j++;
            }
        }

        return count;
    }
}
