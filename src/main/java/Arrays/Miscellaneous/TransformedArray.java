package Arrays.Miscellaneous;

public class TransformedArray {

    public static void main(String[] args) {

        TransformedArray classObj = new TransformedArray();
        for (int i : classObj.constructTransformedArray(new int[]{3, -2, 1, 1})) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int temp = (i + nums[i]) % n;

            if (temp < 0) temp += n;
            res[i] = nums[temp];
        }

        return res;
    }

}
