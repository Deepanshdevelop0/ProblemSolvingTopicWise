package Arrays.SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MaxSubarrayValue {

    public static void main(String[] args) {

        System.out.println(maxSubarrayValue(List.of(3, -1, -1, -1, 5, 1)));
    }

    public static long maxSubarrayValue(List<Integer> arr) {
        // Write your code here

        int n = arr.size();
        long evenSum = 0;
        long oddSum = 0;

        List<Long> evenList = new ArrayList<>();
        List<Long> oddList = new ArrayList<>();

        for (int i = 0; i < n; i += 2) {
            evenSum += arr.get(i);

            evenList.add(evenSum);
            oddList.add(oddSum);

            if (i + 1 < n) oddSum += arr.get(i + 1);

            evenList.add(evenSum);
            oddList.add(oddSum);
        }

        evenSum = 0;
        oddSum = 0;

        long maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                long even = evenList.get(j) - evenSum;
                long odd = oddList.get(j) - oddSum;

                long calc = (even - odd);

                maxSum = Math.max((calc * calc), maxSum);
            }

            evenSum = evenList.get(i);
            oddSum = oddList.get(i);
        }


        return maxSum;
    }

}
