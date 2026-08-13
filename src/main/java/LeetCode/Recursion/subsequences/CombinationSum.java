package LeetCode.Recursion.subsequences;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum classObj = new CombinationSum();

//        classObj.combinationSum(new int[]{2,3,6,7}, 7).forEach(i -> i.forEach(System.out::println));
        classObj.combinationSum(new int[]{2,3,5}, 8).forEach(i -> i.forEach(System.out::println));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        findTargetCombinations(candidates, candidates.length, target, 0, 0, new ArrayList<>(), res);

        return res;
    }

    public void findTargetCombinations(int[] candidates, int n, int target, int indx, int sum, List<Integer> subList, List<List<Integer>> res) {
        if (sum >= target) {
            if (sum == target) res.add(new ArrayList<>(subList));
            return;
        }
        if (indx >= n) return;

        subList.add(candidates[indx]);

        findTargetCombinations(candidates, n, target, indx, sum + candidates[indx], subList, res);

        subList.remove(subList.size() - 1);

        findTargetCombinations(candidates, n, target, indx+1, sum, subList, res);
    }


}
