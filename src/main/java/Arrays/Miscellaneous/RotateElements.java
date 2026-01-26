package Arrays.Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotateElements {

    public static void main(String[] args) {

        RotateElements classObj = new RotateElements();
        int[] res = classObj.rotateElements(new int[]{1,-2,3,-4}, 3);

        for (int re : res) {
            System.out.println(re);
        }

    }


    public int[] rotateElements(int[] nums, int k) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                list.add(new int[]{i, nums[i]});
            }
        }

        int n = list.size();
        if (n <= 1) return nums;
        k = k % n;

        for (int i = 0; i < n; i++) {

//            int indx = (i + k) < n ? (i+k) : (i+k - n);
            int indx = (i - k + n) % n;

            int element = list.get(i)[1], toIndx = list.get(indx)[0];

            nums[toIndx] = element;

        }

        return nums;
    }
}
