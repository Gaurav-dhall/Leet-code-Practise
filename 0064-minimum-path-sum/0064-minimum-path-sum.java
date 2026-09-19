class Solution {
    public int helper(int[][] grid, int r, int c, int[][] dp) {
        if (r == 0 && c == 0) {
            return grid[0][0];
        }

        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;

        return dp[r][c] = grid[r][c] + Math.min(left, top);

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        

        int start=grid[0][0];
        int [] prev= new int[n];
        prev[0]=grid[0][0];
        for(int i=1;i<n;i++){
            prev[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int [] temp= new int[n];
             start=Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    temp[j]=grid[0][0];
                    start=temp[j];
                    continue;
                }
               
               temp[j]=grid[i][j]+Math.min(start,prev[j]);
               start=temp[j];

                
                

            }
            prev=temp;
        }

        return prev[n-1];

    }
}