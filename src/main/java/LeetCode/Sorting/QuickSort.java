package LeetCode.Sorting;

public class QuickSort {

    public static void main(String[] args) {

        QuickSort classObj = new QuickSort();

        int[] arr = {10, 7, 8, 9, 1, 5};

        classObj.quickSort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr)
            System.out.print(num + " ");

    }


    void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            // Find pivot index
            int pivot = partition(arr, low, high);

            // sort left subarray
            quickSort(arr, low, pivot-1);

            // sort right subarray
            quickSort(arr, pivot + 1, high);
        }

    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low;

        // Choose last element as pivot
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        // Place pivot in correct position
        int temp = arr[j];
        arr[j] = arr[high];
        arr[high] = temp;

        return j;
    }


}
