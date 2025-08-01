package Arrays.matrix;

public class rotateImage {

    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        /* Brute Force */
        bruteForceRotate(arr);

        /* Optimized In Place */
        inPlaceRotate(arr);

        System.out.println("Rotated Image");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    /*    TC : O(NxN) + O(NxN) ~ O(N2)
        1. For copying input matrix in rotational order  2. for copying resMatrix to input Matrix

        SC : O(NxN)
        For Additional Matrix
    */
    public static void bruteForceRotate(int[][] matrix) {
        int n = matrix.length;

        int[][] resMatrix = new int[n][n];

        // using new matrix - brute force
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        // copy back to input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = resMatrix[i][j];
            }
        }

    }


    /*
        TC : O(NxN) + O(NxN) ~ O(N2)
        1. For transposing matrix  2. for reversing each row

        SC : O(1)
        For Constant spaces
    */
    public static void inPlaceRotate(int[][] matrix) {
        int n = matrix.length;

        // transpose of matrix (swap i,j -> j,i)
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse each matrix row to get matrix rotated
        for (int[] arr : matrix) {
            for (int i = 0; i < n/2; i++) {
                int temp = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = temp;
            }
        }

    }

}
