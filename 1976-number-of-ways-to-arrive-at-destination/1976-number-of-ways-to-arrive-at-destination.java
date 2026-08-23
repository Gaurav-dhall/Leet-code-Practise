import java.util.*;

class Pair {
    long cost; // Must be long to prevent integer overflow
    int node;

    Pair(long _cost, int _node) {
        this.cost = _cost;
        this.node = _node;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new int[] { roads[i][1], roads[i][2] });
            adj.get(roads[i][1]).add(new int[] { roads[i][0], roads[i][2] });
        }

        // Use Long.compare to safely handle large edge weights
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        
        long[] vis = new long[n];
        long[] ways = new long[n];
        
        Arrays.fill(vis, Long.MAX_VALUE);
        
        vis[0] = 0;
        ways[0] = 1;
        
        pq.offer(new Pair(0, 0));
        
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long currcost = curr.cost;
            int currnode = curr.node;
            
            // Skip processing if we already found a shorter path to this node
            if (currcost > vis[currnode]) {
                continue;
            }
            
            for (int i = 0; i < adj.get(currnode).size(); i++) {
                int nextnode = adj.get(currnode).get(i)[0];
                long nextcost = adj.get(currnode).get(i)[1];
                
                // Case 1: Found a strictly shorter path
                if (currcost + nextcost < vis[nextnode]) {
                    vis[nextnode] = currcost + nextcost;
                    ways[nextnode] = ways[currnode]; // Inherit path count
                    pq.offer(new Pair(vis[nextnode], nextnode));
                } 
                // Case 2: Found another path of the exact same minimum length
                else if (currcost + nextcost == vis[nextnode]) {
                    ways[nextnode] = (ways[nextnode] + ways[currnode]) % MOD;
                }
            }
        }
        
        return (int) ways[n - 1];
    }
}
