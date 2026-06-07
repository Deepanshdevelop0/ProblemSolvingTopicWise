package LeetCode.DP.DP_2D_3D_GRID;

import java.util.Arrays;

public class Maximum_Number_of_Items_For_Sale_I {

    public static void main(String[] args) {
        Maximum_Number_of_Items_For_Sale_I classObj = new Maximum_Number_of_Items_For_Sale_I();
//        System.out.println(classObj.maximumSaleItems(new int[][]{{6,2},{2,6},{3,4}}, 9));

        System.out.println(classObj.maximumSaleItems(new int[][]{{2,4},{3,2},{4,1},{6,4},{12,4}}, 8));
    }


    public int maximumSaleItems1(int[][] items, int budget) {
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
        for (int price = 0; price <= budget; price++) {
            if (dp[price] != -1) {
                int extraCopies = (budget - price) / minPrice;
                int currentTotal = dp[price] + extraCopies;
                maxTotalItems = Math.max(maxTotalItems, currentTotal);
            }
        }

        return maxTotalItems;
    }



    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] values = new int[n];
        int minPrice = Integer.MAX_VALUE;


        // phase I : collect the values of items and minimum price among all items
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            int val = 1; // we can always buy at least 1 item, so we start with 1

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factor == 0) {
                    val++;
                }
            }

            values[i] = val;
            minPrice = Math.min(minPrice, items[i][1]);
        }

        // phase II
        int[] dp = new int[budget+1];
        Arrays.fill(dp, -1);
        dp[0] = 0; // we know at 0th index, we can get 0 items for 0 price

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int val = values[i];

            // we are iterating from right to left because we want to make sure that
            // we are using the previous values of dp array and not the updated values in the same iteration
            for (int j = budget; j >= price; j--) {
                if (dp[j - price] != -1) {
                    dp[j] = Math.max(dp[j], dp[j - price] + val);
                }
            }
        }


        int maxItems = 0;

        for (int price = 0; price <= budget; price++) {
            if (dp[price] != -1) {
                int budgetLeft = budget - price;
                // we can buy extra copies of the item with minimum price using the remaining budget
                int extraCopies = budgetLeft / minPrice;
                // total items would be the items we can buy with the current price plus the extra copies we can buy with the remaining budget
                int currentTotalItems = dp[price] + extraCopies;

                maxItems = Math.max(maxItems, currentTotalItems);
            }
        }

        return maxItems;
    }

}
