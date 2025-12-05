package Greedy.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

/*

TC : O(NlogN), where n is no of intervals
Dominated by the initial sorting of the intervals.

SC : O(N)
Required to store the sorted copy of the input and the resultant merged list.

*/
    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals classObj = new MergeIntervals();

        int[][] res = classObj.merge(intervals);

        Arrays.stream(res).forEach(i -> {
            System.out.println("[" + i[0] + ", " + i[1] + "]");
        });

    }

    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        if (n <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> res = new ArrayList<>();

        // Add the first interval to the result list
        res.add(intervals[0]);

        int a1 = 0, a2 = 0;
        int b1 = 0, b2 = 0;

        for (int i = 1; i < n; i++) {

            a1 = res.get(res.size() - 1)[0]; a2 = res.get(res.size() - 1)[1];
            b1 = intervals[i][0]; b2 = intervals[i][1];

            // take last index of res to compare the overlap
            // if it overlaps modify the res last index arr else add new interval [] in res list
            if (b1 <= a2 && b2 >= a1) {
                // index 0 would already be minimum as we sorted array and that index already added to res appeared first to this index in intervals
                res.get(res.size() - 1)[1] = Math.max(a2, b2);
            }
            else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }


}
