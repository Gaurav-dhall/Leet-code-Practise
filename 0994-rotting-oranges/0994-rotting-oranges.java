class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q= new ArrayDeque<>();
        int m=grid.length;
        for(int i=0;i<m;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                   q.offer(new int[]{i,j,0});
                }
            }
        }
        
        int mins=0;
        boolean flag=false;


        while(!q.isEmpty()){
            int []curr=q.poll();
            int currRow=curr[0];
            int n=grid[currRow].length;
            int i=curr[1];
            int t=curr[2];
           
                
                    if(i<n-1&&grid[currRow][i+1]==1){
                        grid[currRow][i+1]=2;
                        q.offer(new int[]{currRow,i+1,t+1});
                        flag=true;
                        
                    }
                    if(i>0&&grid[currRow][i-1]==1){
                        grid[currRow][i-1]=2;
                        q.offer(new int[]{currRow,i-1,t+1});
                        flag=true;
                       
                    }
                    if(currRow>0&&grid[currRow-1][i]==1){
                        grid[currRow-1][i]=2;
                        q.offer(new int[]{currRow-1,i,t+1});
                        flag=true;
                      
                    }
                    if(currRow<m-1&&grid[currRow+1][i]==1){
                        grid[currRow+1][i]=2;
                        q.offer(new int[]{currRow+1,i,t+1});
                        flag=true;
                      
                    }
                if(flag){

                mins=Math.max(mins,t+1);
                }
                flag=false;
                
           
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return mins;
    }
}