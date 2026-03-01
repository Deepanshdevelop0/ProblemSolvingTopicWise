package DP.Miscellaneous;

public class MinimumCosttoSplitintoOnes_contest {

    public static void main(String[] args) {
        MinimumCosttoSplitintoOnes_contest clasObj = new MinimumCosttoSplitintoOnes_contest();
        int res = clasObj.minCost(5);
        System.out.println(res);
    }



    private Integer[] memo;
    public int minCost(int n) {
        memo = new Integer[n + 1];

        return solve(n);
    }

    public int solve(int n) {
        if (n == 1) return 0;

        if (memo[n] != null) return memo[n];

        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i <= n/2; i++) {
            int currMinCost = (i * (n-i)) + solve(i) + solve(n - i);
            minCost = Math.min(minCost, currMinCost);
        }

        return memo[n] = minCost;
    }
}
