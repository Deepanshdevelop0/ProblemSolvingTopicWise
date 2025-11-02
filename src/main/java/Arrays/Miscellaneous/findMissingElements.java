package Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findMissingElements {

    public static List<Integer> findMissingElements(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = min; i < max; ++i) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,5};
        int[] nums1 = new int[]{7,8,6,9};
        int[] nums2 = new int[]{5,1};

        System.out.println(findMissingElements(nums2));
    }
}
