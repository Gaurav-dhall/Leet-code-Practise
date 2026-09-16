class Solution {
   
    public int helper(int n,int stepped,int[] dp){
        if(stepped>n){
            return 0;
        }
        if(stepped==n){
            
            return 1;
        }
        int a=dp[stepped+1];
        int b=0;
        if(stepped+2<=n){

        b=dp[stepped+2];
        }
        if(a==-1){

         a=helper(n,stepped+1,dp);
        }
        
      if(b==-1){
        b=helper(n,stepped+2,dp);
      }

       dp[stepped]=a+b;
        return a+b;
    }
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int [] dp= new int[n+1];

        for(int i=0;i<n+1;i++){
            dp[i]=-1;
        }
        
      helper(n,0,dp);
      return dp[0];
       
        
    }
}