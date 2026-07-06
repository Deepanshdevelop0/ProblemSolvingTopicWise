package LeetCode.BinarySearch.Answers;

public class Find_the_Smallest_Divisor_Given_a_Threshold {



/*

Binary Search on Answers

TC : O(log(max_val) x N) + O(N) ~ O(N log max_val)

1. Search high in array - O(N)
2. Binary search in range 1 - max no in array - O(log(max_val))
3. for each op in binary search, calculate sum in array - O(N)

SC : O(1) - Constant space

*/
    public static void main(String[] args) {
        Find_the_Smallest_Divisor_Given_a_Threshold classObj = new Find_the_Smallest_Divisor_Given_a_Threshold();

//        int res = classObj.smallestDivisor(new int[]{1,2,5,9}, 6);
//        System.out.println("result : " + res);

        int res1 = classObj.smallestDivisor(new int[]{44,22,33,11,1}, 5);
        System.out.println("result : " + res1);

    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;

        for (int i : nums) {
            high = Math.max(high, i);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canDivide(nums, threshold, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    private boolean canDivide(int[] nums, int threshold, int num) {
        int sum = 0;

        for (int i : nums) {
            sum += ((i + num - 1) / num);
        }

        return sum <= threshold;
    }


}
