class Solution {
    List<Integer> ans = new ArrayList<>();

    public boolean dfs(int curr, int[][] graph, int[] vis,
                       int[] path, boolean[] isNotSafe) {

        vis[curr] = 1;

        // Already known to be unsafe
        if (isNotSafe[curr]) {
            return false;
        }

        path[curr] = 1;

        for (int it : graph[curr]) {

            if (vis[it] == 1) {

                // Case 1: cycle detected
                if (path[it] == 1) {
                    path[curr] = 0;
                    isNotSafe[curr] = true;
                    return false;
                }

                // Case 2: this neighbour is already known unsafe
                if (isNotSafe[it]) {
                    path[curr] = 0;
                    isNotSafe[curr] = true;
                    return false;
                }

            } else {

                // Neighbour not visited yet
                if (!dfs(it, graph, vis, path, isNotSafe)) {
                    path[curr] = 0;
                    isNotSafe[curr] = true;
                    return false;
                }
            }
        }

        // All neighbours are safe
        path[curr] = 0;
        ans.add(curr);

        return true;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int[] vis = new int[graph.length];
        int[] path = new int[graph.length];
        boolean[] isNotSafe = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                dfs(i, graph, vis, path, isNotSafe);
            }
        }

        Collections.sort(ans);

        return ans;
    }
}