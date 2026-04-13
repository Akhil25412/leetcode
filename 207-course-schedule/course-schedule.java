import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        // Build graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]); // b -> a
        }

        int[] state = new int[numCourses]; // 0,1,2

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (hasCycle(graph, state, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return true;  // cycle found
        if (state[node] == 2) return false; // already safe

        state[node] = 1; // mark visiting

        for (int neighbor : graph.get(node)) {
            if (hasCycle(graph, state, neighbor)) {
                return true;
            }
        }

        state[node] = 2; // mark safe
        return false;
    }
}