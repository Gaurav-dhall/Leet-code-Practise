class Solution {

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {

        // Node is already in the current recursion stack
        if (state[node] == 1)
            return false;

        // Already processed safely
        if (state[node] == 2)
            return true;

        state[node] = 1;

        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, state))
                return false;
        }

        state[node] = 2;

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state))
                return false;
        }

        return true;
    }
}