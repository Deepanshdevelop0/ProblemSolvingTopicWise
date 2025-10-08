package Trees.BinarySearchTrees.Problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test {

    public static void main(String[] args) {
        System.out.println(maxTotalValue(new int[]{4,2,5,1}, 3));
    }


    public static long maxTotalValue(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int max = nums[i], min = nums[i];

            for (int j = i; j < n; j++) {

                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);

                /* add for all subarrays */
                list.add(max - min);
            }
        }

        list = list.stream().sorted(Comparator.reverseOrder()).toList();

        long maxValue = 0;

        for (int i = 0; i < k; i++) {
            maxValue += list.get(i);
        }

        return maxValue;
    }
}
