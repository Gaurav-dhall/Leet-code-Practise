class Solution {
    
    public boolean findDfs(int source,List<List<Integer>> graph,int destination,int [] vis){
        
        if(source==destination){
            return true;
        }
        vis[source]=1;
        
        List<Integer> curr=graph.get(source);
        
        for(int i=0;i<curr.size();i++){
            if(vis[curr.get(i)]==0){
               if(findDfs(curr.get(i), graph, destination,vis)){
                   return true;
               }
            }
        }
        
        return false;
        
        
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        List<List<Integer>> graph=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            
            graph.get(edges[i][1]).add(edges[i][0]);
            
        }
        
        int[] vis=new int[n];
        
   return     findDfs(source,graph, destination,vis);
    }
}