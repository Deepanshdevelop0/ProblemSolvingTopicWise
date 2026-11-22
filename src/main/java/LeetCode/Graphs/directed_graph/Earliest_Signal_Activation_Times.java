package LeetCode.Graphs.directed_graph;

import java.util.*;

public class Earliest_Signal_Activation_Times {

/* Complexity:

 TC : O((V + E) log E)
 SC : O(V + E)

*/


    public static void main(String[] args) {
        Earliest_Signal_Activation_Times classObj = new Earliest_Signal_Activation_Times();

        int n = 4;
        int[][] edges = new int[][]{{0, 1, 2}, {1, 2, 3}, {0, 2, 5}, {2, 3, 1}};
        int[] requiredSignals = new int[]{3, 1, 2, 1};

        long[] res = classObj.earliestActivationTimes(n, edges, requiredSignals);

        for (long re : res) {
            System.out.print(re + ", ");
        }

    }


    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {

        // 1. Build the adjacency list: graph.get(u) -> list of {neighbor, delay}
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int delay = edge[2];

            adjList.get(u).add(new int[]{v, delay});
        }

        // Track earliest activation time (-1 means inactive)
        long[] res = new long[n];
        Arrays.fill(res, -1);

        // Min-heap storing {arrivalTime, node}, sorted by earliest arrivalTime
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        // 2. Node 0 starts active at time 0 and sends its outgoing signals
        res[0] = 0;
        for (int[] edge : adjList.get(0)) {
            int neighbor = edge[0];
            int delay = edge[1];
            pq.add(new long[]{delay, neighbor});
        }

        // 3. Process signal arrivals chronologically (sorted in asc as per time + delay in pq[0])
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int) curr[1];

            // skip if node is already active
            if (res[node] != -1) {
                continue;
            }

            // One more distinct neighbor's signal has arrived
            requiredSignals[node]--;

            // If all required signals have arrived, activate this node
            if (requiredSignals[node] == 0) {
                res[node] = time;

                for (int[] edge : adjList.get(node)) {
                    int nextNode = edge[0];
                    int delay = edge[1];

                    // add node to queue only if its not active yet
                    if (res[nextNode] == -1) {
                        pq.offer(new long[]{delay + time, nextNode});
                    }
                }
            }
        }

        return res;
    }


}
