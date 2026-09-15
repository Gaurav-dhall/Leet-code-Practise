class El{
    int time;
    int row;
    int col;

    El(int _t,int _r,int _c){
        this.time=_t;
        this.row=_r;
        this.col=_c;
    }
}


class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;

        PriorityQueue<El> pq= new PriorityQueue<>((a,b)->a.time-b.time);
        pq.offer(new El(grid[0][0],0,0));

        int [] vis= new int[n*n];
        vis[0]=1;
        int ans=0;

        while(!pq.isEmpty()){
            El curr= pq.peek();
            pq.poll();
            int currTime=curr.time;
            int r=curr.row;
            int c=curr.col;

            if(r==n-1&&c==n-1){
                ans=currTime;
                break;
            }

            vis[n*r+c]=1;

            if(r<n-1&&vis[n*(r+1)+c]==0){
                pq.offer(new El(Math.max(currTime,grid[r+1][c]),r+1,c));
            }

             if(r>0&&vis[n*(r-1)+c]==0){
                pq.offer(new El(Math.max(currTime,grid[r-1][c]),r-1,c));
            }

            if(c>0&&vis[n*r+c-1]==0){
                pq.offer(new El(Math.max(currTime,grid[r][c-1]),r,c-1));
            }

            if(c<n-1&&vis[n*r+c+1]==0){
                pq.offer(new El(Math.max(currTime,grid[r][c+1]),r,c+1));
            }

        }

        return ans;
    }
}