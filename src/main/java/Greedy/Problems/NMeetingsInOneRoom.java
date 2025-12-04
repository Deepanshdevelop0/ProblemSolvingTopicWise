package Greedy.Problems;

import java.util.Arrays;
import java.util.Comparator;

public class NMeetingsInOneRoom {

    public static void main(String[] args) {

        int[] start = new int[]{10, 12, 20};
        int[] end = new int[]{20, 25, 30};

        NMeetingsInOneRoom classObj = new NMeetingsInOneRoom();
        System.out.println(classObj.maxMeetings(start, end));
    }

    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        Arrays.sort(meetings, Comparator.comparingInt(i -> i[1]));

        int count = 1, lastEndTime = meetings[0][1];

        for (int i = 1; i < n; i++) {

            if (meetings[i][0] > lastEndTime) {
                count++;
//                System.out.println(meetings[i][0]);
                lastEndTime = meetings[i][1];
            }
        }

        return count;
    }

}
