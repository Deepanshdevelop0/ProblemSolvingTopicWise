package DP.DP_1D;

public class ClimbingStairs {


/*

method : Iterative DP (Space Optimized)
TC : O(N) : We iterate linearly from 3 up to N.
SC : O(1) : Uses a constant number of variables (one, two, current) regardless of N.

====================================================================

method : Pure Recursion (Brute Force)

TC : O(2^N) : The problem is solved by exploring a binary recursion tree of depth N, leading to exponential time complexity.
SC : O(N) : O(N) for the maximum depth of the recursion stack.

*/

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
