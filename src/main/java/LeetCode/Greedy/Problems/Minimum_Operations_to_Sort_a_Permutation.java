package LeetCode.Greedy.Problems;

public class Minimum_Operations_to_Sort_a_Permutation {

/*

Time complexity : O(N)
 ~ One pass of array + O(1) other operations

Space complexity : O(1)
 ~ Constant size variables

*/
    public static void main(String[] args) {
        Minimum_Operations_to_Sort_a_Permutation classObj = new Minimum_Operations_to_Sort_a_Permutation();
        System.out.println(classObj.minOperations(new int[]{2,3,4,5,0,1}));
        System.out.println(classObj.minOperations(new int[]{3,2,1,0,5,4}));
    }

    public int minOperations(int[] nums) {
        int n = nums.length;

        int p = -1;
        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                p = i;
            }

            int curr = nums[i];
            int next = nums[(i + 1) % n]; // next element

            if (next != (curr + 1) % n) {
                isAscending = false;
            }

            // FIX: Added + n to handle Java's negative modulo behavior
            if (next != (curr - 1 + n) % n) {
                isDescending = false;
            }
        }

        if (!isAscending && !isDescending) {
            return -1;
        }

        int minOps = Integer.MAX_VALUE;

        if (isAscending) {
//            case 1 : 4,5,0,1,2,3 -> 5,0,1,2,3,4 -> 0,1,2,3,4,5
//            case 2 : 1,2,3,4,5,0 -> 0,5,4,3,2,1 -> 5,4,3,2,1,0 -> 0,1,2,3,4,5 = 3 = n - p + 2
//            case 3 : 2,3,4,5,0,1 -> 1,0,5,4,3,2 -> 0,5,4,3,2,1 -> 5,4,3,2,1,0 -> 0,1,2,3,4,5 = 4 = n - p + 2

            if (p == 0) {
                minOps = Math.min(minOps, p);
            }
            else {
                int leftRotations = p;
                int simulatedRightRotations = n - p + 2;

                minOps = Math.min(minOps, Math.min(leftRotations, simulatedRightRotations));
            }
        }

        if (isDescending) {
//            case 1 : 0,5,4,3,2,1 -> 5,4,3,2,1,0 -> 0,1,2,3,4,5 = 2 = p + 2
//            case 2 : 2,1,0,5,4,3 -> 1,0,5,4,3,2 -> 0,5,4,3,2,1 -> 5,4,3,2,1,0 -> 0,1,2,3,4,5 = 4 = ((p+1) % n) + 1
//            case 3 : 3,2,1,0,5,4 -> 4,5,0,1,2,3 -> 5,0,1,2,3,4 -> 0,1,2,3,4,5 = n - p

//            +1 for reverse
                int leftRotations = ((p + 1) % n) + 1;
                int reverseThenRotate = n - p;

                minOps = Math.min(minOps, Math.min(leftRotations, reverseThenRotate));
        }

        return minOps;
    }


}
