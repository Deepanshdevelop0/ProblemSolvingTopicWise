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

        int[][] prerequisites = new int[][]{{1, 0}, {1, 2}, {3, 1}, {2, 3}, {2, 4}, {4, 5}, {2, 5}};

        System.out.println(canFinish(6, prerequisites));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjList = getAdjList(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses + 1];

        Set<Integer> visitedSet = new HashSet<>();
        boolean status = true;

        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i] && status) {
                status = dfs(i, status, visited, visitedSet, adjList);
            }
        }

        return status;
    }

    public static boolean dfs(int curr, boolean status, boolean[] visited, Set<Integer> visitedSet, ArrayList<ArrayList<Integer>> adjList) {

        if (!status) {
            return status;
        }

        visited[curr] = true;
        visitedSet.add(curr);

        List<Integer> currList = adjList.get(curr);

        for (int i : currList) {
            if (!visited[i]) {
                status = dfs(i, status, visited, visitedSet, adjList);
            } else if (visitedSet.contains(i)) {
                return false;
            }
        }

        visitedSet.remove(curr);

        return status;
    }


    public static ArrayList<ArrayList<Integer>> getAdjList(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] arr : prerequisites) {
            adjList.get(arr[0]).add(arr[1]);
        }

        return adjList;
    }

}
