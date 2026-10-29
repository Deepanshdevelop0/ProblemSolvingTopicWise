package LeetCode.DP.Stocks;

public class Best_Time_to_Buy_and_Sell_Stock {

    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock classObj = new Best_Time_to_Buy_and_Sell_Stock();
        int res = classObj.maxProfitOptimal(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(res);
    }

    public int maxProfitBruteForce(int[] prices) {

        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n - 1; i++) {
            int minPrice = prices[i];
            for (int j = i + 1; j < n; j++) {
                int currPrice = prices[j];
                maxProfit = Math.max(maxProfit, currPrice - minPrice);
            }
        }

        return maxProfit;
    }

    public int maxProfitOptimal(int[] prices) {

        int n = prices.length;
        int[] minPrices = new int[n];
        minPrices[0] = prices[0];

        for (int i = 1; i < n; i++) {
            minPrices[i] = Math.min(minPrices[i-1], prices[i]);
        }

        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrices[i]);
        }

        return maxProfit;
    }
    public int maxProfitMostOptimal(int[] prices) {

        int n = prices.length;
        int minPrice = prices[0], maxProfit = 0;

        for (int i = 0; i < n; i++) {
            int currPrice = prices[i];
            if (currPrice < minPrice) {
                minPrice = currPrice;
            } else {
                maxProfit = Math.max(maxProfit, currPrice - minPrice);
            }
        }

        return maxProfit;
    }

}
