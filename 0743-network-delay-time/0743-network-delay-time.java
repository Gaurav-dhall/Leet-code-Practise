class Pair {
    int node;
    int cost;

    Pair(int _n, int _c) {
        this.node = _n;
        this.cost = _c;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj= new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<times.length;i++){
            int [] curr=times[i];
            
            adj.get(curr[0]).add(new Pair(curr[1],curr[2]));
            
        }
        
        
        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int []{0,k});
        
        int[] vis =new int[n+1];
        
        
        for(int i=0;i<=n;i++){
            vis[i]=Integer.MAX_VALUE;
        }
        vis[k]=0;
        
        while(!pq.isEmpty()){
            int [] curr=pq.peek();
            pq.poll();
            
            int currcost=curr[0];
            int currnode=curr[1];
            
            List<Pair> currnear =adj.get(currnode);
            
            for(int i=0;i<currnear.size();i++){
                
                if(currnear.get(i).cost + currcost< vis[currnear.get(i).node]){
                    vis[currnear.get(i).node]=currcost+currnear.get(i).cost;
                    pq.offer(new int[]{currnear.get(i).cost+currcost,currnear.get(i).node});
                }
            }
            
            
            
        }
        
        int max=-1;
        for(int i=1;i<=n;i++){
            if(vis[i]==Integer.MAX_VALUE){
                max=-1;
                break;
            }
            
            max=Math.max(max,vis[i]);
        }
        
        
        return max;
    }
}