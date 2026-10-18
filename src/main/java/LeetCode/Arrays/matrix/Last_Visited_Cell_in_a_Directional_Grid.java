package LeetCode.Arrays.matrix;

public class Last_Visited_Cell_in_a_Directional_Grid {

    public static void main(String[] args) {
        Last_Visited_Cell_in_a_Directional_Grid classObj = new Last_Visited_Cell_in_a_Directional_Grid();
        int[] res = classObj.lastVisitedCell1(new char[][]{
                {'R', 'D'},
                {'U', 'L'}
        });

        System.out.println("Result Row : " + res[0] + ", Col = " + res[1]);
    }

    /* If modifying the array is not allowed/cant do in-place */
    public int[] lastVisitedCell(char[][] grid) {

        int m = grid.length, n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int prevR = -1, prevC = -1, r = 0, c = 0;

        while (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {

            visited[r][c] = true;
            prevC = c;
            prevR = r;

            char curr = grid[r][c];

            switch (curr) {
                case 'L' -> c -= 1;
                case 'R' -> c += 1;
                case 'U' -> r -= 1;
                case 'D' -> r += 1;
            }

        }

        return new int[]{prevR, prevC};
    }

    /* If modifying the array is allowed/need to do in-place */

    public int[] lastVisitedCell1(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int prevR = -1, prevC = -1, r = 0, c = 0;

        while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 'X') {

            prevC = c;
            prevR = r;

            char curr = grid[r][c];
            grid[r][c] = 'X';


            switch (curr) {
                case 'L' -> c -= 1;
                case 'R' -> c += 1;
                case 'U' -> r -= 1;
                case 'D' -> r += 1;
            }
        }

        return new int[]{prevR, prevC};
    }


}
