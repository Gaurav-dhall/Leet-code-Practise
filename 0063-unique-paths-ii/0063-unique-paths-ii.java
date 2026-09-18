class Solution {
   

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1){
            return 0;
        }

        int [] prev=new int[n];
        int start = 1;

   

        for (int i = 0; i < m; i++) {
            int [] temp= new int[n];
            temp[0]=(prev[0]==0&&i>0)?0:1;
            start=temp[0];
            for (int j = 0; j < n; j++) {
               

                

                if(obstacleGrid[i][j]==1){
                    temp[j]=0;
                    start=0;
                    continue;
                }

                if(j==0){
                   
                    temp[0]=(prev[0]==0&&i>0)?0:1;
                    start=temp[0];
                    
                   
                   continue;
                }

               

                temp[j]=prev[j]+start;
                start=temp[j];


                

                

            }
            prev=temp;
        }

        return prev[n-1];
    }
}