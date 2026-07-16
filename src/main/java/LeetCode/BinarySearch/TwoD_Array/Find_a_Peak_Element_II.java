package LeetCode.BinarySearch.TwoD_Array;

public class Find_a_Peak_Element_II {

    public static void main(String[] args) {
        Find_a_Peak_Element_II classObj = new Find_a_Peak_Element_II();
//        int[] res = classObj.findPeakGrid(new int[][]{
//                {10, 20, 15}, {21, 30, 14}, {7, 16, 32}
//        });
//        System.out.println("Result : [" + res[0] + "," + res[1] + "]");

        int[] res1 = classObj.findPeakGrid(new int[][]{
                {1, 4}, {3, 2}
        });

        System.out.println("Result : [" + res1[0] + "," + res1[1] + "]");
    }

    public int[] findPeakGrid(int[][] mat) {

        int m = mat.length, n = mat[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int row = findMaxElement(mat, mid);

            int left = mid - 1 >= 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
            int right = mid + 1 < n ? mat[row][mid + 1] : Integer.MIN_VALUE;
            int currElement = mat[row][mid];

            if (currElement > left && currElement > right) {
                return new int[]{row, mid};
            } else if (left > currElement) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    public int findMaxElement(int[][] mat, int col) {

        int max = -1, maxIndx = -1;

        for (int row = 0; row < mat.length; row++) {
            if (mat[row][col] > max) {
                max = mat[row][col];
                maxIndx = row;
            }
        }

        return maxIndx;
    }

}
