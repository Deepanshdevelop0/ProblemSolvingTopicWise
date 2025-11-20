package DP.DP_1D;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {

/*
Memoization / Top-Down Dynamic Programming (FrogJumpReachability)

TC : O(n^2)
i. The time complexity is determined by the number of unique states the function can visit.
ii. A state is defined by (currentStoneIndex, previousJumpSize).
iii. If N is the number of stones (up to 2000), the number of indices is N, and the maximum jump size is also bounded by N (since the frog must reach the end).
iv. The total number of unique states is approximately N * N, resulting in O(N^2) states.
    Since each state is computed only once and involves O(1) work (a loop of size 3), the total time is O(N^2).

SC : O(n^2)
i. The space complexity is dominated by the 2D memoization array (memo).
ii. The memo array stores the result for every possible (stone index, jump size) pair, leading to O(N^2) space, where N is the number of stones.
iii. Additionally, the recursive call stack depth can go up to N, adding O(N) space, but O(N^2) is the dominant term.

===========================================================

Note on Pure Recursion (Without Memoization):
A pure recursive approach for this problem would have a worst-case exponential time complexity, O(3^n),
due to redundant re-computation of subproblems, leading to Time Limit Exceeded (TLE).

*/

    public static void main(String[] args) {

        FrogJump frogJump = new FrogJump();

        int[] stones = new int[]{0,1,3,5,6,8,12,17};
        int[] stones1 = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(frogJump.canCross(stones1));

    }

    int[][] memo = new int[2001][2001];

    public boolean canCross(int[] stones) {

        if (stones[1] != 1) return false;
        if (stones.length == 2) return true;

        Map<Integer, Integer> stoneIndexMap = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            stoneIndexMap.put(stones[i], i);
        }

        return canCrossRecursive(stones, 1, 1, stoneIndexMap);
    }

    public boolean canCrossRecursive(int[] stones, int pj, int currentStoneIdx, Map<Integer, Integer> stoneIndexMap) {

        if (currentStoneIdx == stones.length - 1) {
            return true;
        }

        if (memo[currentStoneIdx][pj] != 0) {
            return memo[currentStoneIdx][pj] == 1;
        }

        boolean result = false;

        for (int nextJump = pj-1; nextJump <= pj+1; nextJump++) {

            if (nextJump > 0) {

                int nextStone = stones[currentStoneIdx] + nextJump;

                if (stoneIndexMap.containsKey(nextStone)) {
                    result = result || canCrossRecursive(stones, nextJump, stoneIndexMap.get(nextStone), stoneIndexMap);
                }
            }
        }

       memo[currentStoneIdx][pj] = (result) ? 1 : -1;

        return result;
    }



    public boolean canCrosss(int[] stones) {
        int n = stones.length;

        // Initial checks: The second stone must be at position 1,
        // as the first jump must be 1 unit.
        if (stones[1] != 1) {
            return false;
        }

        // DP Table: map<Stone Position, Set of Possible Previous Jump Lengths>
        // dp.get(stone) contains all valid jump sizes 'k' that can land the frog on 'stone'.
        Map<Integer, Set<Integer>> dp = new HashMap<>();

        // Initialize the map for all stones
        for (int stone : stones) {
            dp.put(stone, new HashSet<>());
        }

        // Base Case: The frog starts at stone 0 (position 0) and the first jump is size 1.
        // We track the jump size *to* the stone, so stone 1 is reached by jump size 1.
        dp.get(stones[1]).add(1);

        // Iterate through all stones starting from the second stone (index 1)
        for (int i = 1; i < n; i++) {
            int currentStone = stones[i];

            // For each valid previous jump size (pj) that brought the frog to the current stone
            for (int pj : dp.get(currentStone)) {

                // Explore the next possible jumps: pj-1, pj, pj+1
                for (int nextJump = pj - 1; nextJump <= pj + 1; nextJump++) {

                    // The next jump size must be greater than 0
                    if (nextJump > 0) {
                        int nextStonePosition = currentStone + nextJump;

                        // Check if the target is the last stone
                        if (nextStonePosition == stones[n - 1]) {
                            return true;
                        }

                        // Check if the target stone exists in the set of stones
                        if (dp.containsKey(nextStonePosition)) {
                            // If it exists, mark the 'nextJump' size as a valid way to land on the 'nextStonePosition'
                            dp.get(nextStonePosition).add(nextJump);
                        }
                    }
                }
            }
        }

        // If the loop finishes without reaching the final stone
        return false;
    }


}
