package LeetCode.BinarySearch.Answers;

public class Split_Array_Largest_Sum {

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
        Split_Array_Largest_Sum classObj = new Split_Array_Largest_Sum();
        int res = classObj.splitArrayBinarySearch(new int[]{7,2,5,10,8}, 2);
        System.out.println("result = " + res);

        int res1 = classObj.splitArrayBinarySearch(new int[]{1,2,3,4,5}, 3);
        System.out.println("result = " + res1);

        int res2 = classObj.splitArrayBinarySearch(new int[]{1,2,3,4,5}, 1);
        System.out.println("result = " + res2);
    }

    public int splitArrayBruteForce(int[] nums, int k) {

        if (k > nums.length) return -1;

        long low = 0, high = 0;

        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {
            if (canSplit(nums, k, low)) {
                return (int) low;
            }
            low++;
        }

        return -1;
    }

    public int splitArrayBinarySearch(int[] nums, int k) {

        if (k > nums.length) return -1;

        long low = 0, high = 0;

        for (int i : nums) {
            low = Math.max(low, i);
            high += i;
        }

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    public boolean canSplit(int[] nums, int k, long max) {

        long currSum = 0, currK = 1;

        for (int i : nums) {
            if (currSum + i > max) {
                currSum = i;
                currK++;
                if (currK > k) {
                    return false;
                }
                continue;
            }

            currSum += i;
        }

        return true;
    }

}
