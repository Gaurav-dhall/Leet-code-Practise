class Solution {
    public int f(int i1, int i2, String text1, String text2, int[][] dp) {
        if (i1 < 0 || i2 < 0) {
            return 0;
        }

        if (dp[i1][i2] != -1) {
            return dp[i1][i2];
        }
        if (text1.charAt(i1) == text2.charAt(i2)) {
            return dp[i1][i2] = 1 + f(i1 - 1, i2 - 1, text1, text2, dp);
        }
        return dp[i1][i2] = 0 + Math.max(f(i1 - 1, i2, text1, text2, dp), f(i1, i2 - 1, text1, text2, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i1 = 1; i1 < n + 1; i1++) {
            for (int i2 = 1; i2 < m + 1; i2++) {
                int i=i1-1;
                int j=i2-1;
                if (text1.charAt(i) == text2.charAt(j)) {
                     dp[i1][i2] = 1 + dp[i1 -1 ][ i2 - 1];
                }
                else dp[i1][i2] = 0 + Math.max(dp[i1 - 1][i2], dp[i1][ i2- 1]);
            }
        }

        return dp[n ][ m ] ;

    }
}