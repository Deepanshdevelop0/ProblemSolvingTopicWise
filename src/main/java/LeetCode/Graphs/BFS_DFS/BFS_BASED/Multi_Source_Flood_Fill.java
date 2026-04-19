package LeetCode.Graphs.BFS_DFS.BFS_BASED;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Multi_Source_Flood_Fill {


/* colorGrid method: (using Multi-Source BFS & Initial Sorting)

 TC: O(S x (log S) + N * M), where S is the number of sources.
  * Sorting the sources ensures color priority, and BFS visits each cell
    at most once, making it highly efficient for grid sizes up to 10^5.

 SC: O(N * M) to store the result grid and the BFS queue.
 -----------------------------------------------------------------
 Note: Sorting sources by color in descending order is the key "Optimal"
 trick. It allows a standard BFS to handle the "simultaneous spread"
 and "maximum color wins" rules without needing a secondary 'time'
 array or multiple passes over the grid.

*/

    public static void main(String[] args) {
        Multi_Source_Flood_Fill classObj = new Multi_Source_Flood_Fill();
        int n = 3, m = 3;
        int[][] sources = {{0, 0, 1}, {2, 2, 2}};

        int[][] result = classObj.colorGrid(n, m, sources);

        System.out.println("Final Grid State:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }


    /* The Logic in Brief

    1. Sorting: By processing larger colors first, we ensure they "win" any tie where two sources reach a cell at the same time.

    2. Multi-Source BFS: Treating all sources as a starting "wave" ensures we find the shortest distance (simultaneous spread) for every cell.

    3. Boundary Safety: Correctly using n for rows and m for columns prevents premature stopping or crashes.    */

    public int[][] colorGrid(int n, int m, int[][] sources) {
        // res[r][c] serves as both the final grid and the "visited" tracker
        int[][] res = new int[n][m];

        // 1. Sort sources by color value (descending)
        // This ensures the maximum color wins if two reach a cell simultaneously.
        // PS: As from 2,1, 2 will be polled first and adjacent index would be filled by 2.
        // So no extra logic would be required to check the greater of two colors that tie.
        Arrays.sort(sources, (a, b) -> b[2] - a[2]);

        // Queue for Multi-Source BFS: stores {row, col, color}
        Queue<int[]> queue = new LinkedList<>();

        // 2. Initialize grid with all starting sources
        for (int[] i : sources) {
            int r = i[0], c = i[1], color = i[2];
            res[r][c] = color;
            queue.offer(new int[]{r, c, color});
        }

        // 4-Directional movement vectors (Up, Down, Right, Left)
        int[] directionR = new int[]{-1, 1, 0, 0};
        int[] directionC = new int[]{0, 0, 1, -1};

        // 3. Start Simultaneous Spread (BFS)
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], color = curr[2];

            for (int i = 0; i < 4; i++) {
                // next row and col (curr (Row/Col) + nextDirection (Row/Col))
                int nr = r + directionR[i];
                int nc = c + directionC[i];

                // VALIDATION:
                // nr < n (row limit)
                // nc < m (column limit)
                // res[nr][nc] == 0 (uncolored cell)
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && res[nr][nc] == 0) {
                        res[nr][nc] = color;
                        queue.offer(new int[]{nr, nc, color}); // Spread from here next (add in queue to pick that next)
                }
            }
        }

        return res;
    }
}
