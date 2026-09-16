class Solution {
    List<List<Integer>> bridges= new ArrayList<>();
    int timer=0;

    public void findDfs(List<List<Integer>> adj,int [] vis,int [] ti,int [] minTi,int i , int parent){
       ti[i]=timer;
       minTi[i]=timer;
       timer++;

        vis[i]=1;
        for(int j=0;j<adj.get(i).size();j++){
            if(adj.get(i).get(j)==parent){
                continue;
            }
            if(vis[adj.get(i).get(j)]==0){

            findDfs(adj,vis,ti,minTi,adj.get(i).get(j),i);
            minTi[i]=Math.min(minTi[i],minTi[adj.get(i).get(j)]);

            if(minTi[adj.get(i).get(j)]>ti[i]){
                bridges.add(Arrays.asList(adj.get(i).get(j),i));
            }
            }

            else{
                minTi[i]=Math.min(minTi[i],minTi[adj.get(i).get(j)]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
          List<List<Integer>> adj= new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            adj.get(connections.get(i).get(0)).add(connections.get(i).get(1));
            adj.get(connections.get(i).get(1)).add(connections.get(i).get(0));
        }

        int [] vis= new int[n];
        int [] ti= new int[n];
        int[] minTi=new int [n];

      

        findDfs(adj,vis,ti,minTi,0,-1);
        return bridges;
    }
}