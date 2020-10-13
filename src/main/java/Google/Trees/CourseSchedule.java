package Google.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
//    There are a total of n courses you have to take labelled from 0 to n - 1.
//    Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
//    Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
//    If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.


    public static void main(String[] args) {

        int[][] prereq = new int[][] {{1,0}, {2,0}, {3,1}, {3,2}};
        int[] order = findOrder(4, prereq);

        System.out.println(order);
    }

    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    static boolean isPossible;
    static Map<Integer, Integer> color;
    static Map<Integer, List<Integer>> adjList;
    static List<Integer> topologicalOrder;

    private static void init(int numCourses) {
        isPossible = true;
        color = new HashMap<Integer, Integer>();
        adjList = new HashMap<Integer, List<Integer>>();
        topologicalOrder = new ArrayList<Integer>();

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    private static void dfs(int node) {

        // Don't recurse further if we found a cycle already
        if (!isPossible) {
            return;
        }

        // Start the recursion
        color.put(node, GRAY);

        // Traverse on neighboring vertices
        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                isPossible = false;
            }
        }

        // Recursion ends. We mark it as black
        color.put(node, BLACK);
        topologicalOrder.add(node);
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        init(numCourses);

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;
        if (isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }
}
