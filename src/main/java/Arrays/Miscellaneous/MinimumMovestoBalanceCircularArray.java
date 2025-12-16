package Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumMovestoBalanceCircularArray {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 1, -4};

        MinimumMovestoBalanceCircularArray classObj = new MinimumMovestoBalanceCircularArray();
        System.out.println(classObj.minMoves(nums));
    }


    public long minMoves(int[] balance) {
        int negIndx = -1, neg = 0, n = balance.length;

        for (int i = 0; i < n; i++) {
            if (balance[i] < 0) {
                negIndx = i;
                neg = balance[i];
            }
        }

        int moves = 0;

        for (int i = 1; i < n; i++) {

            if ((negIndx - i < 0 && negIndx + i >= n) || neg == 0) {
                break;
            }

            if (negIndx - i >= 0) {
                int min = Math.min(Math.abs(neg), balance[negIndx - i]);
                moves += (min * i);
                neg += min;
            }

            if (negIndx + i < n) {
                int min = Math.min(Math.abs(neg), balance[negIndx + i]);
                moves += (min * i);
                neg += min;
            }

        }

        return neg == 0 ? moves : -1;
    }

}
