package LeetCode.BinarySearch.Answers;

public class Kth_element_of_two_Arrays {

    public static void main(String[] args) {
        Kth_element_of_two_Arrays classObj = new Kth_element_of_two_Arrays();

        int res = classObj.kthElement(new int[]{2, 3, 6, 7, 9}, new int[]{1, 4, 8, 10}, 5);
        System.out.println("result : " + res);

        int res1 = classObj.kthElement(new int[]{1, 4, 8, 10, 12}, new int[]{5, 7, 11, 15, 17}, 6);
        System.out.println("result1 : " + res1);

        int res2 = classObj.kthElement(new int[]{1, 2, 3, 6}, new int[]{8, 9, 10, 12, 14}, 6);
        System.out.println("result2 : " + res2);
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
}
