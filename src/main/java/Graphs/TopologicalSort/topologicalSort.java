package Graphs.TopologicalSort;

import java.util.ArrayList;
import java.util.Stack;

public class topologicalSort {

    public static void main(String[] args) {

        int[][] edges = new int[][]{{3, 0}, {1, 0}, {2, 0}};
        int[][] edges1 = new int[][]{{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5,2}};

        ArrayList<Integer> res = topoSort(6, edges);

        for (int node : res) {
            System.out.print(node + ", ");
        }

    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = getAdjList(V, edges);

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V+1];

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                dfs(i, stack, visited, adjList);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!stack.isEmpty()) {

            res.add(stack.pop());
        }


        return res;
    }

    public static void dfs(int curr, Stack<Integer> stack, boolean[] visited,
                           ArrayList<ArrayList<Integer>> adjList) {

        visited[curr] = true;

        ArrayList<Integer> currList = adjList.get(curr);

        for (Integer i : currList) {
            if (!visited[i]) {
                dfs(i, stack, visited, adjList);
            }
        }

        stack.push(curr);
    }

    public static ArrayList<ArrayList<Integer>> getAdjList(int V, int[][] edges) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
        }

        return adjList;
    }


}
