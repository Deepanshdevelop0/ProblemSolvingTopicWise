package Arrays.Miscellaneous;

public class MergeSortedArray {

    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        MergeSortedArray classObj = new MergeSortedArray();

        System.out.println(nums1[1]);
        int[] nums3 = nums1;
        nums3[1] = 100;
        System.out.println(nums3[1]);


    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] numsNew = new int[m+n];
        int ptr1 = 0, ptr2 = 0, ptrN = 0;


        for (int i = 0; i < n; i++) {

            if (nums1[ptr1] > 0 && nums1[ptr1] < nums2[i]) {
                numsNew[ptrN++] = nums1[ptr1];
                ptr1++;
            }
            else {
                numsNew[ptrN++] = nums2[i];
                ptr2++;
            }


        }

    }

}
