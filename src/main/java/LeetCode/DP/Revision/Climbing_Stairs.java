package LeetCode.DP.Revision;

import LeetCode.DP.DP_1D.ClimbingStairs;

import java.util.Arrays;

public class Climbing_Stairs {

    public static void main(String[] args) {
        Climbing_Stairs classObj = new Climbing_Stairs();

//        System.out.println(classObj.climbStairs(0));
//        System.out.println(classObj.climbStairs(1));
//        System.out.println(classObj.climbStairs(2));
//        System.out.println(classObj.climbStairs(3));
//        System.out.println(classObj.climbStairs(4));
        System.out.println(classObj.climbStairsTabulationSpaceOptimized(5));
    }


    /* 1. Brute Force Recursion Approach */

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return solve(n, 0);
    }

    public int solve(int n, int num) {
        if (num == n) return 1;
        if (num > n) return 0;

        int ones = solve(n, num + 1);

        int twos = solve(n, num + 2);

        return ones + twos;
    }


    /* 2. Memoization Approach */
    public int climbStairsMemoized(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solveMemoized(n, 0, dp);
    }

    public int solveMemoized(int n, int num, int[] dp) {
        if (num == n) return 1;
        if (num > n) return 0;

        if (dp[num] != -1) {
            return dp[num];
        }

        int ones = solveMemoized(n, num + 1, dp);
        int twos = solveMemoized(n, num + 2, dp);

        dp[num] = ones + twos;

        return dp[num];
    }


    /* 3. Tabulation Approach */
    public int climbStairsTabulation(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /* 4. Tabulation Space Optimized Approach */

    public int climbStairsTabulationSpaceOptimized(int n) {
        if (n <= 2) {
            return n;
        }

        int prevOne = 1;
        int prevTwo = 1;
        int res = 0;

        for (int i = 2; i <= n; i++) {

            res = prevOne + prevTwo;

            prevOne = prevTwo;
            prevTwo = res;
        }

        return res;
    }


    // 8,5,3,2,1,-1


}
