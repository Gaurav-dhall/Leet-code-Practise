class Solution {
    int province=0;
     
    public void dfs(int [][] isConnected,int [] vis,int curr){
        for(int i=0;i<isConnected[curr].length;i++){
            if(vis[i]==0&&isConnected[curr][i]==1){
                vis[i]=1;
                dfs(isConnected,vis,i);
            }
        }
       
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
       int[] vis= new int[n];
        for(int i=0;i<vis.length;i++){
            if(vis[i]==0){
                vis[i]=1;
                dfs(isConnected,vis,i);
                province++;
            }
        }
        return province;
       
    }
}