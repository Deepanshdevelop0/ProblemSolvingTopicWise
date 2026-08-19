package LeetCode.Greedy.Problems;

import java.util.Arrays;
import java.util.Comparator;

public class Cinema_Seat_Allocation {

    public static void main(String[] args) {
        Cinema_Seat_Allocation classObj = new Cinema_Seat_Allocation();
        int res = classObj.maxNumberOfFamilies(3,
                new int[][]{
                        {1, 2},
                        {1, 3},
                        {1, 8},
                        {2, 6},
                        {3, 10},
                        {3, 1}
                });

        System.out.println("Result : " + res);
    }


    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Arrays.sort(reservedSeats, Comparator.comparingInt(a -> a[0]));

        int res = 0, m = reservedSeats.length;

        int indx = 0, processedRows = 0;


        while (indx < m) {

            int currentRow = reservedSeats[indx][0];
            processedRows++;

            boolean left = true, middle = true, right = true;

            while (indx < m && reservedSeats[indx][0] == currentRow) {
                int seat = reservedSeats[indx][1];

                if (seat >= 2 && seat <= 5) left = false;
                if (seat >= 4 && seat <= 7) middle = false;
                if (seat >= 6 && seat <= 9) right = false;

                indx++;
            }

            if (left && right) {
                res += 2;
            }
            else if (left || middle || right) {
                res += 1;
            }
        }

        int emptyRows = n - processedRows;
        res += (emptyRows * 2);

        return res;
    }

}
