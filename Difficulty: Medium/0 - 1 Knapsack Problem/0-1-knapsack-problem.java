class Solution {
	
	public static int f(int [] wt, int [] val, int i, int w, int [][] dp) {
		
		if (i == 0) {
			if (wt[0] <= w) {
				return val[0];
			}
			else {
				return 0;
			}
		}
		
		if (dp[i][w] != -1) {
			return dp[i][w];
		}
		int notTake = 0 + f(wt, val, i - 1, w, dp);
		int take = Integer.MIN_VALUE;
		
		if (wt[i] <= w) {
			take = f(wt, val, i - 1, w - wt[i], dp) + val[i];
		}
		
		return dp[i][w] = Math.max(take, notTake);
	}
	public int knapsack(int W, int val[], int wt[]) {
		int n = val.length;
		int [][] dp = new int[n][W + 1];
		
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<W + 1; j++) {
				dp[i][j] = -1;
			}
		}
		// code here
		return f(wt, val, n - 1, W, dp);
		
	}
}
