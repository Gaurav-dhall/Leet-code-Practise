class Pair {
    int node;
    int cost;

    Pair(int _node, int _cost) {
        this.node = _node;
        this.cost = _cost;
    }
}

class Qel {
    int cost;
    int node;
    int count;

    Qel(int _cost, int _node, int _count) {
        this.cost = _cost;
        this.node = _node;
        this.count = _count;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(
                new Pair(flight[1], flight[2])
            );
        }

        PriorityQueue<Qel> pq =
            new PriorityQueue<>((a, b) -> a.cost - b.cost);

        pq.offer(new Qel(0, src, 0));

        // dist[node][flightsUsed]
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while (!pq.isEmpty()) {

            Qel curr = pq.poll();

            int cost = curr.cost;
            int node = curr.node;
            int flightsUsed = curr.count;

            if (node == dst) {
                return cost;
            }

            // We can use at most k + 1 flights
            if (flightsUsed == k + 1) {
                continue;
            }

            for (Pair edge : adj.get(node)) {

                int newNode = edge.node;
                int newCost = cost + edge.cost;
                int newFlights = flightsUsed + 1;

                if (newCost < dist[newNode][newFlights]) {

                    dist[newNode][newFlights] = newCost;

                    pq.offer(
                        new Qel(
                            newCost,
                            newNode,
                            newFlights
                        )
                    );
                }
            }
        }

        return -1;
    }
}