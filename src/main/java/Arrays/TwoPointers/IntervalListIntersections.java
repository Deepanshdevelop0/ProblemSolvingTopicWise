package Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {

        IntervalListIntersections classObj = new IntervalListIntersections();

        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] secondList = new int[][]{{1,5},{8,12},{15,24},{25,26}};

        int[][] res = classObj.intervalIntersection(firstList, secondList);

        Arrays.stream(res).forEach(i -> {
            System.out.println("[" + i[0] + ", " + i[1] + "]");
        });
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int n = firstList.length, m = secondList.length;

        if (n == 0 || m == 0) {
            return new int[0][0];
        }

        // two pointers: one for firstList and one for secondList
        int i1 = 0, i2 = 0;
        List<int[]> res = new ArrayList<>();

        while (i1 < n && i2 < m) {

            int a1 = firstList[i1][0], a2 = firstList[i1][1];
            int b1 = secondList[i2][0], b2 = secondList[i2][1];
            boolean intersection = (b1 <= a2 && b2 >= a1);

            /* find intersection */
            if (intersection) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }

            /* increment */
            if (a2 < b2) i1++;
            else i2++;

        }

        return res.toArray(new int[res.size()][]);
    }

}
