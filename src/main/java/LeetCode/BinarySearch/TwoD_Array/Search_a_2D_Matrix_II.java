package LeetCode.BinarySearch.TwoD_Array;

public class Search_a_2D_Matrix_II {

/*

TC : O(m+n)

1. If the target is larger, it moves down (row++).
2. If the target is smaller, it moves left (col--).
3. Example, the target is at the bottom-left corner or not in the matrix at all),
 the pointer will move all the way down m rows and all the way left across n columns.

SC : O(1) : constant variable space

--------------------------------------------------------

Explaination :

We start searching the matrix from top right corner, initialize the current position to top right corner,

1. if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted.
2. if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too.
3. We can rule out one row or one column each time, so the time complexity is O(m+n).

*/
    public static void main(String[] args) {

        Search_a_2D_Matrix_II classObj = new Search_a_2D_Matrix_II();

        boolean res = classObj.searchMatrix(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        }, 25);

        System.out.println("result : " + res);

    }

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;

        int row = 0, col = n - 1;

        while (row < m && col >= 0) {

            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

}
