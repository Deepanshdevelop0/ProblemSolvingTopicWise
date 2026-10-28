package LeetCode.Greedy.Problems;

import java.util.Arrays;

public class Maximize_Sum_After_At_Most_K_Digit_Rearrangements {

    public static void main(String[] args) {
        Maximize_Sum_After_At_Most_K_Digit_Rearrangements classObj = new Maximize_Sum_After_At_Most_K_Digit_Rearrangements();
        long res = classObj.maximizeSum(new int[]{999, 129}, 1);
        System.out.println(res);

    }

    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int[] gains = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int newNum = rearrange(num);
            sum += nums[i];

            gains[i] = newNum - num;
        }

        Arrays.sort(gains);

        for (int i = n - 1; i >= n - k; i--) {
            sum += gains[i];
        }

        return sum;
    }

    public int rearrange(int num) {
        int[] freq = new int[10];

        while (num > 0) {
            int last = num % 10;
            num /= 10;

            freq[last]++;
        }

        int newNum = 0;

        for (int i = 9; i >= 0; i--) {
            int count = freq[i];
            for (int j = 0; j < count; j++) {
                newNum *= 10;
                newNum += i;
            }
        }

        return newNum;
    }

}
