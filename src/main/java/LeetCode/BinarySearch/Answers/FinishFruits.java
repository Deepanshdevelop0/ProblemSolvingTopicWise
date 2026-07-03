package LeetCode.BinarySearch.Answers;

import java.util.Arrays;

public class FinishFruits {


    public static void main(String[] args) {
        FinishFruits solution = new FinishFruits();
//        int[] arr = {8, 11, 18, 20};
//        int h = 10;
//        int result = solution.minxValue(arr, h);


        int[] arr1 = {3, 6, 7, 11};
        int h1 = 8;
        int result1 = solution.minxValue(arr1, h1);

        System.out.println("Minimum value of X will be : " + result1);
    }

    public int minxValueI(int[] arr, int H) {
        int X = Arrays.stream(arr).max().getAsInt();
        int lo = 0, hi = X;

        while (lo <= hi) {
            int x = (lo + hi) / 2;
            int reqTime = 0;

            for (int val : arr) {
                // ceil value
                reqTime += (val + x - 1) / x;
            }

            if (reqTime <= H) {
                X = x;
                hi = x - 1;
            } else {
                lo = x + 1;
            }
        }

        return X;
    }



    public int minxValue(int[] arr, int H) {
        int max = Arrays.stream(arr).max().getAsInt();
        int low = 0, high = max;

        while (low <= high) {
            int mid = (low + high) / 2;
            int reqTime = 0;

            for (int i : arr) {
                reqTime += (i + mid - 1) / mid; // find the ceil value as 7/2 = 3.0, but we need 7 + 2 - 1 / 2 = 4.0
            }

            if (reqTime <= H) {
                max = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }

        }


        return max;
    }



}
