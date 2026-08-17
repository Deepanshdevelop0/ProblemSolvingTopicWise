package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_III {

/*

method : combinationSum3 (findCombinations/findCombinationsIterative for both)

Time Complexity: O(k * 9Ck) or O(1)

1. Fixed Search Space: We only choose from numbers 1 to 9. The maximum number of combinations is 9 choose k (9Ck).
2. Recursive Tree Exploration: Because the numbers are strictly limited to 9 digits, exploring all paths takes a constant number of steps (at most 2^9 = 512 operations).
3. Copying Combinations: Every time you find a valid combination, making a copy into a new ArrayList takes O(k) time.
4. Total: The final time complexity is O(k * 9Ck). Because the pool of numbers is a small constant (9), this is often considered O(1) constant time in interviews.

Space Complexity: O(k) or O(1)

1. Recursion Call Stack : The recursion depth will go at most 'k' levels deep (or 9 levels maximum), taking O(k) space.
2. The subList array : The temporary list never holds more than 'k' elements, taking O(k) space.
3. Total Auxiliary Space: O(k) + O(k) simplifies to O(k). (Since k <= 9, this is also theoretically O(1) constant space).

(If the interviewer specifically asks for total space complexity including the output array res, it would be O(X * k),
where X is the number of valid combinations and k is their exact length).

*/

    public static void main(String[] args) {
        CombinationSum_III classObj = new CombinationSum_III();

//        classObj.combinationSum(new int[]{2,3,6,7}, 7).forEach(i -> i.forEach(System.out::println));
//        classObj.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8).forEach(i -> {
        classObj.combinationSum3(3, 7).forEach(i -> {
            System.out.println("[");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("]");
        });

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();

        if (k > n) {
            return res;
        }

//        findCombinations(k, n, 0, 1, subList, res);
        findCombinationsIterative(k, n, 0, 1, subList, res);

        return res;
    }

    public void findCombinations(int k, int target, int sum, int indx, List<Integer> subList, List<List<Integer>> res) {
        if (sum == target && subList.size() == k) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (subList.size() >= k || sum > target || indx > 9) return;

        subList.add(indx);
        findCombinations(k, target, sum + indx, indx+1, subList, res);
        subList.remove(subList.size() - 1);

        findCombinations(k, target, sum, indx+1, subList, res);
    }


    public void findCombinationsIterative(int k, int target, int sum, int indx, List<Integer> subList, List<List<Integer>> res) {
        if (sum == target && subList.size() == k) {
            res.add(new ArrayList<>(subList));
            return;
        }
        if (subList.size() >= k || sum > target) return;

        for (int i = indx; i <= 9; i++) {
            if (sum + i > target) break;
            subList.add(i);
            findCombinationsIterative(k, target, sum + i, i+1, subList, res);
            subList.remove(subList.size() - 1);
        }
    }

}
