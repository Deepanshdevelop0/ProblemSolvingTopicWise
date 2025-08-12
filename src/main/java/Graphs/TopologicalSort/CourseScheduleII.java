package Graphs.TopologicalSort;

import java.util.*;

public class CourseScheduleII {

/* Gyan :

Here’s the tiny one-line rule I promised:

“If A must be done before B, draw the edge A → B.”

That’s it.
Then, whether you’re building an adjacency list or an indegree array, just stick to that mental picture.

So:

In Course Schedule (prerequisites), if [a, b] means "b must be done before a", you add b → a in your adjacency list.

In dependency problems, the same principle applies—always from prerequisite → dependent.

That way you never have to “remember” which way, you just follow the story. */


/* Complexity Analysis :

DFS + Topo Sort

n = numCourses, m = prerequisites.length

TC : O(m) + O(n+m) + O(n) ~ O(n+m)

1. Building adjacency list (for edges)
2. DFS traversal in adjList
3. To create topo sort array from stack

SC : O(n+m) + O(n) + O(n) + O(n) + O(n)

1. adjacency List storage
2. visited boolean array
3. visitedSet storage
4. recursion stack storage
5. Output res list

*/




    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{{1, 0}, {1, 2}, {3, 1}, {2, 3}, {2, 4}, {4, 5}, {2, 5}};
        int[][] prerequisites1 = new int[][]{{1, 0}, {1, 2}, {3, 1}, {3, 2}, {2, 4}, {4, 5}, {2, 5}};

        Arrays.stream(findOrder(6, prerequisites1)).forEach(i -> System.out.print(i + ", "));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Build adjacency list: course b -> list of courses that depend on b
        ArrayList<ArrayList<Integer>> adjList = getAdjList(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses + 1];    // Tracks globally visited nodes
        Set<Integer> visitedSet = new HashSet<>();          // Tracks recursion stack for cycle detection

        Stack<Integer> resStack = new Stack<>();    // Stores topological order in reverse

        boolean status = true;  // True means no cycle found

        // Process all courses (graph may be disconnected)
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i] && status) {
                status = dfs(i, status, resStack, visited, visitedSet, adjList);
            }
        }


        /* if status is true (no cycle found) -> build final order array from stack */
        if (status) {

            int[] res = new int[numCourses];
            int i = 0;
            while (!resStack.isEmpty()) {
                res[i++] = resStack.pop();
            }

            return res;
        }

        return new int[]{}; // Return empty array if cycle exists
    }

    public static boolean dfs(int curr, boolean status, Stack<Integer> resStack, boolean[] visited, Set<Integer> visitedSet,
                              ArrayList<ArrayList<Integer>> adjList) {

        if (!status) return status; // Early exit if cycle already found

        visited[curr] = true;   // Mark as visited
        visitedSet.add(curr);   // Add to recursion stack

        List<Integer> currAdjList = adjList.get(curr);

        // Traverse neighbors (dependent courses)
        for (int i : currAdjList) {
            if (!visited[i]) {
                status = dfs(i, status, resStack, visited, visitedSet, adjList);
            } else if (visitedSet.contains(i)) {
                return false;   // Cycle Detected
            }
        }

        visitedSet.remove(curr);    // Backtrack
        resStack.push(curr);        // Add to result after visiting dependencies

        return status;
    }

    public static ArrayList<ArrayList<Integer>> getAdjList(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        /* For each prerequisite [a, b], add edge b -> a
           Remember course preq[1] comes before preq[0] means preq[1] --> preq[0] */
        for (int[] preq : prerequisites) {
            adjList.get(preq[1]).add(preq[0]);
        }

        return adjList;
    }

}
