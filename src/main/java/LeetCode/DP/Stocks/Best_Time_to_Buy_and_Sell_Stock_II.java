package LeetCode.DP.Stocks;

import java.util.Arrays;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_II classObj = new Best_Time_to_Buy_and_Sell_Stock_II();
        int res = classObj.maxProfit(new int[]{1, 5, 3, 6, 4});
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
//        return maxProfitRecursive(prices, 0, 1);

        int[][] dp = new int[prices.length][2];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return maxProfitMemoization(prices, 0, 1, dp);
    }

    public int maxProfitRecursive(int[] prices, int day, int canBuy) {
        if (day >= prices.length) {
            return 0;
        }

        if (canBuy == 1) {
            int buy = -prices[day] + maxProfitRecursive(prices, day + 1, 0);
            int skip = 0 + maxProfitRecursive(prices, day + 1, 1);
            return Math.max(buy, skip);
        } else {
            int sell = prices[day] + maxProfitRecursive(prices, day + 1, 1);
            int skip = 0 + maxProfitRecursive(prices, day + 1, 0);
            return Math.max(sell, skip);
        }
    }


    public int maxProfitMemoization(int[] prices, int day, int canBuy, int[][] dp) {
        if (day >= prices.length) {
            return 0;
        }
        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }

        if (canBuy == 1) {
            int buy = -prices[day] + maxProfitMemoization(prices, day + 1, 0, dp);
            int skip = 0 + maxProfitMemoization(prices, day + 1, 1, dp);
            return dp[day][canBuy] = Math.max(buy, skip);
        } else {
            int sell = prices[day] + maxProfitMemoization(prices, day + 1, 1, dp);
            int skip = 0 + maxProfitMemoization(prices, day + 1, 0, dp);
            return dp[day][canBuy] = Math.max(sell, skip);
        }
    }


}
