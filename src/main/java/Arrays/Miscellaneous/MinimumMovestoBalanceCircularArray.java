package Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumMovestoBalanceCircularArray {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 1, -4};
        int[] nums1 = new int[]{1, 2, -5, 2};
        int[] nums2 = new int[]{2,43,41,4,30,0,-46};
        int[] nums3 = new int[]{-10,4,5};

        MinimumMovestoBalanceCircularArray classObj = new MinimumMovestoBalanceCircularArray();
        System.out.println(classObj.minMoves(nums3));
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

}
