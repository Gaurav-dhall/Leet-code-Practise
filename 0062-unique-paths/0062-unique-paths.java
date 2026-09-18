class Solution {

    public int helper(int r, int c,int [][] dp) {
        if (r == 0 && c == 0) {
            return 1;
        }

        int left = 0;
        int top = 0;

        if (c > 0) {
            if(dp[r][c-1]!=-1){
                left=dp[r][c-1];
            }
            else{
            left = helper(r, c - 1,dp);
            }
        }

        if (r > 0) {
            if(dp[r-1][c]!=-1){
                top=dp[r-1][c];
            }
            else{
            top = helper(r - 1, c,dp);
            }
        }

        return dp[r][c]=left+top;

    }

    public int uniquePaths(int m, int n) {
        int [][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
      return  helper(m - 1, n - 1,dp);
    }
}