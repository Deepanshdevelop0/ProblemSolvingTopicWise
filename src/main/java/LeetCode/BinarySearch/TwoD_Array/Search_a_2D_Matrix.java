package LeetCode.BinarySearch.TwoD_Array;

public class Search_a_2D_Matrix {

/*

Method 1 : Single Binary Search (searchMatrix)

TC : O(log M + N)

1. Finding the right row: O(log M)
2. Searching inside the row: O(N)

SC : O(1) : Constant variable size

--------------------------------------

Method 2 : Double Binary Search (searchMatrixOptimized)

TC : O(log m + log n) = O(log(m * n))

1. Finding the right row: O(log M)
2. Searching inside the row: O(log N)

SC : O(1) : Constant variable size

*/
    public static void main(String[] args) {

        Search_a_2D_Matrix classObj = new Search_a_2D_Matrix();

        boolean res = classObj.searchMatrixOptimized(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        }, 1);

        System.out.println("result : " + res);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int rowLen = matrix[mid].length;

            if (target >= matrix[mid][0] && target <= matrix[mid][rowLen - 1]) {
                return searchInARow(matrix, target, mid, rowLen);
            } else if (target > matrix[mid][rowLen - 1]) {
                low = mid + 1;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            }

        }

        return false;
    }


    public boolean searchInARow(int[][] matrix, int target, int mid, int rowLen) {

        for (int i = 0; i < rowLen; i++) {
            if (matrix[mid][i] == target) {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrixOptimized(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;

        int low = 0, high = m - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int rowLen = matrix[mid].length;

            if (target >= matrix[mid][0] && target <= matrix[mid][rowLen - 1]) {
                return searchInARowOptimized(matrix, target, mid, rowLen);
            } else if (target > matrix[mid][rowLen - 1]) {
                low = mid + 1;
            } else if (target < matrix[mid][0]) {
                high = mid - 1;
            }

        }

        return false;
    }


    public boolean searchInARowOptimized(int[][] matrix, int target, int row, int rowLen) {

        int low = 0, high = rowLen - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target) {
                return true;
            }
            else if (matrix[row][mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return false;
    }

}
