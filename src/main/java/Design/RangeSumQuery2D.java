package Design;

public class RangeSumQuery2D {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

        NumMatrix obj = new NumMatrix(matrix);
        int param_1 = obj.sumRegion(2, 1, 4, 3);
        int param_2 = obj.sumRegion(1, 1, 2, 2);
        int param_3 = obj.sumRegion(1, 2, 2, 4);

        System.out.println(param_1);
        System.out.println(param_2);
        System.out.println(param_3);
    }

}

class NumMatrix {

    int[][] preSumMatrix;

    public NumMatrix(int[][] matrix) {
        preSumMatrix = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            preSumMatrix[i][0] = matrix[i][0];
            for (int j = 1; j < matrix[0].length; j++) {
                preSumMatrix[i][j] = matrix[i][j] + preSumMatrix[i][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int sum = 0;

        for (int i = row1; i <= row2; i++) {
            sum += ((col1 == 0) ? preSumMatrix[i][col2] : preSumMatrix[i][col2] - preSumMatrix[i][col1 - 1]);
        }

        return sum;
    }
}
