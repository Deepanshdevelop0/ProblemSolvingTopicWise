package Graphs.BFS_DFS.BFS_BASED;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class floodFill {

    public static void main(String[] args) {

        int[][] image = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] image1 = new int[][]{{0, 0, 0}, {0, 1, 0}};
        int[][] grid2 = new int[][]{{2, 1, 1, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {0, 1, 1, 2}};

        Arrays.stream(floodFill(image1, 1, 1, 2)).forEach(i -> {
            for(int j : i) System.out.print(j + ", ");
            System.out.println();
        });

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;

        Queue<int[]> queue = new ArrayDeque<>();

        /* add starting pixel of image [sr][sc] */
        queue.add(new int[]{sr, sc});

        int colSize = image.length, rowSize = image[0].length;
        int startingColor = image[sr][sc];


        /* fill starting index */
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            bfs(rowSize, colSize, startingColor, color, image, queue);
        }

        return image;
    }

    public static void bfs(int rowSize, int colSize, int startingColor, int color, int[][] image, Queue<int[]> queue) {

        int[] curr = queue.poll();

        int i = curr[0], j = curr[1];

        /* up */
        if (i > 0 && image[i - 1][j] == startingColor) {
            image[i - 1][j] = color;
            queue.add(new int[]{i - 1, j});
        }

        /* left */
        if (j > 0 && image[i][j - 1] == startingColor) {
            image[i][j - 1] = color;
            queue.add(new int[]{i, j - 1});
        }

        /* down */
        if (i < colSize - 1 && image[i + 1][j] == startingColor) {
            image[i + 1][j] = color;
            queue.add(new int[]{i + 1, j});
        }

        /* right */
        if (j < rowSize - 1 && image[i][j + 1] == startingColor) {
            image[i][j + 1] = color;
            queue.add(new int[]{i, j + 1});
        }

    }

}
