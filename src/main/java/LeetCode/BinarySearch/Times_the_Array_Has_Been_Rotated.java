package LeetCode.BinarySearch;

public class Times_the_Array_Has_Been_Rotated {

/*

findKRotation :

TC : O(n), using min (value and index)
SC : O(1) as we are using only a constant amount of extra space for the variables to store the minimum value and its index.

findKRotationBetter :

TC : O(n) in worst case, when array is not rotated or rotated n times, we have to traverse the entire array to find the point of rotation.
SC : O(1) as we are using only a constant amount of extra space for the loop variable and the condition check.

findKRotationOptimal :

TC : O(log n) in the average and worst case, as we are using a binary search approach to find the point of rotation. In the best case, when the array is not rotated, it will be O(1) as we will check the first and last elements and return 0 immediately.
SC : O(1) as we are using only a constant amount of extra space for the variables to store the start, end, and mid indices, and we are not using any additional data structures.

*/
    public static void main(String[] args) {
        Times_the_Array_Has_Been_Rotated obj = new Times_the_Array_Has_Been_Rotated();

        // Example input I
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int rotations = obj.findKRotationOptimal(arr);
        System.out.println(rotations);

        // Example input II
        int[] arr1 = {2, 3, 4, 5, 1};
        int rotations1 = obj.findKRotationOptimal(arr1);
        System.out.println(rotations1);

        // Example input III
        int[] arr2 = {5, 1};
        int rotations2 = obj.findKRotationOptimal(arr2);
        System.out.println(rotations2);
    }


    public int findKRotation(int arr[]) {
        int n = arr.length;
        int minVal = Integer.MAX_VALUE, minIndx = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] < minVal) {
                minVal = arr[i];
                minIndx = i;
            }
        }

        return minIndx;
    }


    public int findKRotationBetter(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i + 1;
            }
        }

        return 0;
    }

    public int findKRotationOptimal(int arr[]) {
        int n = arr.length;
        int start = 0, end = n - 1, mid = 0;

        while (start < end) {

            mid = (start + end) / 2;

            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }


}
