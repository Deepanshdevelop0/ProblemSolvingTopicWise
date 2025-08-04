package Graphs.TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class kahnAlgoTopologicalSort {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{3, 0}, {1, 0}, {2, 0}};
        int[][] edges1 = new int[][]{{1, 3}, {2, 3}, {4, 1}, {4, 0}, {5, 0}, {5,2}};

        ArrayList<Integer> res = topoSort(4, edges);

        for (int node : res) {
            System.out.print(node + ", ");
        }

    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {

        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjList = getAdjList(V, edges);

        int[] indegreeArr = new int[V];
        getIndegreeArr(indegreeArr, adjList);

        Queue<Integer> queue = new ArrayDeque<>();

        /* add nodes with indegree 0 (as they will first appear because of no incoming edges (indegree)) */
        for (int i = 0; i < V; i++) {
            if (indegreeArr[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {

            int peek = queue.remove();

            /* add to resultList */
            res.add(peek);

            ArrayList<Integer> peekAdj = adjList.get(peek);

            for (int i : peekAdj) {
                indegreeArr[i]--;

                /* if indegree is 0, add it to queue */
                if (indegreeArr[i] == 0) queue.add(i);
            }

        }

        return res;
    }


    public static void getIndegreeArr(int[] indegreeArr, ArrayList<ArrayList<Integer>> adjList) {

        for (ArrayList<Integer> adj : adjList) {
            for (int i : adj) {
                indegreeArr[i]++;
            }
        }

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
