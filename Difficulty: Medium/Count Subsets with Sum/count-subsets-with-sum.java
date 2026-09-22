class Solution {
	
	
	public static int perfectSum(int[] arr, int target) {
		int n = arr.length;
		int [] prev = new int[target + 1];
		
		prev[0] = 1;
		for (int i = 0; i<n; i++) {
			int[] temp = new int[target + 1];
			for (int j = 0; j<target + 1; j++) {
				int notTake = prev[j];
				int take = 0;
				if (arr[i] <= j) {
					
					take = prev[j - arr[i]];
				}
				
				temp[j] = take + notTake;
			}
			prev=temp;
		}
		
		return prev[target];
	}
}
