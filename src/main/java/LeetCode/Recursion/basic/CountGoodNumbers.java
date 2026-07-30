package LeetCode.Recursion.basic;

public class CountGoodNumbers {

/*

Not Needed : Recursion (create all combinations which is not needed as could be calculated without creating them)

TC : O(5 ^ n/2 x 4 ^ n/2) = O(20 ^ n/2)
1. Each call takes O(log evens) and O(log odds) which is O(log n) in worst case.

SC : O(n)
1. We use a constant number of variables (no recursion or extra space).

--------------------------------------------------------------------
Optimal : Binary Exponentiation

TC : O(log n)
1. Each call takes O(log evens) and O(log odds) which is O(log n) in worst case.

SC : O(log n)
1. We use a constant number of variables (no recursion or extra space).



*/


    public static void main(String[] args) {
        CountGoodNumbers classObj = new CountGoodNumbers();

        int res = classObj.countGoodNumbersOptimal(50);

        System.out.println("result : " + res);
    }

    private static int MOD = 1_000_000_007;
    private static int[] evens = new int[]{0, 2, 4, 6, 8};
    private static int[] primes = new int[]{2, 3, 5, 7};


    public int countGoodNumbersNotNeeded(long n) {
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
        } else {

            for (int prime : primes) {
                res = (res + createGoodNumbers(indx + 1, n)) % MOD;
            }
        }

        return res;
    }


    public int countGoodNumbersOptimal(long n) {

        long evens = (n + 1) / 2;
        long odds = n / 2;

        long pow5 = powerHelper(5, evens, MOD);
        long pow4 = powerHelper(4, odds, MOD);

        return (int) ((pow5 * pow4) % MOD);
    }

    public long powerHelper(long base, long exp, long mod) {
        long res = 1;

        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % mod;
            // yaha ek condition ho sakti thi as 'if (exp == 1) break;' taaki aage naa chal paye loop but its okay to run loop further
            // as yaha break naa karne se res modify nahi hoga just base modify hoga, wo bhi last time so no issues
            // humari return value to res hai and wo unaffected hai
            base = (base * base) % mod;
            exp /= 2;
        }

        return res;
    }

}
