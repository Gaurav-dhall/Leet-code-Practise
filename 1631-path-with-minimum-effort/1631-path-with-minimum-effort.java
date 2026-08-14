class Pair{
    int dist;
    int row;
    int col;
    
    Pair(int d, int x,int y){
        this.dist=d;
        this.row=x;
        this.col=y;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        
        int [][] distance=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                distance[i][j]=Integer.MAX_VALUE;
            }
        }
        
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
        
        distance[0][0]=0;
        
        pq.offer(new Pair(0,0,0));
        
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int d=curr.dist;
            int r=curr.row;
            int c=curr.col;
            
            if(r==m-1&&c==n-1){
                return d;
            }
            
            int val=heights[r][c];
            
            if(r<m-1){
                int newEff=Math.max(d,Math.abs(heights[r+1][c]-heights[r][c]));
                
                if(newEff<distance[r+1][c]){
                    distance[r+1][c]=newEff;
                    pq.offer(new Pair(newEff,r+1,c));
                }
            }
            
            if(r>0){
                int newEff=Math.max(d,Math.abs(heights[r-1][c]-heights[r][c]));
                
                if(newEff<distance[r-1][c]){
                    distance[r-1][c]=newEff;
                    pq.offer(new Pair(newEff,r-1,c));
                }
            }
            
            if(c<n-1){
                int newEff=Math.max(d,Math.abs(heights[r][c+1]-heights[r][c]));
                
                if(newEff<distance[r][c+1]){
                    distance[r][c+1]=newEff;
                    pq.offer(new Pair(newEff,r,c+1));
                }
            }
            
            if(c>0){
                int newEff=Math.max(d,Math.abs(heights[r][c-1]-heights[r][c]));
                
                if(newEff<distance[r][c-1]){
                    distance[r][c-1]=newEff;
                    pq.offer(new Pair(newEff,r,c-1));
                }
            }
            
        }
        
        return -1;
    }
}