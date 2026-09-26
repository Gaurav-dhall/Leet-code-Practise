class Solution {
    public int f(int l, int r, String s, int[][] dp) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return 0;
        }

        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (s.charAt(l) == s.charAt(r)) {
            return dp[l][r] = 0 + f(l + 1, r - 1, s, dp);
        }

        return dp[l][r] = 1 + Math.min(f(l + 1, r, s, dp), f(l, r - 1, s, dp));
    }

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int l = n - 1; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                if (s.charAt(l) == s.charAt(r)) {
                   dp[l][r] = 0 + dp[l + 1][ r - 1];
                }
                else dp[l][r] = 1 + Math.min(dp[l + 1][ r], dp[l][ r - 1]);
            }
        }
        return dp[0][ n - 1];
    }
}