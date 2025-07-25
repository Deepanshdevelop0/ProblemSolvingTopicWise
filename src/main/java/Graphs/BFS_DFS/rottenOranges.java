package Graphs.BFS_DFS;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] grid1 = new int[][]{{0, 2}};
        int[][] grid2 = new int[][]{{2, 1, 1, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 2}};

        System.out.println(orangesRotting(grid2));

    }

    public static int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int col = grid.length, row = grid[0].length;

        int fresh = 0, minutes = 0;

        /* Collect all the indexes of rotten oranges (2 ones) in queue to track traversal from all rotten oranges */
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                int curr = grid[i][j];
                if (curr == 2) {
                    queue.add(new int[]{i, j});
                } else if (curr == 1) {
                    fresh++;
                }
            }
        }

        /* if no fresh, nothing to rot*/
        if (fresh == 0) return 0;

        /* q != empty, until new fresh oranges are available to rot 4-directionally (up-down-left-right) */
        while (!queue.isEmpty()) {

            /* get size to increment minute after first lot of rotten oranges have rotted 4-directionally fresh oranges */
            /* as all rotten oranges will rot other 4-directionally fresh oranges together,
             So increment minute after rotting round for each rotten orange is completed   */
            int size = queue.size();
            int newRot = 0;

            for (int i = 0; i < size; i++) {

                /* track how many fresh oranges got rotten and add in newRot */
                newRot += bfs(row, col, grid, queue);

            }

            if (newRot > 0) {
                minutes++;
                fresh -= newRot;
            }

        }

        return (fresh > 0) ? -1 : minutes;
    }

    public static int bfs(int rowSize, int colSize, int[][] grid, Queue<int[]> queue) {

        int[] rot = queue.remove();
        int i = rot[0], j = rot[1];
        int newRot = 0;

        /* up */
        if (i > 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            queue.add(new int[]{i - 1, j});
            newRot++;
        }

        /* left */
        if (j > 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            queue.add(new int[]{i, j - 1});
            newRot++;
        }

        /* down */
        if (i < colSize - 1 && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            queue.add(new int[]{i + 1, j});
            newRot++;
        }

        /* right */
        if (j < rowSize - 1 && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            queue.add(new int[]{i, j + 1});
            newRot++;
        }


        return newRot;
    }

}
