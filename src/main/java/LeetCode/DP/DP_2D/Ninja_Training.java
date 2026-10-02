package LeetCode.DP.DP_2D;

import java.util.Arrays;

public class Ninja_Training {
    public static void main(String[] args) {
        Ninja_Training ninjaTraining = new Ninja_Training();

        int res = ninjaTraining.ninjaTraining(new int[][]{{10, 40, 70}, {20, 50, 80}, {30, 60, 90}});
        System.out.println(res);
    }

    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;

        // recursion
        // return ninjaTrainingRecursive(matrix, 0, -1);

        // dp memoization
        // int[][] dp = new int[matrix.length][3];
        // return ninjaTrainingMemoization(matrix, n, 0, -1, dp);

        // tabulation
        // return ninjaTrainingTabulation(matrix, n);

        // tabulation optimized
        return ninjaTrainingTabulationOptimized(matrix, n);
    }

    public int ninjaTrainingRecursive(int[][] matrix, int indx, int lastUsedIndx) {

        if (indx == matrix.length) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            if (i != lastUsedIndx) {
                int curr = matrix[indx][i] + ninjaTrainingRecursive(matrix, indx + 1, i);
                sum = Math.max(sum, curr);
            }
        }

        return sum;
    }

    public int ninjaTrainingMemoization(int[][] matrix, int n, int indx, int lastUsedIndx, int[][] dp) {
        if (indx == n) {
            return 0;
        }

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            if (i != lastUsedIndx) {
                if (dp[indx][i] == 0) {
                    dp[indx][i] = matrix[indx][i] + ninjaTrainingMemoization(matrix, n, indx + 1, i, dp);
                }
                sum = Math.max(sum, dp[indx][i]);
            }
        }

        return sum;
    }


    public int ninjaTrainingTabulation(int[][] matrix, int n) {

        int[][] dp = new int[n][3];
        for (int i = 0; i < 3; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {

            for (int j = 0; j < 3; j++) {

                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        int curr = matrix[i][j] + dp[i + 1][k];
                        dp[i][j] = Math.max(dp[i][j], curr);
                    }
                }

            }
        }

        int maxSum = 0;

        for (int i = 0; i < 3; i++) {
            maxSum = Math.max(maxSum, dp[0][i]);
        }


        return maxSum;
    }

    public int ninjaTrainingTabulationOptimized(int[][] matrix, int n) {

        int[] dp = new int[3];
        for (int i = 0; i < 3; i++) {
            dp[i] = matrix[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {

            int[] temp = new int[3];

            for (int j = 0; j < 3; j++) {

                for (int k = 0; k < 3; k++) {
                    if (k != j) {
                        int curr = matrix[i][j] + dp[k];
                        temp[j] = Math.max(temp[j], curr);
                    }
                }
            }

            dp = temp;
        }

        int maxSum = 0;
        for (int i : dp) {
            maxSum = Math.max(maxSum, i);
        }

        return maxSum;
    }


}
