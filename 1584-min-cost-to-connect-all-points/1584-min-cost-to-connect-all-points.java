class Pair{
    int wt;
    int node;

    Pair(int _wt,int _node){
        this.wt=_wt;
        this.node=_node;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((x,y)->x.wt-y.wt);
        pq.offer(new Pair(0,0));
        int sum=0;


        int [] vis= new int[points.length];

        while(!pq.isEmpty()){
            Pair curr= pq.peek();
            pq.poll();

            int currWt=curr.wt;
            int currInd=curr.node;

            if(vis[currInd]==1){
                continue;
            }

            vis[currInd]=1;
            sum+=currWt;
            int currX=points[currInd][0];
            int currY=points[currInd][1];

            for(int i=0;i<points.length;i++){
                if(i==currInd){
                    continue;
                }
                
                if(vis[i]==0){
                    int neighX=points[i][0];
                    int neighY=points[i][1];

                    int newWt=(int)(Math.abs(currX-neighX)+Math.abs(currY-neighY));
                    pq.offer(new Pair(newWt,i));
                }

            }


        }

        return sum;
    }
}