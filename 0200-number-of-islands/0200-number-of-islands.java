class Solution {
    public void findDfs(char[][] grid,int[][] vis,int r,int c,int m,int n){
        vis[r][c]=1;

        if(r>0&&grid[r-1][c]=='1'&&vis[r-1][c]==0){
            findDfs(grid,vis,r-1,c,m,n);
        }

         if(r<m-1&&grid[r+1][c]=='1'&&vis[r+1][c]==0){
            findDfs(grid,vis,r+1,c,m,n);
        }

         if(c>0&&grid[r][c-1]=='1'&&vis[r][c-1]==0){
            findDfs(grid,vis,r,c-1,m,n);
        }

         if(c<n-1&&grid[r][c+1]=='1'&&vis[r][c+1]==0){
            findDfs(grid,vis,r,c+1,m,n);
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n= grid[0].length;
        int[][] vis= new int[m][n];
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&vis[i][j]==0){
                    findDfs(grid,vis,i,j,m,n);
                    count++;
                }
            }
        }

        return count;
        
    }
}