class Item{
    int x;
    int y;
    int dist;

    Item(int xval,int yval,int distval){
        this.x=xval;
        this.y=yval;
        this.dist=distval;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int[][] vis= new int[m][n];
        int [][] ans= new int[m][n];
        Queue<Item> q= new ArrayDeque<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    q.offer(new Item(i,j,0));
                    vis[i][j]=1;
                }
            }
        }

        while(!q.isEmpty()){
            Item curr= q.poll();
            int currX=curr.x;
            int currY=curr.y;
            int currDist=curr.dist;

            ans[currX][currY]=currDist;

            if(currX>0&&vis[currX-1][currY]!=1){
                q.offer(new Item(currX-1,currY,currDist+1));
                vis[currX-1][currY]=1;
            }

            if(currX<m-1&&vis[currX+1][currY]!=1){
                q.offer(new Item(currX+1,currY,currDist+1));
                vis[currX+1][currY]=1;
            }

            if(currY<n-1&&vis[currX][currY+1]!=1){
                q.offer(new Item(currX,currY+1,currDist+1));
                vis[currX][currY+1]=1;
            }

            if(currY>0&&vis[currX][currY-1]!=1){
                q.offer(new Item(currX,currY-1,currDist+1));
                vis[currX][currY-1]=1;
            }
            
        }

        return ans;
        
    }
}