class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] vis = new int[n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = 1;
        int province = 0;

        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                int curr = q.poll();

                for (int j = 0; j < isConnected[curr].length; j++) {
                    if (isConnected[curr][j] == 1 && vis[j] == 0) {
                        q.offer(j);
                        vis[j] = 1;
                    }
                }
            }
            province++;
            for (int i = 0; i < n; i++) {
                if (vis[i] == 0) {
                    q.offer(i);
                    break;
                }
            }
        }

        return province;
    }
}