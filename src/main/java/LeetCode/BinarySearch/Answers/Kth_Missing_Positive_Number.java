package LeetCode.BinarySearch.Answers;

public class Kth_Missing_Positive_Number {

    public static void main(String[] args) {
        Kth_Missing_Positive_Number classObj = new Kth_Missing_Positive_Number();

        int res = classObj.findKthPositiveBetter(new int[]{2, 3, 4, 7, 11}, 5);
        System.out.println(res);
//
//        int res1 = classObj.findKthPositiveBetter(new int[]{1, 2, 3, 4}, 2);
//        System.out.println(res1);

//        int res2 = classObj.findKthPositiveBetter(new int[]{2}, 1);
//        System.out.println(res2);

    }

    public int findKthPositiveBruteForce(int[] arr, int k) {
        int n = arr.length;
        int last = arr[n - 1];

        int i = 1, indx = 0, missing = 0;

        while (i <= last) {
            if (i != arr[indx]) {
                missing++;
                if (missing == k) {
                    return i;
                }
                i++;
                continue;
            }

            i++;
            indx++;
        }

        return last + (k - missing);
    }

    public int findKthPositiveBetter(int[] arr, int k) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int missingFront = arr[mid] - (mid + 1);

            if (missingFront < k) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high + 1 + k;
    }

}
