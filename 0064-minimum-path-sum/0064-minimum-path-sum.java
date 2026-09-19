class Solution {
    public int helper(int [][] grid,int r, int c,int[][] dp){
        if(r==0&&c==0){
            return grid[0][0];
        }

        int left=Integer.MAX_VALUE;
        int top=Integer.MAX_VALUE;

         if(c>0){
            if(dp[r][c-1]!=-1){
                left=dp[r][c-1];
            }
            else{
                left=helper(grid,r,c-1,dp);
            }
            
        }

        if(r>0){
            if(dp[r-1][c]!=-1){
                top=dp[r-1][c];
            }
            else{
                top= helper(grid,r-1,c,dp);
            }
           
        }

        return dp[r][c]=grid[r][c]+ Math.min(left,top);
       
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int [][] dp= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
       return helper(grid,m-1,n-1,dp);
    }
}