class Solution {

    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [] prev= new int[2];
        int b=0;
        int s=0;

        for(int i=n-1;i>=0;i--){
           
            for(int buy=0;buy<2;buy++){
                
                if(buy==1){
                    int take=-prices[i]+s;
                    int notTake=b;

                    b=Math.max(take,notTake);
                }
                else{
                    int sell=prices[i]+b;
                    int notSell=s;

                    s=Math.max(sell,notSell);
                }
            }
         
        }

        return b;

        
       
    }
}