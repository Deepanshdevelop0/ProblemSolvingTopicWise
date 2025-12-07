package Greedy.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {

//        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[][] intervals = new int[][]{{1, 5}};
        int[] newIntervals = new int[]{6, 8};


        InsertInterval classObj = new InsertInterval();

        int[][] res = classObj.insert(intervals, newIntervals);

        Arrays.stream(res).forEach(i -> {
            System.out.println("[" + i[0] + ", " + i[1] + "]");
        });

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }

        boolean merged = false;
        List<int[]> res = new ArrayList<>();


        for (int i = 0; i < intervals.length; i++) {

            int[] currInterval = intervals[i];

            if (!merged && newInterval[0] <= currInterval[1] && newInterval[1] >= currInterval[0]) { // new interval is not yet merged and it overlaps with current ith interval
                res.add(new int[]{Math.min(currInterval[0], newInterval[0]), Math.max(currInterval[1], newInterval[1])});
                merged = true;
            }
            else if (merged && currInterval[0] <= res.get(res.size() - 1)[1] && currInterval[1] >= res.get(res.size() - 1)[0]) { // new interval is already and current ith interval is possible to overlap with res[n-1] interval
                int[] lastInterval = res.get(res.size() - 1);

                lastInterval[0] = Math.min(lastInterval[0], currInterval[0]);
                lastInterval[1] = Math.max(lastInterval[1], currInterval[1]);
            } else { // no overlapping in newinterval or res's n-1 indx interval, so just add this interval
                res.add(currInterval);
            }

        }

        if (!merged) {
            res.add(newInterval);
        }

        return res.toArray(new int[res.size()][]);
    }

}
