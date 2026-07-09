package LeetCode.BinarySearch.Answers;

public class Book_Allocation_Problem {


/*

1. BruteForce : Linear search

TC : O(N * (sum(arr) - max(arr) + 1))

1. N = size of the array
2. sum(arr) = sum of all array elements
3. max(arr) = max of all array elements

SC : O(1) : constant space variables

---------------------------------------------------

Optimal : Binary search on Answers

TC : O(N * log(sum(arr) - max(arr) + 1)) : for binary search

1. N = size of the array
2. sum(arr) = sum of all array elements
3. max(arr) = max of all array elements

SC : O(1) : constant space variables

*/
    public static void main(String[] args) {
        Book_Allocation_Problem classObj = new Book_Allocation_Problem();
        int res = classObj.findPagesBinarySearch(new int[]{12, 34, 67, 90}, 2);
        System.out.println("result = " + res);

        int res1 = classObj.findPagesBinarySearch(new int[]{12, 34, 67, 90}, 5);
        System.out.println("result = " + res1);
    }

    public int findPagesBruteForce(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        long low = 0, high = 0;

        for (int i : arr) {
            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {

            if (canBeAllocated(arr, k, low)) {
                return (int) low;
            }

            low++;
        }

        return -1;
    }

    public int findPagesBinarySearch(int[] arr, int k) {

        if (k > arr.length) {
            return -1;
        }

        long low = 0, high = 0;

        for (int i : arr) {
            low = Math.max(low, i);
            high += i;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canBeAllocated(arr, k, mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return (int) high;
    }




    public boolean canBeAllocated(int[] arr, int k, long maxPages) {

        long curr = 0, currStudents = 1;

        for (int i : arr) {
            if (i + curr > maxPages) {
                curr = i;
                currStudents++;
                if (currStudents > k) {
                    return false;
                }
                continue;
            }

            curr += i;
        }

        return true;
    }

}
