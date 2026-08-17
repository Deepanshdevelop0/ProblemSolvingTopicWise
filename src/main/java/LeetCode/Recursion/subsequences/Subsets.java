package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

/*

method : subsets (createSubsets)

* Time Complexity: O(N * 2^N)

Explanation: We generate 2^N subsets. Every time we hit the base case, we copy the subList into a new array.
Since the maximum length of the subset is N, copying takes O(N) time.
Thus, the total time complexity is O(N * 2^N).

1. Total Subsets: A set of size N has exactly 2^N possible subsets (each element is either picked or not picked).
2. Recursive Tree Exploration: Exploring the decision tree takes O(2^N) time.
3. Copying Subsets: At each of the 2^N base cases, we create a new ArrayList to copy the current subList.
    Since a subset can have up to N elements (and averages N/2), this copying operation takes O(N) time.
4. Total: Multiplying the number of generated subsets (2^N) by the work done to copy each subset (N) gives a final time complexity of O(N * 2^N).

* Space Complexity: O(N)

1. Recursion Call Stack : The recursion tree goes exactly N levels deep, taking O(N) space.
2. The subList array : The temporary list holds at most N elements at any given time, taking O(N) space.
3. Total Auxiliary Space: O(N) + O(N) simplifies to O(N).

(If the interviewer specifically asks for total space complexity including the output array res, it would be O(N * 2^N),
because we are storing 2^N subsets in memory, and their average length is proportional to N).

*/

    public static void main(String[] args) {
        Subsets classObj = new Subsets();
        classObj.subsets(new int[]{1,2,3}).forEach(i -> {
            System.out.println("[");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        createSubsets(nums, nums.length, 0, subList, res);

        return res;
    }

    public void createSubsets(int[] nums, int n, int indx, List<Integer> subList, List<List<Integer>> res) {
        // after reaching the last indx, we need to collectively add the pick and not pick elements from subList to res list
        if (indx == n) {
            res.add(new ArrayList<>(subList));
            return;
        }

        // pick
        subList.add(nums[indx]);
        createSubsets(nums, n, indx+1, subList, res);
        subList.remove(subList.size() - 1);

        // not pick
        createSubsets(nums, n, indx+1, subList, res);
    }

}
