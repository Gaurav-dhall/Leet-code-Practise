class Solution {
    public int f(String s, String t, int i, int j, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            int notPick = f(s, t, i - 1, j, dp);
            int pick = f(s, t, i - 1, j - 1, dp);

            return dp[i][j] = pick + notPick;
        }

        return dp[i][j] = f(s, t, i - 1, j, dp);
    }

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    int notPick = dp[i - 1][j];
                    int pick = dp[i - 1][j - 1];

                    dp[i][j] = pick + notPick;
                }

                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][m];
    }
}