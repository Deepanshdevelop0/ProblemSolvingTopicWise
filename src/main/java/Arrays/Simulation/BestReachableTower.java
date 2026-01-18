package Arrays.Simulation;

import java.util.Arrays;

public class BestReachableTower {

    public static void main(String[] args) {

        BestReachableTower solver = new BestReachableTower();

        // Example 1: Basic reachability
        int[][] towers1 = {{1, 2, 5}, {2, 1, 7}, {3, 1, 9}};
        int[] center1 = {1, 1};
        int radius1 = 2;
        System.out.println("Example 1: " + Arrays.toString(solver.bestTower(towers1, center1, radius1)));
        // Expected: [3, 1]

        // Example 2: Quality tie-breaker (Lexicographical check)
        int[][] towers2 = {{1, 3, 4}, {2, 2, 4}, {4, 4, 7}};
        int[] center2 = {0, 0};
        int radius2 = 5;
        System.out.println("Example 2: " + Arrays.toString(solver.bestTower(towers2, center2, radius2)));
        // Expected: [1, 3]

        // Example 3: No towers reachable
        int[][] towers3 = {{5, 6, 8}, {0, 3, 5}};
        int[] center3 = {1, 2};
        int radius3 = 1;
        System.out.println("Example 3: " + Arrays.toString(solver.bestTower(towers3, center3, radius3)));
        // Expected: [-1, -1]
    }


    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int max = -1, x = -1, y = -1;

        for (int[] arr : towers) {
            int man_dist = Math.abs(arr[0] - center[0]) + Math.abs(arr[1] - center[1]);

            if (man_dist <= radius) {
                if (arr[2] > max) {
                    max = arr[2];
                    x = arr[0];
                    y = arr[1];
                } else if (arr[2] == max) {
                    if (arr[0] < x || (arr[0] == x && arr[1] < y)) {
                        x = arr[0];
                        y = arr[1];
                    }
                }
            }
        }

        return new int[] { x, y };
    }
}
