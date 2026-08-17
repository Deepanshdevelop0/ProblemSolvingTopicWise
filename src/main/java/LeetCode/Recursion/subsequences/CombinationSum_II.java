package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_II {

/*

method : combinationSum2 (findCombinations/findCombinationsApproach2 for both)

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

(If the interviewer specifically asks for total space complexity including the output array res, it would be O(X * k),
where X is the number of valid combinations and k is their average length).

*/

    public static void main(String[] args) {
        CombinationSum_II classObj = new CombinationSum_II();

//        classObj.combinationSum(new int[]{2,3,6,7}, 7).forEach(i -> i.forEach(System.out::println));
//        classObj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).forEach(i -> {
        classObj.combinationSum2(new int[]{2,1,2,1,2}, 5).forEach(i -> {
            System.out.println("[");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        });

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        Arrays.sort(candidates);

        findCombinationsApproach2(candidates, candidates.length, target, 0, 0, subList, res);

        return res;
    }

    public void findCombinations(int[] candidates, int n, int target, int sum, int indx, List<Integer> subList, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (sum > target || indx >= n) {
            return;
        }

        subList.add(candidates[indx]);
        findCombinations(candidates, n, target, sum + candidates[indx], indx + 1, subList, res);
        subList.remove(subList.size() - 1);

        // DO NOT TAKE the current element
        // Crucial: Skip all adjacent duplicates to avoid generating the same combinations
        while (indx + 1 < n && candidates[indx] == candidates[indx + 1]) indx++;

        findCombinations(candidates, n, target, sum, indx + 1, subList, res);
    }


    /* Preferred for interview, as in for loop and is clean */
    /* Otherwise the first one will work as well, both are similar just iterative and recursive variation of this solution */
    public void findCombinationsApproach2(int[] candidates, int n, int target, int sum, int indx, List<Integer> subList, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(subList));
            return;
        }

        for (int i = indx; i < n; i++) {
            if (i > indx && candidates[i] == candidates[i - 1]) continue;
            if (sum + candidates[i] > target) {
                break;
            }

            subList.add(candidates[i]);
            findCombinationsApproach2(candidates, n, target, sum + candidates[i], i+1, subList, res);
            subList.remove(subList.size() - 1);
        }
    }

}
