class Solution {


    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int left = 0;
                int top = 0;

                if (j > 0) {
                  
                        left = dp[i][j-1];
                    
                }

                if (i > 0) {
                   
                        top = dp[i - 1][j];
                
                }

                 dp[i][j] = left + top;

            }
        }
        return dp[m-1][n-1];
    }
}