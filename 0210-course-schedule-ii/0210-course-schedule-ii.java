class Solution {
    
    List<Integer> ans= new ArrayList<>();
    public boolean findDfs(List<List<Integer>> graph,int[] vis,int[] path,int curr){
        vis[curr]=1;
        path[curr]=1;
        
       List<Integer> child= graph.get(curr);

       for(int i=0;i<child.size();i++){
        if(vis[child.get(i)]==1){
            if(path[child.get(i)]==1){
                return true;
            }
        }
        else if(findDfs(graph,vis,path,child.get(i))){
            return true;
        }

       
       }
    ans.add(curr);
    path[curr]=0;

      return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        if(prerequisites.length==0){
           if(numCourses==0){
            return new int[]{};
           }
           int[] temp= new int[numCourses];
           for(int i=0;i<temp.length;i++){
            temp[i]=i;
           }
           return temp;
        }
       List<List<Integer>> graph= new ArrayList<>();
       for(int i=0;i<numCourses;i++){
        graph.add(new ArrayList<>());
       }

        for(int i=0;i<prerequisites.length;i++){
            int [] curr= prerequisites[i];
            graph.get(curr[1]).add(curr[0]);
        }

        int[] vis= new int[numCourses];
        int[] path= new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(vis[i]==0&&findDfs(graph,vis,path,i)){
            return new int[0];
        }
        }
        
        int[] ansArr= new int[numCourses];
    System.out.print(ans);
        for(int i=0;i<ansArr.length;i++){
            ansArr[i]=ans.get(ans.size()-i-1);
        }

        return ansArr;
    }
}