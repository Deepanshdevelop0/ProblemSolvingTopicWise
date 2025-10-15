package Arrays.TwoPointers;

import java.util.*;

public class threeSum {

    public static void main(String[] args) {

        threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(i -> {
            i.forEach(element -> {
                System.out.print(element + ", ");
            });
            System.out.println();
        });

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> res = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            int curr = nums[i];
            Set<Integer> set = new HashSet<>();

            for (int j = i+1; j < n; j++) {

                // subtracting from target 0 and multiply by -1 are same thing
                int thirdElement = (curr + nums[j]) * -1;

                if (set.contains(thirdElement)) {
                    List<Integer> triplet = Arrays.asList(curr, nums[j], thirdElement);
                    Collections.sort(triplet);
                    res.add(triplet);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }
}
