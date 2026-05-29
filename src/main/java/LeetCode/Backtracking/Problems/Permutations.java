package LeetCode.Backtracking.Problems;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        Permutations classObj = new Permutations();
            classObj.permute(new int[]{1, 2, 3}).forEach(System.out::println);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new java.util.ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, nums.length, visited, new ArrayList<>(), res);

        return res;
    }

    public void backtrack(int[] nums, int n, boolean[] visited, List<Integer> curr, List<List<Integer>> res) {
        // base case
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < n; i++) {

            if (visited[i]) {
                continue;
            }

            curr.add(nums[i]);
            visited[i] = true;

            backtrack(nums, n, visited, curr, res);

            curr.remove(curr.size() - 1);
            visited[i] = false;
        }

    }


}
