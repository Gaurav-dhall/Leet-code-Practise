class Solution {
	
	public static int f(int i, int cap, int [] val, int [] wt, int [][] dp) {
		
		if (cap == 0) {
			return 0;
		}
		
		if (i == 0) {
			if (wt[i] <= cap) {
				
				return val[i]*(cap/wt[i]);
			}
			else {
				return 0;
			}
		}
		
		if (dp[i][cap] != -1) {
			return dp[i][cap];
		}
		int notTake = 0 + f(i - 1, cap, val, wt,dp);
		int take = 0;
		if (wt[i] <= cap) {
			take = f(i, cap - wt[i], val, wt,dp) + val[i];
		}
		
		return dp[i][cap] = Math.max(take, notTake);
	}
	public int knapSack(int val[], int wt[], int capacity) {
		// code here
		int n = val.length;
		int [][] dp = new int[n][capacity + 1];
		for (int i = 0; i<n; i++) {
			for (int j = 0; j<capacity + 1; j++) {
				dp[i][j] = -1;
			}
		}
		return f(n - 1, capacity, val, wt, dp);
		
	}
}
