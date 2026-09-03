package LeetCode.NumberTheory.Miscellaneous;

public class Sum_of_Decoded_Numbers {

    public static void main(String[] args) {
        Sum_of_Decoded_Numbers classObj = new Sum_of_Decoded_Numbers();
        System.out.println(classObj.sumDecoded(new long[]{2522,2101}));
        System.out.println(classObj.sumDecoded(new long[]{2301}));
        System.out.println(classObj.sumDecoded(new long[]{55162,86552}));
    }

    private int MOD = 1000000007;

    public int sumDecoded(long[] nums) {
        int resSum = 0;

        for (long num : nums) {
            int width = (int) (num % 10);
            long d = num / 10;

            int totalDigits = (int) Math.log10(d) + 1;
            int yDigits = totalDigits - width;
            long divisor = (long) Math.pow(10, yDigits);

            long x = d / divisor;
            long y = d % divisor;

            resSum = (int) ((resSum + powerMod(x, y)) % MOD);
        }

        return resSum;
    }

    private long powerMod(long base, long exponent) {
        long res = 1;

        base = base % MOD;

        while (exponent > 0) {

            if (exponent % 2 == 1) {
                res = (res * base) % MOD;
            }

            base = (base * base) % MOD;
            exponent /= 2;
        }

        return res;
    }
}
