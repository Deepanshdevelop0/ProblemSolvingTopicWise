package LeetCode.Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Widest_Possible_Fence {

    public static void main(String[] args) {
        Widest_Possible_Fence classObj = new Widest_Possible_Fence();
        int res = classObj.maximumWidth(new int[]{1, 3, 2, 5, 7, 5, 4, 2, 1});
//        int res = classObj.maximumWidth(new int[]{1, 1,1,1,1,1,1, 1});
        System.out.println("result : " + res);
    }

    public int maximumWidth(int[] planks) {

        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : planks) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }

        List<Integer> uniqueHeights = new ArrayList<>(freq.keySet());
        int unique = uniqueHeights.size();

        Map<Integer, Integer> pairCount = new HashMap<>();


        for (int i = 0; i < unique; i++) {
            int u = uniqueHeights.get(i);
            int countU = freq.get(u);

            // consider single first
            if (countU >= 2) {
                int sum = u+u;
                int pairs = countU / 2;
                pairCount.put(sum, pairCount.getOrDefault(sum, 0) + pairs);
            }

            // consider single with other plank heights
            for (int j = i + 1; j < unique; j++) {
                int v = uniqueHeights.get(j);
                int countV = freq.get(v);

                int sum = u + v;
                int pairs = Math.min(countU, countV);

                pairCount.put(sum, pairCount.getOrDefault(sum, 0) + pairs);
            }
        }

        int maxWidth = 0;

        for (Map.Entry<Integer, Integer> entry : pairCount.entrySet()) {
            int height = entry.getKey();
            int pairs = entry.getValue();
            int singles = freq.getOrDefault(height, 0);

            maxWidth = Math.max(maxWidth, pairs + singles);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int height = entry.getKey();
            int singles = entry.getValue();
            int pairs = pairCount.getOrDefault(height, 0);

            maxWidth = Math.max(maxWidth, pairs + singles);
        }

        return maxWidth;
    }


}
