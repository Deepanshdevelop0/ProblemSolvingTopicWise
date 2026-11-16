package LeetCode.Arrays.Miscellaneous;

public class Calculate_Money_in_Leetcode_Bank {

    public static void main(String[] args) {

        Calculate_Money_in_Leetcode_Bank classObj = new Calculate_Money_in_Leetcode_Bank();

        System.out.println(classObj.totalMoneyOptimized(20));

    }
    public int totalMoney(int n) {
        int initial = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += initial;
            if (i % 7 == 0) initial = (i / 7) + 1;
            else initial++;
        }

        return sum;
    }

    public int totalMoneyOptimized(int n) {
        int w = n / 7;
        int d = n % 7;

        // For 'w' weeks: base sum of 28 per week + an extra 7 for each subsequent week.
        // The extra 7s form the progression: 0 + 7 + 14 + ... which sums to 7 * (w * (w - 1) / 2).
        int weeksSum = (28 * w) + (7 * (w * (w - 1) / 2));

        // if w = 4 are over, curr w = 5, that is our starting point for the days, so we need to add 5 to each day
        // For 'd' days: the starting deposit on Monday is (w + 1).
        // d * (w + 1) is the flat base amount if every day deposited the same as Monday.
        // (d * (d - 1) / 2) adds the increasing +1, +2, +3... for each subsequent day.
        int leftDaysSum = d * (w + 1) +  (d * (d - 1) / 2);

        return weeksSum + leftDaysSum;
    }


}
