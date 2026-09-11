package LeetCode.DP.Revision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump {


    public static void main(String[] args) {

        FrogJump frogJump = new FrogJump();

        int[] stones = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        int[] stones1 = new int[]{0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(frogJump.canCrossTabulation(stones));

    }

    /* 1. Brute Force Recursion Approach */
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        if (stones.length == 2) return true;

        Map<Integer, Integer> stoneIndxMap = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            stoneIndxMap.put(stones[i], i);
        }

        return crossRecursively(1, 1, stones, stoneIndxMap);
    }

    public boolean crossRecursively(int currIndx, int k, int[] stones, Map<Integer, Integer> stoneIndxMap) {
        if (currIndx == stones.length-1) {
            return true;
        }

        boolean res = false;

        if (stoneIndxMap.containsKey(stones[currIndx] + k)) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + k);
            res = crossRecursively(nextIndx, k, stones, stoneIndxMap);
        }

        if (!res && stoneIndxMap.containsKey(stones[currIndx] + (k + 1))) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + (k + 1));
            res = crossRecursively(nextIndx, k + 1, stones, stoneIndxMap);
        }

        if (!res && k-1 > 0 && stoneIndxMap.containsKey(stones[currIndx] + (k - 1))) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + (k-1));
            res = crossRecursively(nextIndx, k-1, stones, stoneIndxMap);
        }

        return res;
    }


    /* 2. Memoization Approach */
    public boolean canCrossMemoization(int[] stones) {
        if (stones[1] != 1) return false;
        if (stones.length == 2) return true;

        Map<Integer, Integer> stoneIndxMap = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            stoneIndxMap.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];

        return crossRecursivelyMemoization(1, 1, stones, stoneIndxMap, dp);
    }

    public boolean crossRecursivelyMemoization(int currIndx, int k, int[] stones, Map<Integer, Integer> stoneIndxMap, Boolean[][] dp) {
        if (currIndx == stones.length - 1) {
            return true;
        }

        if (dp[currIndx][k] != null) {
            return dp[currIndx][k];
        }

        boolean res = false;

        if (stoneIndxMap.containsKey(stones[currIndx] + k)) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + k);
            res = crossRecursivelyMemoization(nextIndx, k, stones, stoneIndxMap, dp);
        }

        if (!res && stoneIndxMap.containsKey(stones[currIndx] + (k + 1))) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + (k + 1));
            res = crossRecursivelyMemoization(nextIndx, k+1, stones, stoneIndxMap, dp);
        }

        if (!res && k-1 > 0 && stoneIndxMap.containsKey(stones[currIndx] + (k - 1))) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + (k - 1));
            res = crossRecursivelyMemoization(nextIndx, k-1, stones, stoneIndxMap, dp);
        }

        dp[currIndx][k] = res;

        return res;
    }


    /* 3. Tabulation Approach */
    public boolean canCrossTabulation(int[] stones) {
        if (stones[1] != 1) return false;
        if (stones.length == 2) return true;

        Map<Integer, Integer> stoneIndxMap = new HashMap<>();

        for (int i = 0; i < stones.length; i++) {
            stoneIndxMap.put(stones[i], i);
        }

        Boolean[][] dp = new Boolean[stones.length][stones.length + 1];

        return crossRecursivelyTabulation(1, 1, stones, stoneIndxMap, dp);
    }

    public boolean crossRecursivelyTabulation(int currIndx, int k, int[] stones, Map<Integer, Integer> stoneIndxMap, Boolean[][] dp) {
        if (currIndx == stones.length - 1) {
            return true;
        }

        if (dp[currIndx][k] != null) {
            return dp[currIndx][k];
        }

        boolean res = false;

        if (stoneIndxMap.containsKey(stones[currIndx] + k)) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + k);
            res = crossRecursivelyTabulation(nextIndx, k, stones, stoneIndxMap, dp);
        }

        if (!res && stoneIndxMap.containsKey(stones[currIndx] + (k + 1))) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + (k + 1));
            res = crossRecursivelyTabulation(nextIndx, k+1, stones, stoneIndxMap, dp);
        }

        if (!res && k-1 > 0 && stoneIndxMap.containsKey(stones[currIndx] + (k - 1))) {
            int nextIndx = stoneIndxMap.get(stones[currIndx] + (k - 1));
            res = crossRecursivelyTabulation(nextIndx, k-1, stones, stoneIndxMap, dp);
        }

        dp[currIndx][k] = res;

        return res;
    }

}
