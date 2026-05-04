package LeetCode.LineSweep;

import java.util.Arrays;

public class Maximum_Population_Year {


/*

    1. Brute Force

    TC : O(N * YearRange) -> Where YearRange is 100 (1950 to 2050).
    SC : O(YearRange)     -> We use a fixed-size array of 101 to store counts.

    Description:
    Simply iterate through each person, and for every year they were alive,
    increment that year in a frequency map/array.

    -------------------------------------------------------------------------

    2. Difference Array Technique (Best for this problem)
    -------------------------------------------------------------------------
    TC : O(N + YearRange) -> We iterate the logs once, then the 101 years once.
    SC : O(YearRange)     -> Uses a fixed-size array of 101, regardless of N.

    Description:
    1. Iterate through each person; mark '+1' at birth year and '-1' at death year.
    2. Iterate through the yearCount array to calculate the cumulative (prefix) sum.
    3. Keep track of the maximum sum and the earliest year it occurred.
    4. Return the year with the maximum population.


    3. Line Sweep Technique (Generic for large ranges)
    TC : O(N log N) -> Due to sorting the events array/list.
    SC : O(N)        -> We store 2 * N events (one birth, one death per person).

    Description:
    1. Create a list of events where each event is a pair: {year, type}.
    2. Sort events by year. If years are equal, process deaths (-1) before births (+1).
    3. Traverse the sorted events to find the peak population.

*/
    public static void main(String[] args) {
        Maximum_Population_Year classObj = new Maximum_Population_Year();
        int res = classObj.maximumPopulation_LineSweepTechnique(new int[][]{{1950, 1961}, {1960, 1971}, {1970, 1981}});
        System.out.println(res);


        int res1 = classObj.maximumPopulation_LineSweepTechnique(new int[][]{{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}});
        System.out.println(res1);

    }

    // brute force
    public int maximumPopulation_BruteForce(int[][] logs) {

        int[] yearCount = new int[101];
        int offset = 1950;


        for (int[] log : logs) {
            for (int i = log[0]; i < log[1]; i++) {
                yearCount[i - offset]++;
            }
        }

        int max = 0, year = 0;

        for (int i = 0; i < 101; i++) {
            if (yearCount[i] > max) {
                max = yearCount[i];
                year = i + offset;
            }
        }

        return year;
    }

    public int maximumPopulation_DifferenceArrayTechnique(int[][] logs) {

        int[] yearCount = new int[101];
        int offset = 1950;

        for (int[] log : logs) {
            yearCount[log[0] - offset]++;
            yearCount[log[1] - offset]--;
        }

        int max = 0, cummSum = 0, year = 0;

        for (int i = 0; i < 101; i++) {
            cummSum += yearCount[i];
            if (cummSum > max) {
                max = cummSum;
                year = i + offset;
            }
        }

        return year;
    }


    public int maximumPopulation_LineSweepTechnique(int[][] logs) {

        int[][] events = new int[logs.length*2][2];

        int j = 0;
        for (int[] log : logs) {
            events[j++] = new int[]{log[0], +1};
            events[j++] = new int[]{log[1], -1};
        }

        Arrays.sort(events, (a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1]; // Process -1 (death) before +1 (birth)
        });

        int currSum = 0, max = 0, year = 0;
        for (int[] event : events) {
            currSum += event[1];
            if (currSum > max) {
                max = currSum;
                year = event[0];
            }
        }

        return year;
    }

}
