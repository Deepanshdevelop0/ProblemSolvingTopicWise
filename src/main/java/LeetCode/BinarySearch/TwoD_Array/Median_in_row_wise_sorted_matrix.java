package LeetCode.BinarySearch.TwoD_Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Median_in_row_wise_sorted_matrix {

    public static void main(String[] args) {
        Median_in_row_wise_sorted_matrix classObj = new Median_in_row_wise_sorted_matrix();

        int res = classObj.medianOptimal(new int[][]{
                {3}, {4}, {8}
        });

        System.out.println("Result : " + res);

        int res1 = classObj.medianOptimal(new int[][]{
                {2, 4, 9}, {3, 6, 7}, {4, 7, 10}
        });

        System.out.println("Result : " + res1);
    }

    public int medianBruteForce(int[][] mat) {
        List<Integer> list = new ArrayList<>();

        for (int[] i : mat) {
            for (int j : i) {
                list.add(j);
            }
        }

        Collections.sort(list);

        int mid = list.size() / 2;
        return list.get(mid);
    }

    public int medianOptimal(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;

        // find smallest and larget value
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][cols - 1]);
        }

        // +1 to include the current the current mid as well, as its necessary to have it inside the matrix
        // if mid not exists the mid still could be median but invalid so its existence is important
        int leftHalf = (rows * cols + 1) / 2;

        while (low < high) {
            int mid = (low + high) / 2;

            int count = countElementsLessThanOrEqual(mat, mid);

            if (count < leftHalf) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public int countElementsLessThanOrEqual(int[][] mat, int mid) {

        int count = 0;

        for (int[] row : mat) {

            int low = 0, high = row.length;

            while (low < high) {
                int midIndx = (low + high) / 2;

                if (row[midIndx] <= mid) {
                    low = midIndx + 1;
                } else {
                    high = midIndx;
                }
            }

            // to count the elements count and low reaches (element <= mid) +1 indx
            count += low;
        }

        return count;
    }

}
