class Solution {
    public int f(int index,int target,int [] coins,int [][] dp){
        if(target==0){
            return 1;
        }
        if(index==0){
            if(coins[index]<=target&&target%coins[index]==0){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notTake=f(index-1,target,coins,dp);
        int take=0;

        if(coins[index]<=target){
            take=f(index,target-coins[index],coins,dp);
        }

        return dp[index][target]=take+notTake;

    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int [][] dp= new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
        return f(n-1,amount,coins,dp);
    }
}