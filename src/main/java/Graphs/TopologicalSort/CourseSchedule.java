package Graphs.TopologicalSort;

import java.util.*;

public class CourseSchedule {

/*
 Time Complexity: O(V + E)
 - O(V) to visit all courses (vertices)
 - O(E) to traverse all prerequisite pairs (edges)
 Space Complexity: O(V + E)
 - O(V + E) for adjacency list storage
 - O(V) for visited[] and recursion stack
 - O(V) for visitedSet (at most V elements)
*/


    public static void main(String[] args) {

        int[][] prerequisites = new int[][]{{1, 0}, {1, 2}, {3, 1}, {2,3}, {2, 4}, {4, 5}, {2, 5}};


        System.out.println(canFinish(6, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // Build adjacency list: course b -> list of courses that depend on b
        ArrayList<ArrayList<Integer>> adjList = getAdjList(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses + 1]; // Tracks visited nodes globally
        Set<Integer> visitedSet = new HashSet<>();       // Tracks recursion stack for cycle detection

        boolean status = true;

        // Check each course in case graph is disconnected
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i] && status) {
                status = dfs(i, status, visited, visitedSet, adjList);
            }
        }


        return status;
    }

    public static boolean dfs(int curr, boolean status, boolean[] visited, Set<Integer> visitedSet,
                              ArrayList<ArrayList<Integer>> adjList) {

        if (!status) return status; // Early exit if cycle already found

        visited[curr] = true;   // Mark as visited
        visitedSet.add(curr);    // Add to current recursion path

        List<Integer> currAdjList = adjList.get(curr);

        // Explore neighbors (dependent courses)
        for (int i : currAdjList) {
            if (!visited[i]) {
                status = dfs(i, status, visited, visitedSet, adjList);
            } else if (visitedSet.contains(i)) {
                return false;   // Cycle detected
            }
        }

        visitedSet.remove(curr);    // Backtrack

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
