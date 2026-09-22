class Solution {

    public int helper(int[] coins, int amount, int i, int sum,int [][] dp) {
        if (sum == amount) {
            return 0;
        }

        if (i< 0) {
            if (sum == amount) {

                return 0;
            } else {
                return Integer.MAX_VALUE;
            }

        }

        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }

        int notTake = helper(coins, amount, i - 1, sum,dp);
        int take = Integer.MAX_VALUE - 1;

        if (sum + coins[i] <= amount) {
            take = helper(coins, amount, i, sum + coins[i],dp);
        }
        take=take==Integer.MAX_VALUE?Integer.MAX_VALUE:take+1;

        return dp[i][sum]=Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        if(amount==0){
            return 0;
        }

        int [][] dp= new int[n][amount+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j]=-1;
            }
        }
        int ans=helper(coins, amount, n - 1, 0,dp);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}