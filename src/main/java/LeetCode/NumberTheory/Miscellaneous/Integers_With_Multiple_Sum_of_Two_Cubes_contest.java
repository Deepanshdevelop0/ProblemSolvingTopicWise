package LeetCode.NumberTheory.Miscellaneous;

import java.util.*;

public class Integers_With_Multiple_Sum_of_Two_Cubes_contest {

/*

* findGoodIntegers method: (using HashMap)

TC: O(n^(2/3) + K log K) where n is the input integer and K is the number of good
    integers found. Generating the sums takes approximately (cube root of n)^2
    iterations, and sorting the final list takes K log K.

SC: O(n^(2/3)) as we store all unique sums of two cubes (a^3 + b^3 <= n) in a
    HashMap to count their frequencies.
-----------------------------------------

* findGoodIntegersOptimal method: (using Two Pointers & Pre-computed Cubes)

TC: O(n^(2/3)) to generate all sums. If we use a sorted list of cubes and a two-pointer
    approach (similar to 3Sum) to find pairs, we can identify "good" integers
    without a large frequency map.

SC: O(n^(1/3)) if we only store the list of cubes up to the cube root of n,
    though we still need space to store and sort the identified good integers.
-----------------------------------------

Note: The HashMap approach is the most straightforward for identifying integers
      with multiple representations. Because the cube root of 10^9 is only 1000,
      the n^(2/3) complexity (500,000 operations) is highly efficient and fits
      comfortably within standard time and memory limits.
*/
    public static void main(String[] args) {
        Integers_With_Multiple_Sum_of_Two_Cubes_contest classObj = new Integers_With_Multiple_Sum_of_Two_Cubes_contest();
        System.out.println("Case 1");
        classObj.findGoodIntegers(4104).forEach(i -> {
            System.out.print(i+ " ,");
        });

        System.out.println();
        System.out.println("Case 2");
        classObj.findGoodIntegers(578).forEach(i -> {
            System.out.print(i+ " ,");
        });
    }

    public List<Integer> findGoodIntegers(int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int limit = (int) Math.cbrt(n);

        for (int i = 1; i <= limit; i++) {
            long icube = (long) i*i*i;
            if (i > n) break;

            for (int j = i; j <= limit; j++) {
                long sum = icube + (long) j*j*j;
                if (sum <= n) {
                    int s = (int) sum;
                    freq.put(s, freq.getOrDefault(s, 0) + 1);
                }
                else {
                    break;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            if (entry.getValue() >= 2) {
                res.add(entry.getKey());
            }
        }

        Collections.sort(res);

        return res;
    }
}
