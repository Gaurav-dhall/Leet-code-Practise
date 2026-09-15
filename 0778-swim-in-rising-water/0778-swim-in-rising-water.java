import java.util.*;

class Disjoint {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findUpar(int u) {
        if (parent.get(u) == u) {
            return u;
        }

        parent.set(u, findUpar(parent.get(u)));
        return parent.get(u);
    }

    public void union(int u, int v) {
        int pu = findUpar(u);
        int pv = findUpar(v);

        if (pu == pv) {
            return;
        }

        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pu) + size.get(pv));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pu) + size.get(pv));
        }
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Disjoint dj = new Disjoint(n * n);

        // pos[value] = {row, col}
        int[][] pos = new int[n * n][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pos[grid[i][j]][0] = i;
                pos[grid[i][j]][1] = j;
            }
        }

        boolean[][] active = new boolean[n][n];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int t = 0; t < n * n; t++) {
            int r = pos[t][0];
            int c = pos[t][1];
            active[r][c] = true;

            int node = r * n + c;

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && active[nr][nc]) {
                    int neighbourNode = nr * n + nc;
                    dj.union(node, neighbourNode);
                }
            }

            if (dj.findUpar(0) == dj.findUpar(n * n - 1)) {
                return t;
            }
        }

        return -1;
    }
}