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

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] vertices : edges) {
            int U = vertices[0], V = vertices[1];
            adjList.get(U).add(V);
        }

        boolean[] visited = new boolean[v];
        int color = 1;

        for (int i = 0; i < v; i++) {
            if (!adjList.get(i).isEmpty() && !visited[i]) {
                if (!solve(i, color, m, visited, adjList)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(int vertex, int color, int m, boolean[] visited, List<List<Integer>> adjList) {

        if (visited[vertex]) return true;
        if (color > m) return false;

        visited[vertex] = true;

        List<Integer> subList = adjList.get(vertex);

        for (Integer currVertex : subList) {
            if (!solve(currVertex, color + 1, m, visited, adjList)) {
                return false;
            }
        }

        return true;
    }


}
