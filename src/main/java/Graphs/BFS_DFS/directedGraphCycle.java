package Graphs.BFS_DFS;

import java.util.ArrayList;

public class directedGraphCycle {


    public static void main(String[] args) {

        int[][] edges = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}};
        int[][] edges1 = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}, {2, 0}, {1, 3}};
        int[][] edges2 = new int[][]{{2, 1}, {1, 2}, {2, 0}};

        System.out.println(isCyclic(3, edges2));

    }

    public static boolean isCyclic(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = getAdjList(V, edges);
        boolean[] visited = new boolean[V+1];
        boolean[] recStack = new boolean[V+1];

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adjList))
                    return true;
            }
        }

        return false;
    }


    public static ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
        }

        return adjList;
    }

    public static boolean dfs(int curr, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adjList) {

        visited[curr] = true;
        recStack[curr] = true;

        for (int i : adjList.get(curr)) {

            /* if i is still not visited then call dfs for it with curr */
            if (!visited[i]) {
                if (dfs(i, visited, recStack, adjList))
                    return true;
            }
            /* if this i is already in true recStack which means the traversal is still going from the same i (parent)
            (else we would have marked it false if not in current parent recStack which means it reoccurs)
             means it is repeating and forming a cycle */
            else if(recStack[i]) {
                return true;
            }

        }

        recStack[curr] = false;
        return false;
    }

}
