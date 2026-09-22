class Solution {
    
    public static int helper(int [] arr, int target, int i,int [][] dp){
        if(i<0){
            if(target==0){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        if(dp[i][target]!=-1){
            return dp[i][target];
        }
        
        int notTake=helper(arr,target,i-1,dp);
        int take=0;
        
        if(arr[i]<=target){
            take=helper(arr,target-arr[i],i-1,dp);
        }
        
        return dp[i][target]=take+notTake;
    }
    public int countPartitions(int[] arr, int diff) {
        // code here
        int sum=0;
        int n=arr.length;
        
        for(int i=0;i<n;i++){
            sum+=arr[i];
        }
        
        if((sum+diff)%2==1){
            return 0;
        }
        
       int target=(sum+diff)/2;
       int dp[][]= new int[n][target+1];
       
       for(int i=0;i<n;i++){
           for(int j=0;j<target+1;j++){
               dp[i][j]=-1;
           }
       }
        
       return helper(arr,target,n-1,dp);
    }
}
