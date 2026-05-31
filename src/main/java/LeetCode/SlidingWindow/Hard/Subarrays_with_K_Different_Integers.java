package LeetCode.SlidingWindow.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Subarrays_with_K_Different_Integers {

    public static void main(String[] args) {
        Subarrays_with_K_Different_Integers classObj = new Subarrays_with_K_Different_Integers();

        int res = classObj.subarraysWithKDistinctOptimal(new int[]{1,2,1,2,3}, 2);
        System.out.println(res);
    }

    public int subarraysWithKDistinctBruteForce(int[] nums, int k) {

        int n =  nums.length, count = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i; j < n; j++) {

                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if (map.size() == k) count++;

                if (map.size() > k) break;

            }
        }

        return count;
    }

    public int subarraysWithKDistinctOptimal(int[] nums, int k) {

        return atMostK(nums, k) - atMostK(nums, k-1);
    }

    public int atMostK(int[] nums, int k) {
        int left = 0, count = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int right = 0; right < n; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }

}

