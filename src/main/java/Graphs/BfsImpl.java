package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BfsImpl {

    public static void main(String[] args) {
        // { {2, 3, 1}, {0}, {0, 4}, {0}, {2} }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1,4)));
        adj.add(new ArrayList<>(Arrays.asList(2,3)));


        ArrayList<Integer> ans = bfs(adj);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        int s = 0;// source node

        // create an array to store the traversal
        ArrayList<Integer> res = new ArrayList<>();

        // Create a queue for BFS
        Queue<Integer> q = new LinkedList<>();

        // Initially mark all the vertices as not visited
        boolean[] visited = new boolean[v];

        // Mark source node as visited and enqueue it
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {

            int curr = q.poll();
            res.add(curr);

            // Get all adjacent vertices of the dequeued
            // vertex curr If an adjacent has not been
            // visited, mark it visited and enqueue it
            for (int i : adj.get(curr)) {
                // if node isn't visited yet, then pick and add to queue
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }

        }


        return res;
    }

}
