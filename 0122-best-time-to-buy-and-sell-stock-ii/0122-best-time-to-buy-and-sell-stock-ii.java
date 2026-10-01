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
        int [][] dp= new int[n+1][2];

        for(int i=n;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(i==n){
                    dp[i][buy]=0;
                    continue;
                }
                if(buy==1){
                    int take=-prices[i]+dp[i+1][0];
                    int notTake=dp[i+1][1];

                    dp[i][buy]=Math.max(take,notTake);
                }
                else{
                    int sell=prices[i]+dp[i+1][1];
                    int notSell=dp[i+1][0];

                    dp[i][buy]=Math.max(sell,notSell);
                }
            }
        }

        return dp[0][1];

        
       
    }
}