class Solution {
    public int f(int index, int target, int[] coins, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            if (coins[index] <= target && target % coins[index] == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        int notTake = f(index - 1, target, coins, dp);
        int take = 0;

        if (coins[index] <= target) {
            take = f(index, target - coins[index], coins, dp);
        }

        return dp[index][target] = take + notTake;

    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        prev[0]=1;
        

        for (int j = coins[0]; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                prev[j] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            int [] temp= new int[amount+1];
            temp[0]=1;
            for (int j = 0; j < amount + 1; j++) {
                int notTake = prev[j];
                int take = 0;

                if (coins[i] <= j) {
                    take = temp[ j - coins[i]];
                }

                temp[j] = take + notTake;
            }
            prev=temp;
        }
        return prev[ amount] ;
    }
}