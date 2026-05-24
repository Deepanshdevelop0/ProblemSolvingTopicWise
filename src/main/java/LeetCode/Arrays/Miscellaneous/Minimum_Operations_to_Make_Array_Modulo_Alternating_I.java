package LeetCode.Arrays.Miscellaneous;

public class Minimum_Operations_to_Make_Array_Modulo_Alternating_I {

    public static void main(String[] args) {
        Minimum_Operations_to_Make_Array_Modulo_Alternating_I classObj = new Minimum_Operations_to_Make_Array_Modulo_Alternating_I();
        int res = classObj.minOperations(new int[]{1, 4, 2, 8}, 3);
        System.out.println(res);
    }

    public int minOperations(int[] nums, int k) {
        int n = nums.length;

        int[] evenIndxCost = new int[k];
        int[] oddIndxCost = new int[k];


        for (int i = 0; i < n; i += 2) {
            int currRemainder = nums[i] % k;

            for (int target = 0; target < k; target++) {
                evenIndxCost[target] += getMinOps(currRemainder, target, k);
            }
        }

        for (int i = 1; i < n; i += 2) {
            int currRemainder = nums[i] % k;

            for (int target = 0; target < k; target++) {
                oddIndxCost[target] += getMinOps(currRemainder, target, k);
            }
        }

        int absMinCost = Integer.MAX_VALUE;

        for (int even = 0; even < k; even++) {
            for (int odd = 0; odd < k; odd++) {

                if (even == odd) continue;

                int totalCost = evenIndxCost[even] + oddIndxCost[odd];

                if (totalCost < absMinCost) {
                    absMinCost = totalCost;
                }
            }

        }

        return absMinCost;
    }

    private int getMinOps(int current, int target, int k) {
        int normalDifference = Math.abs(current - target);
        int wrappedDifference = k - normalDifference;

        return Math.min(normalDifference, wrappedDifference);
    }

}
