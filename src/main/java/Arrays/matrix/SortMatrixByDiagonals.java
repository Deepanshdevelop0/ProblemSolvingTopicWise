package Arrays.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortMatrixByDiagonals {


/*

Iterative Solution :

1. TC : O(2n²) + O(n² logn) ~ O(n² logn)

    i. for (n x n) matrix, each element is visited twice for storage and replacing O(2 x N²)
    ii. Sorting (all diagonals): O(n² logn)

    * A diagonal of length k takes O(k log k) time to sort.

    * Example (5×5):
    Diagonals from 1 → 5 elements long.
    So sorting costs: 1log1+2log2+3log3+4log4+5log5+…
    Rough bound: each element contributes up to O(log n) in sorting.

    * Since there are n² total elements: O(n² logn)

2. SC : O(n) : Space is strictly O(n), no extra call stack.

    i. for extra list per diagonal, max size N (longest diagonal)

-------------------------------

Recursive Solution (DFS) :

1. TC :

    i. Per diagonal of length k:

    Collect k elements via recursion: O(k)
    Sort once at the base case: O(k log k)
    Write back during unwinding: O(k)
    ➜ Per diagonal: O(k log k + k) = O(k log k)
    Summed over all diagonals (lengths 1…n…1; total elements n²):

     = ∑O(k log k) = O(n² log n)

2. SC : O(n) : Still O(n) auxiliary space, but recursion stack adds practical overhead compared to iterative.

    i. list holds at most one diagonal: O(n)
    ii. Recursion stack depth equals the diagonal length (worst case n): O(n)


*/

    public static void main(String[] args) {
        int[][] grid = new int[][]{{10, 3, 6, 1},{4, 7, 2, 5},{9, 8, 12, 11},{13, 14, 0, 15}};

        for (int[] i : sortMatrixIterative(grid)) {
            Arrays.stream(i).forEach(j -> {
                System.out.print(j + ", ");
            });
            System.out.println();
        }

    }


    public static int[][] sortMatrixIterative(int[][] grid) {

        int n = grid.length;

        /* Top right part of grid excluding 0,0 diagonal for decreasing order */
        for (int i = 1; i < n-1; i++) {
            int r = 0, c = i;

            List<Integer> list = new ArrayList<>();

            /* collect the elements from top right part */
            while (r < n && c < n) {
                list.add(grid[r++][c++]);
            }

            list.sort(Comparator.naturalOrder());

            r = 0; c = i;

            /* place the sorted elements again in grid */
            int j = 0;
            while (r < n && c < n) {
                grid[r++][c++] = list.get(j++);
            }
        }


        /* Bottom left part of grid including 0,0 diagonal for decreasing order */
        for (int i = 0; i < n-1; i++) {

            int r = i, c = 0;

            List<Integer> list = new ArrayList<>();

            /* collect the elements from bottom left part */
            while (r < n && c < n) {
                list.add(grid[r++][c++]);
            }

            list.sort(Comparator.reverseOrder());

            r = i; c = 0;

            /* place the sorted elements again in grid */
            int j = 0;
            while (r < n && c < n) {
                grid[r++][c++] = list.get(j++);
            }

        }

        return grid;
    }

    public static int[][] sortMatrixUsingDfs(int[][] grid) {

        int m = grid.length;

        List<Integer> list = new ArrayList<>();

        /* for first row in grid */
        for (int i = 1; i < m-1; i++) {
            dfs(0, i, grid, list, Comparator.naturalOrder());
        }

        /* for first column in grid */
        for (int i = 0; i < m-1; i++) {
            dfs(i, 0, grid, list, Comparator.reverseOrder());
        }

        return grid;

    }

    public static void dfs(int i, int j, int[][] grid, List<Integer> list , Comparator c) {

        if (i == grid.length || j == grid.length) {
            list.sort(c);
            return;
        }

        list.add(grid[i][j]);
        dfs(i+1, j+1, grid, list, c);
        grid[i][j] = list.get(list.size() - 1);
        list.remove(list.size() - 1);

    }





}
