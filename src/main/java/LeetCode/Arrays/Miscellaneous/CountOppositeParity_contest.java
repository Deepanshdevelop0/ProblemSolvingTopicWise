package LeetCode.Arrays.Miscellaneous;

public class CountOppositeParity_contest {


    public static void main(String[] args) {
        CountOppositeParity_contest classObj = new CountOppositeParity_contest();
        int[] arr = classObj.countOppositeParity(new int[]{1,2,3,4});

        for (int i : arr) {
            System.out.println(i);
        }
    }



    public int[] countOppositeParity(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int even = 0, odd = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) even++;
            else odd++;
        }


        res[0] = (nums[0] % 2 == 0) ? odd : even;
        int j = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == 0) {
                res[j++] = odd;
                even--;
            }
            else {
                res[j++] = even;
                odd--;
            }
        }

        return res;
    }
}
