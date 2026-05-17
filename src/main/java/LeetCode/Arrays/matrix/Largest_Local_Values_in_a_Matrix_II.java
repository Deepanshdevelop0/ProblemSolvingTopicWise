package LeetCode.Arrays.matrix;

import java.util.ArrayList;

public class Largest_Local_Values_in_a_Matrix_II {


/*
Brute Force Solution:

1. TC: O(M * N * X^2)
    i.  The outer nested loops visit every single cell in the grid exactly once: O(M * N)
    ii. For each non-zero cell, we launch an inner bounding box scan based on its value 'x'.
        The window size expands up to (2x + 1) rows and (2x + 1) columns.
    iii. In the worst-case scenario, every cell contains the maximum allowed constraint value X_max (200).
        This makes each inner window scan bounded by a constant area of (2 * X_max + 1)^2.
    iv. Total Time Complexity: O(M * N * X_max^2). Given constraints (M, N, X <= 200), max operations
        reach ~6.4 x 10^9, which provides a clear baseline for future optimization.

2. SC: O(1)
    i.  The algorithm updates state purely using primitive loop iterators and boundary values.
    ii. No auxiliary data structures are allocated that scale with input size, and execution is
        strictly iterative (no recursive call stack overhead).

-------------------------------
*/

    public static void main(String[] args) {
        Largest_Local_Values_in_a_Matrix_II classObj = new Largest_Local_Values_in_a_Matrix_II();

        int[][] matrix = {
                {0, 0, 0, 0, 0},
                {0, 0, 3, 0, 0},
                {0, 0, 2, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        int res = classObj.countLocalMaximums(matrix);

        System.out.println(res);
    }

    public int countLocalMaximums(int[][] matrix) {

        int row = matrix.length, col = matrix[0].length, count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] > 0) {
                    count += (checkIfLocalMaxima(matrix, i, j, row, col)) ? 1 : 0;
                }
            }
        }

        return count;
    }


    public boolean checkIfLocalMaxima(int[][] matrix, int indxI, int indxJ, int m, int n) {

        int x = matrix[indxI][indxJ];

        int startRow = Math.max(0, indxI - x), startCol = Math.max(0, indxJ - x);
        int endRow = Math.min(m-1, indxI + x), endCol = Math.min(n-1, indxJ + x);

        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {

                // for corners
                if (Math.abs(i - indxI) == x && Math.abs(j - indxJ) == x) {
                    continue;
                }

                if (matrix[i][j] > x) {
                    return false;
                }
            }
        }

        return true;
    }



    public int countLocalMaximums1(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int count=0;
        ArrayList<int[]>[] list=new ArrayList[201];
        for(int i=0;i<=200;i++)
        {
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (matrix[i][j]>0) {
                    list[matrix[i][j]].add(new int[]{i, j});
                }
            }
        }
        for(int num=1;num<=200;num++) {
            for (int[] cell:list[num]) {
                int i = cell[0];
                int j = cell[1];
                boolean ok = true;
                for (int b = num + 1; b <= 200 && ok; b++) {
                    for (int[] p:list[b]) {
                        int r=p[0];
                        int c=p[1];
                        int dr=Math.abs(r-i);
                        int dc=Math.abs(c-j);
                        if (dr<=num&&dc<=num) {
                            if (dr==num&&dc==num) {
                                continue;
                            }
                            ok=false;
                            break;
                        }
                    }
                }
                if(ok){
                    count++;
                }
            }
        }
        return count;
    }

}
