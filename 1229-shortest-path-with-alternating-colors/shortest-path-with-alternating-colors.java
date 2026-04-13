import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph: (neighbor, color)
        // 0 = red, 1 = blue
        for (int[] e : redEdges) {
            graph.get(e[0]).add(new int[]{e[1], 0});
        }
        for (int[] e : blueEdges) {
            graph.get(e[0]).add(new int[]{e[1], 1});
        }

        int[][] visited = new int[n][2];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        // start from node 0 with both colors allowed
        queue.offer(new int[]{0, -1}); // node, last color
        visited[0][0] = 0;
        visited[0][1] = 0;

        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int lastColor = curr[1];

                for (int[] edge : graph.get(node)) {
                    int next = edge[0];
                    int color = edge[1];

                    // skip if same color as previous
                    if (color == lastColor) continue;

                    if (visited[next][color] == 1) continue;

                    visited[next][color] = 1;
                    result[next] = Math.min(result[next], steps + 1);
                    queue.offer(new int[]{next, color});
                }
            }

            steps++;
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }

        return result;
    }
}