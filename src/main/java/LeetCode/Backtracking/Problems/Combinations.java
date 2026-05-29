package LeetCode.Backtracking.Problems;

import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        Combinations classObj = new Combinations();
        classObj.combine(4, 2).forEach(System.out::println);
    }

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

//        backtrack(n, k, 1, new ArrayList<>(), res);
//        backtrackFollowUp(n, k, new ArrayList<>(), res);

        /* LinkedHashSet because HashSet would not maintain the order of elements and we want to maintain the order of elements in the combination,
            and also we dont want to have duplicate elements in the combination as well,
            so we can use LinkedHashSet which maintains the order of elements and also does not allow duplicate elements. */
        backtrackNextFollowUp(n, k, new LinkedHashSet<>(), res);

        return res;
    }

    public void backtrack(int n, int k, int num, List<Integer> curr, List<List<Integer>> res) {
        // base case
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = num; i <= n; i++) {
            curr.add(i);
            backtrack(n, k, i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }

    }



    /* Follow up : What if [1,2] and [2,1] are not considered to be the same combination, we need to add both of them ? */
    /* Answer to Follow up : In that case we need to start loop from 1 to n each time and backtrack from num again instead of num + 1, and following this approach we would now get the
     [1,1] and [2,2] (same no's) pairs as well */
    public void backtrackFollowUp(int n, int k, List<Integer> curr, List<List<Integer>> res) {
        // base case
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 1; i <= n; i++) {
            curr.add(i);
            backtrackFollowUp(n, k, curr, res);
            curr.remove(curr.size() - 1);
        }

    }

    /* Next Follow up : What if we dont need to consider the same num pairs [1,1] and [2,2], but including previous follow up pairs ? */
    /* Answer to Follow up : In that case we need to start similarly from 1 to n and backtrack from same num value,
        but we will put a condition if (num matches */
    public void backtrackNextFollowUp(int n, int k, Set<Integer> curr, List<List<Integer>> res) {
        // base case
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (curr.contains(i)) {
                continue;
            }
            curr.add(i);
            backtrackNextFollowUp(n, k, curr, res);
            curr.remove(i);
        }

    }


}
