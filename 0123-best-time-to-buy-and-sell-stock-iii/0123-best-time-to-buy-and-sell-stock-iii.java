class Solution {
    public int f(int i,int buy,int trans,int [] prices,Map<String,Integer> dp){
        if(i==prices.length){
            return 0;
        }
        if(trans==2){
            return 0;
        }
        String key=i+","+buy+","+trans;
        if(dp.containsKey(key)){
            return dp.get(key);
        }
        if(buy==1){
           int  take=-prices[i]+f(i+1,0,trans,prices,dp);
           int  notTake=f(i+1,1,trans,prices,dp);
           dp.put(key,Math.max(take,notTake));
           return dp.get(key);
        }
        else{
            int sell=prices[i]+f(i+1,1,trans+1,prices,dp);
            int notSell=f(i+1,0,trans,prices,dp);

             dp.put(key,Math.max(sell,notSell));
             return dp.get(key);
        }
    }
    public int maxProfit(int[] prices) {
        Map<String,Integer> dp= new HashMap<>();
        return f(0,1,0,prices,dp);
    }
}