package Arrays.Miscellaneous;

import java.util.*;

public class MinimumDistinctFreqPairs {

    public static void main(String[] args) {
        MinimumDistinctFreqPairs classObj = new MinimumDistinctFreqPairs();
        int[] res = classObj.minDistinctFreqPair(new int[]{1,1,2,2,3,4});
        System.out.println(res[0] + ", " + res[1]);

        String s = "isudhmcue";
        char[] charr = s.toCharArray();

    }

    public int[] minDistinctFreqPair(int[] nums) {

        if (nums.length <= 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(freqMap.keySet());
        Collections.sort(list);

        int n = list.size();

        for (int i = 0; i < n; i++) {
            int element = list.get(i);
            int freq = freqMap.get(element);

            for (int j = i + 1; j < n; j++) {
                int element1 = list.get(j);
                int freq1 = freqMap.get(element1);

                if (freq != freq1) {
                    return new int[] { element, element1 };
                }

            }
        }

        return new int[] { -1, -1 };
    }
}
