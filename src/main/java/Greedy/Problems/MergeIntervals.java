package Greedy.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals classObj = new MergeIntervals();

        int[][] res = classObj.merge(intervals);

        Arrays.stream(res).forEach(i -> {
            System.out.println("[" + i[0] + ", " + i[1] + "]");
        });

    }

    public int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));

        List<int[]> res = new ArrayList<>();

        if (intervals[1][0] <= intervals[0][1] && intervals[1][1] >= intervals[0][0]) {
            res.add(new int[]{Math.min(intervals[0][0], intervals[1][0]), Math.max(intervals[0][1], intervals[1][1])});
        }
        else {
            res.add(new int[]{intervals[0][0], intervals[0][1]});
        }

        // check with new i=1 or 0 if not merged above,
        // and take last index of res to compare the overlap
        // if overlaps modify the res last index arr else add new interval [] in res list


        return res.toArray(new int[intervals.length][]);
    }


}
