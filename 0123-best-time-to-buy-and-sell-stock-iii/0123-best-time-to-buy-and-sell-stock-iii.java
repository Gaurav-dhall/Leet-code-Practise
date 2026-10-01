class Solution {
    public int f(int i, int buy, int trans, int[] prices, int[][][] dp) {
        if (i == prices.length) {
            return 0;
        }
        if (trans == 2) {
            return 0;
        }

        if (dp[i][buy][trans] != -1) {
            return dp[i][buy][trans];
        }
        if (buy == 1) {
            int take = -prices[i] + f(i + 1, 0, trans, prices, dp);
            int notTake = f(i + 1, 1, trans, prices, dp);
            return dp[i][buy][trans] = Math.max(take, notTake);

        } else {
            int sell = prices[i] + f(i + 1, 1, trans + 1, prices, dp);
            int notSell = f(i + 1, 0, trans, prices, dp);

            return dp[i][buy][trans] = Math.max(sell, notSell);

        }
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][2] = 0;
            }
        }

        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                dp[n][j][k] = 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int trans = 0; trans < 2; trans++) {
                    if (buy == 1) {
                        int take = -prices[i] + dp[i + 1][ 0][ trans];
                        int notTake = dp[i + 1][ 1][ trans];
                         dp[i][buy][trans] = Math.max(take, notTake);

                    } else {
                        int sell = prices[i] + dp[i + 1][ 1][ trans + 1];
                        int notSell = dp[i + 1][ 0][ trans];

                        dp[i][buy][trans] = Math.max(sell, notSell);

                    }
                }
            }
        }
        return dp[0][ 1][ 0];
    }
}