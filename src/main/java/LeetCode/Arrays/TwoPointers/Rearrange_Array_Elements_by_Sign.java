package LeetCode.Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class Rearrange_Array_Elements_by_Sign {

    public static void main(String[] args) {
        Rearrange_Array_Elements_by_Sign classObj = new Rearrange_Array_Elements_by_Sign();
//        for (var i : classObj.rearrangeArrayMostOptimized(new int[]{3, 1, 2, 2, -5, -4})) {
        for (var i : classObj.rearrangeArrayMostOptimized(new int[]{3, 1, -2, -5, 2, -4})) {
            System.out.println(i);
        }
    }

    public int[] rearrangeArray(int[] nums) {

        int n = nums.length;

        // collect positive and negative numbers separately
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int i : nums) {
            if (i >= 0) positive.add(i);
            else negative.add(i);
        }

        int posIndx = 0, negIndx = 0;

        // then merge them back into the original array in the required order
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = positive.get(posIndx++);
            }
            else {
                nums[i] = negative.get(negIndx++);
            }
        }

        return nums;
    }

    public int[] rearrangeArrayOptimized(int[] nums) {

        int n = nums.length;

        // implement two pointers to rearrange the positive and negative
        int posIndx = 0, negIndx = 1;
        int[] result = new int[n];

        for (int i : nums) {
            if (i > 0) {
                result[posIndx] = i;
                posIndx += 2;
            } else {
                result[negIndx] = i;
                negIndx += 2;
            }
        }

        return result;
    }

    public int[] rearrangeArrayMostOptimized(int[] nums) {

        int n = nums.length;

        // implement two pointers to rearrange the positive and negative
        int posIndx = 0, negIndx = 1;
        int[] result = new int[n];

        for (int i = 0; i < n; i+=2) {
            int element = nums[i];
            if (element > 0) {
                result[posIndx] = element;
                posIndx += 2;
            }
            else {
                result[negIndx] = element;
                negIndx += 2;
            }

            element = nums[i+1];
            if (element > 0) {
                result[posIndx] = element;
                posIndx += 2;
            }
            else {
                result[negIndx] = element;
                negIndx += 2;
            }

        }

        return result;
    }


    void placeElement(int[] result, int element, int posIndx, int negIndx) {

        if (element > 0) {
            result[posIndx] = element;
            posIndx += 2;
        }
        else {
            result[negIndx] = element;
            negIndx += 2;
        }

    }


    // If order doesn't matter and also we have equal no. of positive and negatives.
    // So what if positive is not at the correct index, we can get negative and swap it.
    // Same for the negative if it is not at correct index , we can get positive and swap.
    public int[] rearrangeArrayChangedProblemRequirement(int[] nums) {
        int n = nums.length;

        int posIndx = 0, negIndx = 1;

        while (posIndx < n && negIndx < n) {
            if (nums[posIndx] >= 0) posIndx += 2;
            else if (nums[negIndx] < 0) negIndx += 2;
            else {
                int temp = nums[posIndx];
                nums[posIndx] = nums[negIndx];
                nums[negIndx] = temp;
            }
        }

        return nums;
    }


}
