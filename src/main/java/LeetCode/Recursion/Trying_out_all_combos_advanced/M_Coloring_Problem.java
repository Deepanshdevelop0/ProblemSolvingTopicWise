package LeetCode.Recursion.Trying_out_all_combos_advanced;

import java.util.ArrayList;
import java.util.List;

public class M_Coloring_Problem {

    public static void main(String[] args) {
        M_Coloring_Problem classObj = new M_Coloring_Problem();
//        boolean res = classObj.graphColoring(4, new int[][]{
//                {0, 1},
//                {1, 3},
//                {2, 3},
//                {3, 0},
//                {0, 2}
//        }, 3);

        boolean res = classObj.graphColoring(4, new int[][]{
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0},
                {0, 2},
        }, 3);

        System.out.println("result : " + res);
    }


    public boolean graphColoring(int v, int[][] edges, int m) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] vertex : edges) {
            int U = vertex[0], V = vertex[1];
            adjList.get(U).add(V);
            adjList.get(V).add(U);
        }

        int[] colors = new int[v];

        return solve(0, v, m, colors, adjList);
    }

    public boolean solve(int vertex, int v, int m, int[] colors, List<List<Integer>> adjList) {
        if (vertex == v) {
            return true;
        }

        for (int color = 1; color <= m; color++) {
            if (isSafe(vertex, color, colors, adjList)) {

                colors[vertex] = color;

                if (solve(vertex + 1, v, m, colors, adjList)) {
                    return true;
                }

                colors[vertex] = 0;
            }
        }

        return false;
    }

    public boolean isSafe(int vertex, int color, int[] colors, List<List<Integer>> adjList) {
        List<Integer> neighbors = adjList.get(vertex);

        for (int neighbor : neighbors) {
            if (colors[neighbor] == color) {
                return false;
            }
        }

        return true;
    }


}
