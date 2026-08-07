class Solution {
   
    public boolean dfs(int[][] graph,int []color,int curr,int currcolor){
        color[curr]=currcolor;
        int nextColor=currcolor==1?2:1;

        for(Integer it:graph[curr]){
            if(color[it]==currcolor){
                return false;
            }
            if(color[it]==0){

           if(!dfs(graph,color,it,nextColor)){
            return false;
           }
            }
        }

        return true;

      
    }
    public boolean isBipartite(int[][] graph) {
        int[] color= new int[graph.length];

       for(int i=0;i<color.length;i++){
        if(color[i]==0){
            if(!dfs(graph,color,i,1)){
                return false;
            }
        }
       }

       return true;
       
    }
}