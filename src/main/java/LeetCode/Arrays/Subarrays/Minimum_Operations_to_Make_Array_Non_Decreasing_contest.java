package LeetCode.Arrays.Subarrays;

public class Minimum_Operations_to_Make_Array_Non_Decreasing_contest {

    public static void main(String[] args) {
        Minimum_Operations_to_Make_Array_Non_Decreasing_contest solution = new Minimum_Operations_to_Make_Array_Non_Decreasing_contest();

        // Test Case 1
        int[] nums1 = {3, 3, 2, 1};
        long result1 = solution.minOperations(nums1);
        System.out.println("Test Case 1: " + java.util.Arrays.toString(nums1));
        System.out.println("Expected: 2");
        System.out.println("Actual:   " + result1);
        System.out.println("---");

        // Test Case 2
        int[] nums2 = {5, 1, 2, 3};
        long result2 = solution.minOperations(nums2);
        System.out.println("Test Case 2: " + java.util.Arrays.toString(nums2));
        System.out.println("Expected: 4");
        System.out.println("Actual:   " + result2);
        System.out.println("---");

        // Custom Test Case (Strictly increasing - should be 0)
        int[] nums3 = {1, 2, 3, 4, 5};
        long result3 = solution.minOperations(nums3);
        System.out.println("Test Case 3: " + java.util.Arrays.toString(nums3));
        System.out.println("Expected: 0");
        System.out.println("Actual:   " + result3);
    }

    public long minOperations(int[] nums) {

        long ops = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i-1]) {
                int diff = nums[i-1] - nums[i];
                ops += diff;

                for (int j = i; j < n; j++) {
                    nums[j] += diff;
                }

            }
        }

        return ops;
    }

    public long minOperationsOptimal(int[] nums) {

        long ops = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++) {

            // check for a drop, as if current element is smaller than previous one
            if (nums[i] < nums[i-1]) {

                // calculate how much the current index needs to be increased to make it ( >= i-1 )
                // and if ran till end index to add to all indexes then the exact difference would be calculated every time
                // which means (calculating + adding to all right ones) == (calculating + not adding to all right ones)

                // -------------------------------- Just for reference (its very easy) --------------------------------------
                // MATHEMATICAL PROOF (Why we don't need an inner loop)
                // Test Case: [5, 2, 4, 1]
                //
                // When i = 1, we see a drop from 5 to 2. Difference = 3.
                // If we simulated this (added 3 to all elements on the right):
                //   -> [5, 2, 4, 1] becomes [5, 5, 7, 4]
                //
                // When we eventually get to the end of the array (i = 3):
                //   -> The simulated array drops from 7 to 4. (Difference = 3)
                //   -> Our original array drops from 4 to 1. (Difference = 3)
                //
                // Because we conceptually add the EXACT SAME amount to every element
                // on the right, the relative distance between them NEVER changes!
                //
                // Therefore:
                // (calculating + adding to all right ones) == (calculating + not adding)
                // ----------------------------------------------------------------------

                ops += nums[i-1] - nums[i];
            }
        }

        return ops;
    }
}
