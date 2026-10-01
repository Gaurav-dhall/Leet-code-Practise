class Solution {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [] prev= new int[2];

        for(int i=n-1;i>=0;i--){
            int [] temp= new int[2];
            for(int buy=0;buy<2;buy++){
                
                if(buy==1){
                    int take=-prices[i]+prev[0];
                    int notTake=prev[1];

                    temp[buy]=Math.max(take,notTake);
                }
                else{
                    int sell=prices[i]+prev[1];
                    int notSell=prev[0];

                    temp[buy]=Math.max(sell,notSell);
                }
            }
            prev=temp;
        }

        return prev[1];

        
       
    }
}