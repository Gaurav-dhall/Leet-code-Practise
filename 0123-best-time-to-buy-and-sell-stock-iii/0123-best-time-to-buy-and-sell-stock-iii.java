class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] prev = new int[2][3];
        

        

        for (int i = n - 1; i >= 0; i--) {
            int [][] temp= new int [2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int trans = 0; trans < 2; trans++) {
                    if (buy == 1) {
                        int take = -prices[i] + prev[ 0][ trans];
                        int notTake = prev[ 1][ trans];
                         temp[buy][trans] = Math.max(take, notTake);

                    } else {
                        int sell = prices[i] + prev[ 1][ trans + 1];
                        int notSell = prev[ 0][ trans];

                       temp[buy][trans] = Math.max(sell, notSell);

                    }
                }
            }
            prev=temp;
        }
        return prev[ 1][ 0];
    }
}