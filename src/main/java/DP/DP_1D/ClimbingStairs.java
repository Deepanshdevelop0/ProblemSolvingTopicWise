package DP.DP_1D;

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairsOptimal(0));
        System.out.println(climbStairsOptimal(1));
        System.out.println(climbStairsOptimal(2));
        System.out.println(climbStairsOptimal(3));
        System.out.println(climbStairsOptimal(4));
        System.out.println(climbStairsOptimal(5));
    }

    public static int climbStairsOptimal(int n) {

        if (n <= 2) {
            return n;
        }

        int one = 1, two = 2;

        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = one + two;

            one = two;
            two = current;
        }

        return current;
    }

    public static int climbStairsLeastOptimal(int n) {

        /* has 2 pow n time complexity */
        return climbStairsRecursion(0, n);
    }

    public static int climbStairsRecursion(int i, int n) {

        if (i == n) return 1;
        else if (i > n) return 0;

        return climbStairsRecursion(i+1, n) + climbStairsRecursion(i+2, n);
    }

}
