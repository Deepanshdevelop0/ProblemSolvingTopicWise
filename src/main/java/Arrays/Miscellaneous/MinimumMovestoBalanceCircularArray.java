package Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumMovestoBalanceCircularArray {

/*

1. SolutionOptimal (Two-Pointer Expansion):

* TC: O(N)
Single pass to find the negative index followed by a maximum of N/2 iterations.
Features an early exit optimization if debt is cleared before reaching the meeting point.

* SC: O(1)
Uses fixed auxiliary variables.

2. SolutionLessOptimal (Distance-Based Calculation):

* TC: O(N)
Always iterates through the search space without early exit. Performs
redundant arithmetic by recalculating circular indices from the anchor point
in every iteration.

* SC: O(1)
Constant space usage, though slightly less efficient due to more frequent
arithmetic operations within the loop.

*/


    public static void main(String[] args) {

        int[] nums = new int[]{5, 1, -4};
        int[] nums1 = new int[]{1, 2, -5, 2};
        int[] nums2 = new int[]{2, 43, 41, 4, 30, 0, -46};
        int[] nums3 = new int[]{-10, 4, 5};
        int[] nums4 = new int[]{4, 0};

        MinimumMovestoBalanceCircularArray classObj = new MinimumMovestoBalanceCircularArray();
        System.out.println(classObj.minMovesOptimal(nums4));
    }


    public long minMoves(int[] balance) {
        int negIndx = -1, neg = 0, n = balance.length;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                negIndx = i;
                neg = balance[i];
            }
        }

        long moves = 0;


        int j = 0, k = 0, i = 0;

        for (i = 1; i < n; i++) {

            j = (negIndx - i >= 0) ? negIndx - i : n + (negIndx - i);
            k = (negIndx + i < n) ? negIndx + i : (negIndx + i) - n;

            if (j == k || neg == 0) {
                break;
            }

            // for indx of j
            int min = Math.min(Math.abs(neg), balance[j]);
            moves += ((long) min * i);
            neg += min;
            balance[j] = 0;

            // for indx of k
            min = Math.min(Math.abs(neg), balance[k]);
            moves += ((long) min * i);
            neg += min;
            balance[k] = 0;

        }

        if (j == k && neg != 0 && balance[j] > 0) {
            int min = Math.min(Math.abs(neg), balance[j]);
            moves += ((long) min * i);
            neg += min;
        }

        return neg == 0 ? moves : -1;
    }

    public long minMovesOptimal(int[] balance) {

        int n = balance.length, negIndx = -1;
        long neg = 0L;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                neg = balance[i];
                negIndx = i;
                break;
            }
        }

        if (negIndx == -1) return 0;

        int j = negIndx, k = negIndx;
        long moves = 0;

        // with two pointer and n/2 steps from any indx, complete array would be traversed
        for (int i = 1; i <= n/2; i++) {

            j = (j == 0) ? (n-1) : j-1;
            k = (k == n-1) ? 0 : k+1;


            if (j == k) {

                long min = Math.min((neg * -1), balance[j]);
                moves += (min * i);
                neg += min;

            } else {

                long min = Math.min((neg * -1), balance[j]);
                moves += (min * i);
                neg += min;

                min = Math.min((neg * -1), balance[k]);
                moves += (min * i);
                neg += min;
            }

            if (neg == 0L) {
                break;
            }

        }


        return neg == 0 ? moves : -1L;
    }

}
