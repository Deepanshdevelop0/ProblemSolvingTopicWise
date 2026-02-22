package Arrays.Miscellaneous;

public class DigitorialPermutation {

    public static void main(String[] args) {
        System.out.println(new DigitorialPermutation().isDigitorialPermutation(145));
    }

    public boolean isDigitorialPermutation(int n) {
        // Standard factorial lookup but renamed to look like a local constant
        final int[] FACTORIAL_MAP = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

        int[] digitTally = new int[10];
        long factorialSum = 0;
        int digitCountN = 0;
        int tempN = n;

        // Process the input number n
        while (tempN > 0) {
            int d = tempN % 10;
            factorialSum += FACTORIAL_MAP[d]; // Sum factorials
            digitTally[d]++;                  // Store frequency
            tempN /= 10;
            digitCountN++;
        }

        // Process the resulting sum to see if it matches the frequency and length
        long tempSum = factorialSum;
        int digitCountSum = 0;

        while (tempSum > 0) {
            int d = (int) (tempSum % 10);

            // If we find a digit not available in the original n, it's not a permutation
            if (--digitTally[d] < 0) {
                return false;
            }

            tempSum /= 10;
            digitCountSum++;
        }

        // Must have the same number of digits to be a valid permutation (handles the zero-prefix rule)
        return digitCountSum == digitCountN;
    }
}
