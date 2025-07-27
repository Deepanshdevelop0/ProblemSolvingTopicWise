package Graphs.BFS_DFS;

import java.util.ArrayList;

public class undirectedGraphCycle {


    public static void main(String[] args) {

        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int[][] edges1 = new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}, {4, 6}, {7, 8}};

        System.out.println(isCycle(8, edges));

    }


    public static boolean isCycle(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = getAdjList(V, edges);

        boolean[] visited = new boolean[V+1];

        boolean res = false;

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, -1, res, visited, adjList))
                    return true;
            }

        }

        return res;
    }

    public static ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }

        return adjList;
    }

    public static boolean dfs(int curr, int parent, boolean res, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {

        visited[curr] = true;

        for (int i : adjList.get(curr)) {

            /* if i is still not visited then call dfs for it with curr as its parent */
            if (!visited[i]) {
                if (dfs(i, curr, res, visited, adjList))
                    return true;
            }
            /* if this i is already visited (as above condition fails) and not equals to its parent,
             means it is repeating and forming a cycle */
            else if (i != parent) {
                return true;
            }

        }

        return res;
    }

}
