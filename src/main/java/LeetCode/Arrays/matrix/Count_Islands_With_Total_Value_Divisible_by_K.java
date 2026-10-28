package LeetCode.Arrays.matrix;

public class Count_Islands_With_Total_Value_Divisible_by_K {

    public static void main(String[] args) {
        Count_Islands_With_Total_Value_Divisible_by_K classObj = new Count_Islands_With_Total_Value_Divisible_by_K();
        int res = classObj.countIslandsSpaceOptimizedWithInPlaceModifications(new int[][]{
                {0, 2, 1, 0, 0}, {0, 5, 0, 0, 5}, {0, 0, 1, 0, 0}, {0, 1, 4, 7, 0}, {0, 2, 0, 0, 8}
        }, 5);

        System.out.println(res);
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j] && grid[i][j] > 0) {
                    long totalSum = findRecursive(grid, m, n, visited, i, j);
                    islandCount += (totalSum % k == 0) ? 1 : 0;
                }
            }
        }

        return islandCount;
    }

    public int countIslandsSpaceOptimizedWithInPlaceModifications(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] > 0) {
                    int totalSum = findRecursiveSpaceOptimizedWithInPlace(grid, m, n, k, i, j);
                    islandCount += (totalSum % k == 0) ? 1 : 0;
                }
            }
        }

        return islandCount;
    }


    public long findRecursive(int[][] grid, int m, int n, boolean[][] visited, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        if (visited[row][col]) {
            return 0;
        }
        if (grid[row][col] <= 0) {
            return 0;
        }

        visited[row][col] = true;

        long allDirectionSum = 0;

        allDirectionSum += findRecursive(grid, m, n, visited, row - 1, col); // up direction
        allDirectionSum += findRecursive(grid, m, n, visited, row + 1, col); // down direction
        allDirectionSum += findRecursive(grid, m, n, visited, row, col - 1); // left direction
        allDirectionSum += findRecursive(grid, m, n, visited, row, col + 1); // right direction

        return grid[row][col] + allDirectionSum;
    }

    public int findRecursiveSpaceOptimizedWithInPlace(int[][] grid, int m, int n, int k, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 0;
        }
        if (grid[row][col] <= 0) {
            return 0;
        }

        int curr = grid[row][col];
        grid[row][col] = 0;

        int allDirectionSum = 0;

        allDirectionSum += findRecursiveSpaceOptimizedWithInPlace(grid, m, n, k, row - 1, col); // up direction
        allDirectionSum += findRecursiveSpaceOptimizedWithInPlace(grid, m, n, k, row + 1, col); // down direction
        allDirectionSum += findRecursiveSpaceOptimizedWithInPlace(grid, m, n, k, row, col - 1); // left direction
        allDirectionSum += findRecursiveSpaceOptimizedWithInPlace(grid, m, n, k, row, col + 1); // right direction

        return (curr + allDirectionSum) % k; // to avoid integer overflow and avoid using the long
    }


}
