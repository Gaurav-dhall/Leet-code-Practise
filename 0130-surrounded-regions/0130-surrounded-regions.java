class Solution {

    public void dfs(int[][] vis,char[][] board,int r,int c){
        vis[r][c]=1;

        if(r>0&&board[r-1][c]=='O'&&vis[r-1][c]!=1){
            dfs(vis,board,r-1,c);
        }

        
        if(r<board.length-1&&board[r+1][c]=='O'&&vis[r+1][c]!=1){
            dfs(vis,board,r+1,c);
        }

        
        if(c<board[0].length-1&&board[r][c+1]=='O'&&vis[r][c+1]!=1){
            dfs(vis,board,r,c+1);
        }

        
        if(c>0&&board[r][c-1]=='O'&&vis[r][c-1]!=1){
            dfs(vis,board,r,c-1);
        }

        return;


    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int [][] vis= new int[m][n];

        for(int i=0;i<n;i++){
            if(board[0][i]=='O'&&vis[0][i]!=1){
                dfs(vis,board,0,i);
            }
        }

         for(int i=0;i<n;i++){
            if(board[m-1][i]=='O'&&vis[m-1][i]!=1){
                dfs(vis,board,m-1,i);
            }
        }

         for(int i=0;i<m;i++){
            if(board[i][0]=='O'&&vis[i][0]!=1){
                dfs(vis,board,i,0);
            }
        }

         for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'&&vis[i][n-1]!=1){
                dfs(vis,board,i,n-1);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'&&vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }


    }
}