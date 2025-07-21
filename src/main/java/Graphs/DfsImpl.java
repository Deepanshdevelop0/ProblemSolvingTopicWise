package Graphs;

import java.util.*;
import java.util.ArrayList;

public class DfsImpl {

    public static void main(String[] args) {

        int V = 9; // total number of vertices (0 to 8)

        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Building the graph (based on the image)
        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(5);
        adj.get(5).add(2);

        adj.get(2).add(6);
        adj.get(6).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(3).add(7);
        adj.get(7).add(3);

        adj.get(4).add(8);
        adj.get(8).add(4);

        adj.get(7).add(8);
        adj.get(8).add(7);

        ArrayList<Integer> ans = dfsOfGraph(adj);
        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    public static ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        ArrayList<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[v+1];

        visited[1] = true;

        dfs(1, visited, res, adj);

        return res;
    }

    public static void dfs(int curr, boolean[] visited, ArrayList<Integer> res, ArrayList<ArrayList<Integer>> adj) {

        List<Integer> currAdjList = adj.get(curr);

        visited[curr] = true;
        res.add(curr);

        for (int i : currAdjList) {
            if (!visited[i]) {
                dfs(i, visited, res, adj);
            }
        }

    }

}
