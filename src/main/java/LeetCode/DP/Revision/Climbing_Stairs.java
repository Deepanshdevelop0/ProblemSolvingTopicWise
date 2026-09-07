package LeetCode.DP.Revision;

import LeetCode.DP.DP_1D.ClimbingStairs;

public class Climbing_Stairs {

    public static void main(String[] args) {
        Climbing_Stairs classObj = new Climbing_Stairs();

        System.out.println(classObj.climbStairs(0));
        System.out.println(classObj.climbStairs(1));
        System.out.println(classObj.climbStairs(2));
        System.out.println(classObj.climbStairs(3));
        System.out.println(classObj.climbStairs(4));
        System.out.println(classObj.climbStairs(5));
    }


    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        return solve(n, 0);
    }

    public int solve(int n, int num) {
        if (num == n) return 1;
        if (num > n) return 0;

        int ones = solve(n, num+1);

        int twos = solve(n, num+2);

        return ones + twos;
    }


}
