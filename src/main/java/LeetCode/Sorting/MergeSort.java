package LeetCode.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        System.out.println((int) Math.cbrt(28));

//        MergeSort classObj = new MergeSort();
//        int[] arr = new int[]{5,3,2,9,3,4};
//        classObj.mergeSort(arr, 0, arr.length - 1);
//
//        for (int i : arr) {
//            System.out.print(i + ", ");
//        }
    }

    public void mergeSort(int arr[], int l, int r) {

        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);

        mergeSort(arr, mid+1, r);

//        mergeIntial(arr, l, mid, r);
        mergeImproved(arr, l, mid, r); // improved for boxing/unboxing from List type, instead used int[]

    }


    void mergeImproved(int[] arr, int l, int mid, int r) {

        int[] res = new int[r - l + 1];
        int low = l, high = mid+1;
        int k = 0;

        while (low <= mid && high <= r) {

            if (arr[low] <= arr[high]) {
                res[k++] = arr[low++];
            }
            else {
                res[k++] = arr[high++];
            }

        }

        while (low <= mid) {
            res[k++] = arr[low++];
        }

        while (high <= r) {
            res[k++] = arr[high++];
        }

        for (int i : res) {
            arr[l++] = i;
        }

    }

    void merge(int[] arr, int l, int mid, int r) {

        List<Integer> res = new ArrayList<>();

        int low = l, high = mid+1;

        while (low <= mid && high <= r) {

            if (arr[low] <= arr[high]) {
                res.add(arr[low++]);
            }
            else {
                res.add(arr[high++]);
            }
        }

        while (low <= mid) {
            res.add(arr[low++]);
        }

        while (high <= r) {
            res.add(arr[high++]);
        }

        for (int i : res) {
            arr[l++] = i;
        }

    }

}
