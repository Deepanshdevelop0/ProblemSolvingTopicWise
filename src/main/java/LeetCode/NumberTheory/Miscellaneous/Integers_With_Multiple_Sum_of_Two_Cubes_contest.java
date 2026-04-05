package LeetCode.NumberTheory.Miscellaneous;

import java.util.*;

public class Integers_With_Multiple_Sum_of_Two_Cubes_contest {

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
