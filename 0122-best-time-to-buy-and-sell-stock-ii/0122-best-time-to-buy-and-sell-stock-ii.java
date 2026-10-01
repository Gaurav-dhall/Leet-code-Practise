class Solution {
    public int f(int i,int buy,int [] prices,int [][] dp){
        if(i==prices.length){
            return 0;
        }

        if(dp[i][buy]!=-1){
            return dp[i][buy];
        }
        if(buy==1){
            int take=-prices[i]+f(i+1,0,prices,dp);
            int notTake=f(i+1,1,prices,dp);

            return dp[i][buy]=Math.max(take,notTake);
        }
        else{
            int sell=prices[i]+f(i+1,1,prices,dp);
            int notSell=f(i+1,0,prices,dp);

            return dp[i][buy]=Math.max(sell,notSell);
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][] dp= new int[n][2];

        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return f(0,1,prices,dp);
    }
}