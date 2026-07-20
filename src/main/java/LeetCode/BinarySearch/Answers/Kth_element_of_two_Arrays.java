package LeetCode.BinarySearch.Answers;

public class Kth_element_of_two_Arrays {

    public static void main(String[] args) {
        Kth_element_of_two_Arrays classObj = new Kth_element_of_two_Arrays();

        int res = classObj.kthElementBinarySearch(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5);
        System.out.println("result : " + res);

        int res1 = classObj.kthElement(new int[]{1, 4, 8, 10, 12}, new int[]{5, 7, 11, 15, 17}, 6);
        System.out.println("result1 : " + res1);

        int res2 = classObj.kthElement(new int[]{1, 2, 3, 6}, new int[]{8, 9, 10, 12, 14}, 6);
        System.out.println("result2 : " + res2);

        int res3 = classObj.kthElementBinarySearch(new int[]{14, 15}, new int[]{1, 2, 3, 6}, 6);
        System.out.println("result2 : " + res3);
    }

    public int kthElement(int a[], int b[], int k) {

        int n = a.length, m = b.length;

        int i = 0, j = 0;

        while (i < n && j < m) {

            if (i + j + 1 == k) {
                return Math.min(a[i], b[j]);
            } else if (a[i] <= b[j]) {
                i++;
            } else {
                j++;
            }
        }

        int countedElements = i + j + 1;

        if (i < n) {
            while (i < n && i + j + 1 < k) {
                i++;
            }
            if (i + j + 1 == k) {
                return a[i];
            }
        } else if (j < m) {
            while (j < m && i + j + 1 < k) {
                j++;
            }
            if (i + j + 1 == k) {
                return b[j];
            }
        }

        return -1;
    }

    public int kthElementBinarySearch(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;

        // Ensure 'a' is the smaller array to optimize binary search
        if (n1 > n2) {
            return kthElementBinarySearch(b, a, k);
        }

        /*
         * low = Math.max(0, k - n2)
         * If our target 'k' exceeds arr2's total size ('n2'), we are physically forced
         * to take the missing deficit (k - n2) from arr1. This prevents us from
         * guessing an impossible amount from arr2 and throwing an OutOfBounds error.
         *
         * Ex: n1 = 5, n2 = 2, k = 6
         * Bad: Guess 0 from arr1 -> Need 6 from arr2 (Crash: n2 is only 2!)
         * Fix: k - n2 (6 - 2 = 4) -> We MUST take at least 4 from arr1. 'low' becomes 4.
         */
        int low = Math.max(0, k - n2), high = Math.min(k, n1);

        while (low <= high) {

            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            // Took too many large elements from 'a', move left
            else if (l1 > r2) {
                high = mid1 - 1;
            }
            // l2 > r1: We didn't take enough elements from 'a', move right
            // means array 'a' have more small elements compared to l2
            else {
                low = mid1 + 1;
            }

        }

        return -1;
    }


}
