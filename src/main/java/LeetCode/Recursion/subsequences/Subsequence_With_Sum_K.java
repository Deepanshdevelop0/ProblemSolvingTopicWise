package LeetCode.Recursion.subsequences;

public class Subsequence_With_Sum_K {


    public static void main(String[] args) {
        Subsequence_With_Sum_K classObj = new Subsequence_With_Sum_K();

        System.out.println(classObj.checkSubsequenceSumMemoized(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));

    }

    public boolean checkSubsequenceSumRecursive(int[] arr, int k) {
        return checkRecursively(arr, arr.length, k, 0, 0);
    }
    public boolean checkSubsequenceSumMemoized(int[] arr, int k) {
        int n = arr.length;
        Boolean[][] dp = new Boolean[n][k+1];
        return checkRecursiveMemoized(arr, arr.length, k, 0, 0, dp);
    }

    public boolean checkRecursively(int[] arr, int n, int k, int i, int sum) {
        if (sum == k) return true;
        if (i >= n) return false;
        if (sum > k) return false;

        boolean take = checkRecursively(arr, n, k, i+1, sum + arr[i]);
        boolean notTake = checkRecursively(arr, n, k, i+1, sum);

        return take || notTake;
    }

    public boolean checkRecursiveMemoized(int[] arr, int n, int k, int i, int sum, Boolean[][] dp) {
        if (sum == k) return true;
        if (i >= n) return false;
        if (sum > k) return false;

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        boolean take = checkRecursiveMemoized(arr, n, k, i+1, sum + arr[i], dp);
        boolean notTake = checkRecursiveMemoized(arr, n, k, i+1, sum, dp);

        return dp[i][sum] = take || notTake;
    }




/*

Subsequence with Sum K

Given an array arr and target sum k, check whether there exists a subsequence such that the sum of all elements in the subsequence equals to k.

Examples:

Input: arr = [10, 1, 2, 7, 6, 1, 5], k = 8.

Output: true
Explanation: Subsequences like [2, 6], [1, 7] sum upto 8

Input: arr = [2, 3, 5, 7, 9], k = 100.

Output: false
Explanation: No subsequence can sum upto 100


Constraints:
1 ≤ arr.length ≤ 2000
1 ≤ arr[i] ≤ 1000
1 ≤ target ≤ 2000
*/

}
