class Pair{
    int node;
    int x;
    int y;
    int dist;

    Pair(int n,int row, int col, int d){
        this.node=n;
        this.x=row;
        this.y=col;
        this.dist=d;

    }
}


class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
      
        
        int m=grid.length;
        int n=grid[0].length;

          int [][] distance= new int[m][n];

          for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
          }
        Queue<Pair> q= new ArrayDeque<>();

        if(grid[0][0]==1||grid[m-1][n-1]==1){
            return -1;
        }
        q.offer(new Pair(grid[0][0],0,0,1));
        distance[0][0]=1;

        while(!q.isEmpty()){
            Pair curr= q.poll();
            int val=curr.node;
            int row=curr.x;
            int col=curr.y;
            int d=curr.dist;

            

            if(row<m-1&&grid[row+1][col]==0){
                if(d+1<distance[row+1][col]){
                    distance[row+1][col]=d+1;
                    q.offer(new Pair(0,row+1,col,d+1));
                }
                
            }

            if(row>0&&grid[row-1][col]==0){
                if(d+1<distance[row-1][col]){
                    distance[row-1][col]=d+1;
                    q.offer(new Pair(0,row-1,col,d+1));
                }
                
            }

            if(col>0&&grid[row][col-1]==0){
                if(d+1<distance[row][col-1]){
                    distance[row][col-1]=d+1;
                    q.offer(new Pair(0,row,col-1,d+1));
                }
                
            }

            if(col<n-1&&grid[row][col+1]==0){
                if(d+1<distance[row][col+1]){
                    distance[row][col+1]=d+1;
                    q.offer(new Pair(0,row,col+1,d+1));
                }
                
            }

            if(row<m-1&&col<n-1&&grid[row+1][col+1]==0){
                if(d+1<distance[row+1][col+1]){
                    distance[row+1][col+1]=d+1;
                    q.offer(new Pair(0,row+1,col+1,d+1));
                }
            }

            if(row<m-1&&col>0&&grid[row+1][col-1]==0){
                if(d+1<distance[row+1][col-1]){
                    distance[row+1][col-1]=d+1;
                    q.offer(new Pair(0,row+1,col-1,d+1));
                }
            }

            if(row>0&&col>0&&grid[row-1][col-1]==0){
                if(d+1<distance[row-1][col-1]){
                    distance[row-1][col-1]=d+1;
                    q.offer(new Pair(0,row-1,col-1,d+1));
                }
            }

            if(row>0&&col<n-1&&grid[row-1][col+1]==0){
                if(d+1<distance[row-1][col+1]){
                    distance[row-1][col+1]=d+1;
                    q.offer(new Pair(0,row-1,col+1,d+1));
                }
            }
        }

        return distance[m-1][n-1]!=Integer.MAX_VALUE?distance[m-1][n-1]:-1;
    }
}