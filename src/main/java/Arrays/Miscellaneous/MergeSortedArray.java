package Arrays.Miscellaneous;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,3,4,5,0,0,0};
        int[] nums1 = new int[]{0,0,0};
        int[] nums2 = new int[]{2,5,6};

        MergeSortedArray classObj = new MergeSortedArray();

        classObj.merge(nums1, 0, nums2, 3);

        for (int i : nums1) {
            System.out.println(i);
        }


    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        int[] newNums = new int[m+n];
        int ptr1 = 0, ptr2 = 0;

        for (int i = 0; i < newNums.length; i++) {
            if (nums1[ptr1] != 0 && (nums1[ptr1] < nums2[ptr2])) {
                newNums[i] = nums1[ptr1++];
            }
            else {
                newNums[i] = ptr2 < n ? nums2[ptr2++] : 0;
            }
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = newNums[i];
        }

    }


    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        if (n == 0) {
            return;
        }

        int ptr = nums1.length - 1, ptr1 = m-1, ptr2 = n-1;

        while (ptr2 >= 0) {
            // If nums1 still has elements and its current element is larger than nums2's
            if (ptr1 >= 0 && nums1[ptr1] > nums2[ptr2]) {
                nums1[ptr--] = nums1[ptr1--];
            }
            else {
                // Otherwise, nums2 has the larger element (or nums1 is empty)
                nums1[ptr--] = nums2[ptr2--];
            }

        }

    }

}
