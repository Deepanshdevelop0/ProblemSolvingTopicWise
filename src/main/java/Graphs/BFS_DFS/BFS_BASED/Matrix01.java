package Graphs.BFS_DFS.BFS_BASED;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class Matrix01 {

    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {

        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Stack<Integer> st = new Stack<>();

        Arrays.asList(updateMatrix(mat)).forEach(i -> {
            for (int i1 : i) {
                System.out.print(i1 + ", ");
            }
            System.out.println();
        });

    }

    public static int[][] updateMatrix(int[][] mat) {

        Queue<int[]> queue = new ArrayDeque<>();
        int m = mat.length, n = mat[0].length;

        int[][] res = new int[m][n];

        /* N x M time complexity */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    res[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
                else {
                    res[i][j] = -1;
                }
            }
        }

        /* N x M x 4 time complexity */
        while (!queue.isEmpty()) {

            int i = queue.peek()[0], j = queue.peek()[1];
            queue.remove();

            for (int [] direction : directions) {

                /* add direction to current index i and j for 4-directional */
                int newI = i + direction[0], newJ = j + direction[1];

                /* new indexes newI between 0 and m and newJ between 0 and n */
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n
                && res[newI][newJ] == -1) {
                    res[newI][newJ] = res[i][j] + 1;
                    queue.add(new int[]{newI, newJ});
                }
            }
        }

        return res;
    }

    public static int[][] updateMatrixInPlace(int[][] mat) {

        Queue<int[]> queue = new ArrayDeque<>();
        int m = mat.length, n = mat[0].length;

        /* N x M time complexity */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        /* N x M x 4 time complexity */
        while (!queue.isEmpty()) {

            int i = queue.peek()[0], j = queue.peek()[1];
            queue.remove();

            for (int [] direction : directions) {

                /* add direction to current index i and j for 4-directional */
                int newI = i + direction[0], newJ = j + direction[1];

                /* new indexes newI between 0 and m and newJ between 0 and n */
                if (newI >= 0 && newI < m && newJ >= 0 && newJ < n
                && mat[newI][newJ] == -1) {
                    mat[newI][newJ] = mat[i][j] + 1;
                    queue.add(new int[]{newI, newJ});
                }
            }
        }

        return mat;
    }

}
