package Greedy.Problems;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};

        NonOverlappingIntervals classObj = new NonOverlappingIntervals();
        System.out.println(classObj.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int count = 0, lastEndTime = intervals[0][1], n = intervals.length;

        for (int i = 1; i < n; i++) {

            if (lastEndTime > intervals[i][0]) {
                count++;
            }
            else {
                lastEndTime = intervals[i][1];
            }
        }

        return count;
    }
}
