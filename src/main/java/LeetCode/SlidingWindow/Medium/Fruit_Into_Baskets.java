package LeetCode.SlidingWindow.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fruit_Into_Baskets {

    public static void main(String[] args) {
        Fruit_Into_Baskets classObj = new Fruit_Into_Baskets();
        System.out.println(classObj.totalFruitBetter(new int[]{1, 2, 3, 2, 2}));
    }

    public int totalFruitBruteForce(int[] fruits) {

        int n = fruits.length, maxLen = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                set.add(fruits[j]);

                if (set.size() > 2) {
                    set.clear();
                    break;
                }

                maxLen = Math.max(maxLen, (j - i) + 1);
            }
        }

        return maxLen;
    }


    public int totalFruitBetter(int[] fruits) {

        int n = fruits.length, maxLen = 0, left = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < n; right++) {

            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                int count = fruitCount.get(fruits[left]);
                if (count > 1) {
                    fruitCount.put(fruits[left], count - 1);
                }
                else {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, (right - left) + 1);
        }

        return maxLen;
    }

    public int totalFruitBest(int[] fruits) {

        int n = fruits.length, maxLen = 0, left = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();

        for (int right = 0; right < n; right++) {

            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                int count = fruitCount.get(fruits[left]);
                if (count > 1) {
                    fruitCount.put(fruits[left], count - 1);
                }
                else {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, (right - left) + 1);
        }

        return maxLen;
    }

}
