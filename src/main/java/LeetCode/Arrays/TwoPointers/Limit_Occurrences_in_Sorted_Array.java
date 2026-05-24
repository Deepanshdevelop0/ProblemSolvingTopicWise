package LeetCode.Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class Limit_Occurrences_in_Sorted_Array {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1,2,3,4,5,0,0,0};
        int[] nums1 = new int[]{0,0,0};
        int[] nums2 = new int[]{2,5,6};

        Limit_Occurrences_in_Sorted_Array classObj = new Limit_Occurrences_in_Sorted_Array();

        int [] res = classObj.limitOccurrences(new int[]{1,1,1,2,2,3}, 2);

        for (int i : res) {
            System.out.println(i);
        }


    }


    public int[] limitOccurrences(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int currK = 1;

        list.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                currK = 0;
            }

            if (currK >= k) continue;

            list.add(nums[i]);
            currK++;
        }

        int[] res = new int[list.size()];
        int j = 0;
        for (int i : list) {
            res[j++] = i;
        }

        return res;
    }







}
