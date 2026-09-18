class Solution {
    public int helper(int r, int c,int[][] obstacleGrid,int [][]dp){
        if(r==0&&c==0){
            return 1;
        }

        int left=0;
        int top=0;

        if(r>0&&obstacleGrid[r-1][c]!=1){
            if(dp[r-1][c]!=-1){
                top=dp[r-1][c];
            }
            else{

            top=helper(r-1,c,obstacleGrid,dp);
            }
        }

        if(c>0&&obstacleGrid[r][c-1]!=1){
            if(dp[r][c-1]!=-1){
                left=dp[r][c-1];
            }
            else{

            left=helper(r,c-1,obstacleGrid,dp);
            }
        }

        return dp[r][c]= top+left;
        
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

        int [][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }

        return helper(m-1,n-1,obstacleGrid,dp);
    }
}