package LeetCode.BinarySearch.Answers;

public class The_Painters_Partition_Problem_II {

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
        The_Painters_Partition_Problem_II classObj = new The_Painters_Partition_Problem_II();
        int res = classObj.minTimeBinarySearch(new int[]{5, 10, 30, 20, 15}, 3);
        System.out.println("result : " + res);
    }

    public int minTimeBruteForce(int[] arr, int k) {
        if (k > arr.length) return -1;

        long max = 0, total = 0; // just for understanding, otherwise would have named it low and high

        for (int i : arr) {
            max = Math.max(max, i);
            total += i;
        }

        long low = max, high = total;

        while (low <= high) {

            if (canPaintAllBoards(arr, k, low)) {
                return (int) low;
            }

            low++;
        }

        return -1;
    }

    public int minTimeBinarySearch(int[] arr, int k) {
        if (k > arr.length) return -1;

        long max = 0, total = 0; // just for understanding, otherwise would have named it low and high

        for (int i : arr) {
            max = Math.max(max, i);
            total += i;
        }

        long low = max, high = total;

        while (low <= high) {

            long mid = low + (high - low) / 2;

            if (canPaintAllBoards(arr, k, mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

//    30 - 80 : 55
//    30 - 54 : 42
//    30 - 41 : 35
//    30 - 34 : 32
//    33 - 34 : 33
//    34 - 34 : 34
//    35 - 34 (while loop ends here)


    public boolean canPaintAllBoards(int[] arr, int k, long maxLength) {

        long currentLength = 0, currentBoards = 1;

        for (int i : arr) {

            if (currentLength + i > maxLength) {
                currentLength = i;
                currentBoards++;

                if (currentBoards > k) {
                    return false;
                }
                continue;
            }

            currentLength += i;
        }

        return true;
    }


}
