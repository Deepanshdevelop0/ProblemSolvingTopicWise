package LeetCode.BinarySearch.Answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Median_of_two_sorted_arrays {

    public static void main(String[] args) {

        Median_of_two_sorted_arrays classObj = new Median_of_two_sorted_arrays();

//        double res = classObj.findMedianSortedArraysOptimal(new int[]{1, 3}, new int[]{2});
//        System.out.println("result : " + res);
//
//        double res1 = classObj.findMedianSortedArraysOptimal(new int[]{1, 2}, new int[]{3, 4});
//        System.out.println("result 1 : " + res1);

        double res2 = classObj.findMedianSortedArraysOptimal(new int[]{1, 12, 15, 26, 38, 42}, new int[]{2, 13, 17, 30, 45, 60});
        System.out.println("result 2 : " + res2);

    }

    public double findMedianSortedArraysBruteForce(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        int maxLen = Math.max(n1, n2);

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            if (i < n1) {
                list.add(nums1[i]);
            }

            if (i < n2) {
                list.add(nums2[i]);
            }
        }

        Collections.sort(list);

        if ((n1 + n2) % 2 != 0) {
            return (double) list.get((n1 + n2) / 2);
        }

        int mid = (n1 + n2) / 2;

        double res = (double) (list.get(mid - 1) + list.get(mid)) / 2;

        return res;
    }


    public double findMedianSortedArraysOptimal(int[] nums1, int[] nums2) {

        int n = nums1.length, m = nums2.length;

        if (n > m) {
            return findMedianSortedArraysOptimal(nums2, nums1);
        }

        int low = 0, high = n;

        while (low <= high) {

            int mid1 = (low + high) / 2;
            int mid2 = ((n + m + 1) / 2) - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == n) ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == m) ? Integer.MAX_VALUE : nums2[mid2];

            // if it is a valid partition
            if (l1 <= r2 && l2 <= r1) {

                if ((n + m) % 2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1, r2)) / 2.0;
                }
                else {
                    return Math.max(l1, l2);
                }
            }

            if (l1 > r2) {
                high = mid1 - 1;
            }
            else {
                low = mid1 + 1;
            }

        }

        return 0;
    }

}
