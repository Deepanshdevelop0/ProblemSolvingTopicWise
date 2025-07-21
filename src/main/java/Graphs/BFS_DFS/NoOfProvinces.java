package Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class NoOfProvinces {

    public static void main(String[] args) {
        // adjacency matrix
        int[][] isConnected = new int[3][3];

        // Populate the 2D array with the given values
        isConnected[0][0] = 1;
        isConnected[0][1] = 0;
        isConnected[0][2] = 0;

        isConnected[1][0] = 0;
        isConnected[1][1] = 1;
        isConnected[1][2] = 0;

        isConnected[2][0] = 0;
        isConnected[2][1] = 0;
        isConnected[2][2] = 1;


        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {

        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        /* Convert the adjacencyMatrix to adjacencyList */
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }


        int count = 0;
        boolean[] visited = new boolean[V + 1];

        /* for each index in the adjList to iterate */
        for (int i = 0; i < V; i++) {
            /* call the dfs only when previous province is already traversed (curr node is unvisited),
                or in starting pos */
            if (!visited[i]) {
                dfs(i, visited, adjList);
                count++;
            }
        }

        return count;
    }

    public static void dfs(int curr, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {

        List<Integer> currAdjList = adjList.get(curr);

        visited[curr] = true;

        for (int i : currAdjList) {
            if (!visited[i]) {
                dfs(i, visited, adjList);
            }
        }

    }


}
