package Graphs.BFS_DFS.DFS_BASED;

import java.util.ArrayList;
import java.util.List;

public class findIfPathExistsInGraph {

    public static void main(String[] args) {

        int[][] edges = new int[3][3];

        // Populate the 2D array with the given values
        edges[0][0] = 0;
        edges[0][1] = 1;

        edges[1][0] = 1;
        edges[1][1] = 2;

        edges[2][0] = 2;
        edges[2][1] = 0;

        System.out.println(validPath(3, edges, 0, 2));

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] vert : edges) {
            int u = vert[0], v = vert[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        dfs(source, visited, adjList);


        return visited[destination];
    }

    public static void dfs(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {

        List<Integer> currAdjList = adjList.get(source);

        visited[source] = true;

        for (int i : currAdjList) {
            if (!visited[i]) {
                dfs(i, visited, adjList);
            }
        }

    }

}
