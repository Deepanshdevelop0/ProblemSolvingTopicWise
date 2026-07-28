package LeetCode.Recursion.basic;

public class CountGoodNumbers {

    public static void main(String[] args) {
        CountGoodNumbers classObj = new CountGoodNumbers();

        int res = classObj.countGoodNumbers(50);

        System.out.println("result : " + res);
    }

    private static int MOD = 1_000_000_007;
    private static int[] evens = new int[]{0, 2, 4, 6, 8};
    private static int[] primes = new int[]{2, 3, 5, 7};


    public int countGoodNumbers(long n) {
        return createGoodNumbers(0, n);
    }


    public int createGoodNumbers(long indx, long n) {
        if (indx == n) {
            return 1;
        }

        int res = 0;

        if (indx % 2 == 0) {

            for (int even : evens) {
                res = (res + createGoodNumbers(indx + 1, n)) % MOD;
            }
        }
        else {

            for (int prime : primes) {
                res = (res + createGoodNumbers(indx + 1, n)) % MOD;
            }
        }

        return res;
    }

}
