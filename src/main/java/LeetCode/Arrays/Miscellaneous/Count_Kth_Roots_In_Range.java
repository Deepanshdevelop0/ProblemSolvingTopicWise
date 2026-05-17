package LeetCode.Arrays.Miscellaneous;

public class Count_Kth_Roots_In_Range {

    public static void main(String[] args) {
        Count_Kth_Roots_In_Range classObj = new Count_Kth_Roots_In_Range();
        System.out.println(classObj.countKthRootsAlternate(1, 9, 3));
    }

    public int countKthRoots(int l, int r, int k) {

        if (k == 1) {
            return r - l + 1;
        }

        int count = 0;

        for (int i = 0; Math.pow(i, k) <= r; i++) {

            double pow = Math.pow(i, k);

            if (pow >= l && pow <= r) {
                count++;
            }
        }

        return count;
    }


    public int countKthRootsAlternate(int l, int r, int k) {

        if (k == 1) {
            return r - l + 1;
        }

        int count = 0;

        int i = 0;
        while (Math.pow(i, k) <= r) {

            double pow = Math.pow(i, k);

            if (pow >= l && pow <= r) {
                count++;
            }

            i++;
        }

        return count;
    }

    public boolean getKthPowExists(int num, int l, int r, int k) {

        if (Math.pow(num, k) <= r) {
            return true;
        }

        return false;
    }


}
