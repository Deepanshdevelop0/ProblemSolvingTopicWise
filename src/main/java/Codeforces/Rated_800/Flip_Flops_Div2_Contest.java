package Codeforces.Rated_800;

import java.util.Arrays;
import java.util.Scanner;

public class Flip_Flops_Div2_Contest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int len = sc.nextInt();
            long currPow = sc.nextLong();
            long flips = sc.nextLong();

            int[] arr = new int[len];


            int i = 0;
            while (i < len) {
                arr[i] = sc.nextInt();
                i++;
            }

            Arrays.sort(arr);

            if (currPow < arr[0]) {
                System.out.println(currPow);
            }
            else {
                System.out.println(calcMaxPower(len, currPow, flips, arr));
            }

        }
        sc.close();

    }

    private static Long calcMaxPower(int n, long currPow, long flips, int[] arr) {

        for (int i = 0; i < n; i++) {
            if (arr[i] > currPow) break;
            long noOfFlips = Math.min(flips, currPow - arr[i]);
            currPow += (noOfFlips + arr[i]);
            flips -= noOfFlips;
        }

        return currPow;
    }

}
