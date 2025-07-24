package Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class connectedComponentsInUndirectedGraph {


    public static void main1(String[] args) {

        int[][] edges = new int[5][5];

        // Populate the 2D array with the given values
        edges[0][0] = 0;
        edges[0][1] = 1;

        edges[1][0] = 6;
        edges[1][1] = 0;

        edges[2][0] = 2;
        edges[2][1] = 4;

        edges[3][0] = 2;
        edges[3][1] = 3;

        edges[4][0] = 3;
        edges[4][1] = 4;

        getComponents(7, edges).forEach(System.out::println);


    }

    public static ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = createAdjacencyList(V, edges);

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> connectedComponent = new ArrayList<>();
                dfs(i, connectedComponent, visited, adjList);
                res.add(connectedComponent);
            }
        }

        return res;
    }

    public static void dfs(int curr, ArrayList<Integer> connectedComponent,
                           boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {

        visited[curr] = true;
        connectedComponent.add(curr);

        ArrayList<Integer> temp = adjList.get(curr);

        for (int i : temp) {
            if (!visited[i]) {
                dfs(i, connectedComponent, visited, adjList);
            }
        }


    }

    public static ArrayList<ArrayList<Integer>> createAdjacencyList(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }

}
