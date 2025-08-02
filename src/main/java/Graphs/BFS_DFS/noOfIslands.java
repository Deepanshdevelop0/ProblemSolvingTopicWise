package Graphs.BFS_DFS;

import java.util.Arrays;

public class noOfIslands {

    public static void main(String[] args) {

        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));

    }

    static int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numIslands(char[][] grid) {

        int n = grid.length, m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, n, m, grid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(int i, int j, int n, int m, char[][] grid) {

        if (grid[i][j] == '0')
            return;

        for (int[] direction : directions) {

            int newI = i + direction[0], newJ = j + direction[1];

            if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == '1') {
                grid[newI][newJ] = '0';
                dfs(newI, newJ, n, m, grid);
            }
        }

    }

}
