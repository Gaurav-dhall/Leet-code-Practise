class Solution {
    public void dfs(int[][] grid,int[][] vis,int r,int c,int m,int n){
        vis[r][c]=1;

        if(r>0&&grid[r-1][c]==1&&vis[r-1][c]!=1){
            dfs(grid,vis,r-1,c,m,n);
        }

        if(r<m-1&&grid[r+1][c]==1&&vis[r+1][c]!=1){
            dfs(grid,vis,r+1,c,m,n);
        }

        if(c>0&&grid[r][c-1]==1&&vis[r][c-1]!=1){
            dfs(grid,vis,r,c-1,m,n);
        }

        if(c<n-1&&grid[r][c+1]==1&&vis[r][c+1]!=1){
            dfs(grid,vis,r,c+1,m,n);
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;


        int[][] vis= new int[m][n];

        for(int i=0;i<n;i++){
            if(grid[0][i]==1&&vis[0][i]!=1){
                dfs(grid,vis,0,i,m,n);
            }
        }

        for(int i=0;i<n;i++){
            if(grid[m-1][i]==1&&vis[m-1][i]!=1){
                dfs(grid,vis,m-1,i,m,n);
            }
        }

        for(int i=0;i<m;i++){
            if(grid[i][0]==1&&vis[i][0]!=1){
                dfs(grid,vis,i,0,m,n);
            }
        }

        for(int i=0;i<m;i++){
            if(grid[i][n-1]==1&&vis[i][n-1]!=1){
                dfs(grid,vis,i,n-1,m,n);
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&vis[i][j]==0){
                    count++;
                }
            }
        }


        return count;

    }
}