class Solution {


    public int uniquePaths(int m, int n) {
        
        int start = 1;
        int [] prev = new int[n];
       
        
         

        for (int i = 0; i < m; i++) {
             int [] temp = new int[n];
             temp[0]=1;
           
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                if(j==0){
                    temp[j]=prev[j];
                    start=temp[j];
                    continue;
                }

                int left = 0;
                int top = 0;

                temp[j]=prev[j]+start;
                start=temp[j];

                
                

            }
            prev=temp;
        }
        return prev[n-1];
    }
}