package LeetCode.DP.DP_2D_3D_GRID;

import java.util.Arrays;

public class Maximum_Number_of_Items_For_Sale_I {

    public static void main(String[] args) {
        Maximum_Number_of_Items_For_Sale_I classObj = new Maximum_Number_of_Items_For_Sale_I();
        System.out.println(classObj.maximumSaleItems(new int[][]{{6,2},{2,6},{3,4}}, 9));
    }


    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] values = new int[n];
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int currentFactor = items[i][0];
            int currentPrice = items[i][1];

            int val = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % currentFactor == 0) {
                    val++;
                }
            }
            values[i] = val;
            minPrice = Math.min(minPrice, currentPrice);
        }

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int val = values[i];

            for (int j = budget; j >= price; j--) {
                if (dp[j - price] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - price] + val);
                }
            }
        }

        int maxTotalItems = 0;
        for (int w = 0; w <= budget; w++) {
            if (dp[w] != -1) {
                int extraCopies = (budget - w) / minPrice;
                int currentTotal = dp[w] + extraCopies;
                maxTotalItems = Math.max(maxTotalItems, currentTotal);
            }
        }

        return maxTotalItems;
    }


}
