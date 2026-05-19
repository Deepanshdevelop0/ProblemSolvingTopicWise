package LeetCode.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        System.out.println((int) Math.cbrt(28));

        MergeSort classObj = new MergeSort();
        int[] arr = new int[]{5,3,2,9,3,4};
        int[] helper = new int[arr.length];

        classObj.mergeSort(arr, 0, arr.length - 1, helper);

        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    public void mergeSort(int arr[], int l, int r, int[] helper) {

        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid, helper);

        mergeSort(arr, mid+1, r, helper);

//        merge(arr, l, mid, r);
        mergeSpaceOptimized(arr, l, mid, r, helper); // improved for boxing/unboxing from List type, instead used int[]

    }


    void mergeSpaceOptimized(int[] arr, int l, int mid, int r, int[] helper) {

        int low = l, high = mid+1;
        int k = l;

        while (low <= mid && high <= r) {

            if (arr[low] <= arr[high]) {
                helper[k++] = arr[low++];
            }
            else {
                helper[k++] = arr[high++];
            }

        }

        while (low <= mid) {
            helper[k++] = arr[low++];
        }

        while (high <= r) {
            helper[k++] = arr[high++];
        }

        while (l <= r) {
            arr[l] = helper[l++];
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
