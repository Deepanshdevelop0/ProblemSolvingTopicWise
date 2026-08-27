package LeetCode.Recursion.Trying_out_all_combos_advanced;

import java.util.ArrayList;

public class Rat_in_a_Maze {

/*

Time Complexity: O(4^(N^2))
- In the absolute worst-case scenario (an empty maze), from every cell, the rat can potentially explore 3 to 4 directions.
- Since the path length can be up to N^2 (visiting every cell), the upper bound of the recursion tree is 4^(N^2).

Space Complexity: O(L) or O(N^2)
- Auxiliary Space: The maximum depth of the recursion tree is the maximum length of a path, which is N^2. Therefore, the call stack takes O(N^2) space.
- By using in-place modification, we removed the extra O(N^2) space used by the boolean matrix.

*/
    public static void main(String[] args) {
        Rat_in_a_Maze classObj = new Rat_in_a_Maze();
        classObj.ratInMaze(new int[][]{{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}}).forEach(i -> {
            System.out.print("[");
            System.out.print(i + ", ");
            System.out.println("]");
        });
    }

    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();

        if (maze[0][0] == 0) return res;

        boolean[][] visited = new boolean[maze.length][maze[0].length];

//        findAllPaths(0, 0, maze.length, new StringBuilder(), visited, maze, res);


        // space optimized (in place) with no visited matrix usage
        findAllPathsInPlace(0, 0, maze.length, new StringBuilder(), maze, res);

        return res;
    }

    public void findAllPaths(int row, int col, int n, StringBuilder direction, boolean[][] visited, int[][] maze, ArrayList<String> res) {
        if (row < 0 || col < 0 || row == n || col == n) return;
        if (visited[row][col] || maze[row][col] == 0) return;
        if (row == n - 1 && col == n - 1) {
            res.add(direction.toString());
            return;
        }

        visited[row][col] = true;

        // down
        direction.append("D");
        findAllPaths(row + 1, col, n, direction, visited, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        // left
        direction.append("L");
        findAllPaths(row, col - 1, n, direction, visited, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        // right
        direction.append("R");
        findAllPaths(row, col + 1, n, direction, visited, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        // upside
        direction.append("U");
        findAllPaths(row - 1, col, n, direction, visited, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        visited[row][col] = false;

    }


    public void findAllPathsInPlace(int row, int col, int n, StringBuilder direction, int[][] maze, ArrayList<String> res) {
        if (row < 0 || col < 0 || row == n || col == n) return;
        if (maze[row][col] == 0) return;
        if (row == n - 1 && col == n - 1) {
            res.add(direction.toString());
            return;
        }

        maze[row][col] = 0;

        // down
        direction.append("D");
        findAllPathsInPlace(row + 1, col, n, direction, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        // left
        direction.append("L");
        findAllPathsInPlace(row, col - 1, n, direction, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        // right
        direction.append("R");
        findAllPathsInPlace(row, col + 1, n, direction, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        // upside
        direction.append("U");
        findAllPathsInPlace(row - 1, col, n, direction, maze, res);
        direction.deleteCharAt(direction.length() - 1);

        maze[row][col] = 1;

    }


}
