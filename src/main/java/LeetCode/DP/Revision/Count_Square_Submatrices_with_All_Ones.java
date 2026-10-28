package LeetCode.DP.Revision;

public class Count_Square_Submatrices_with_All_Ones {

    public static void main(String[] args) {
        Count_Square_Submatrices_with_All_Ones classObj = new Count_Square_Submatrices_with_All_Ones();
//        int res = classObj.countSquares(new int[][]{
//                {0, 1, 1, 1},
//                {1, 1, 1, 1},
//                {0, 1, 1, 1}
//        });
//
        int res = classObj.countSquares(new int[][]{
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        });

        System.out.println(res);
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int left = matrix[i][j-1];
                int up = matrix[i-1][j];
                int diagonal = matrix[i-1][j-1];

                int min = Math.min(left, Math.min(up, diagonal));
                matrix[i][j] = min + 1;
            }
        }

        int sum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
    }

}
