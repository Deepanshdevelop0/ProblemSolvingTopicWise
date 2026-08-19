package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II {

/*

method : subsets (createSubsets)

Time Complexity: O(2^N * k)

1. Sorting the array: Takes O(N log N) time
2. Recursive Tree Exploration : In the worst-case scenario (where all elements are unique and every possible subset needs to be explored),
the algorithm branches into two paths (take or don't take) for each of the N elements.
This creates a decision tree with 2^N possible combinations.
Therefore, the recursion takes O(2^N) time.
3. Copying Combinations: Every time you find a valid combination and do new ArrayList<>(subList), it takes O(k) time, where k is the average length of a valid combination.
4. Total: The O(2^N * k) operation completely dominates the O(N log N) sorting step, making the final time complexity O(2^N * k).

Space Complexity: O(N)

1. Recursion Call Stack : O(N)
2. The subList array : O(N)
3. The Sorting Space : O(log N)
4. Total Auxiliary Space: O(N) + O(N) + O(log N) simplifies to O(N).

(If the interviewer specifically asks for total space complexity including the output array res, it would be O(N * 2^N),
because we are storing 2^N subsets in memory, and their average length is proportional to N).

*/

    public static void main(String[] args) {

        Subsets_II classObj = new Subsets_II();

        classObj.subsetsWithDup(new int[]{1,2,2}).forEach(i -> {
            System.out.print("[");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        Arrays.sort(nums);

        createSubsets(nums, nums.length, 0, subList, res);

        return res;
    }

    public void createSubsets(int[] nums, int n, int indx, List<Integer> subList, List<List<Integer>> res) {
        if (indx == n) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (indx > n) return;

        subList.add(nums[indx]);
        createSubsets(nums, n, indx+1, subList, res);
        subList.remove(subList.size() - 1);

        while (indx + 1 < n && nums[indx] == nums[indx + 1]) indx++;
        createSubsets(nums, n, indx+1, subList, res);
    }

    public void createSubsetsIterative(int[] nums, int n, int indx, List<Integer> subList, List<List<Integer>> res) {

        res.add(new ArrayList<>(subList));

        for (int i = indx; i < n; i++) {

            if (i > indx && nums[i] == nums[i-1]) continue;

            subList.add(nums[i]);
            createSubsetsIterative(nums, n, i+1, subList, res);
            subList.remove(subList.size() - 1);
        }

    }

}
