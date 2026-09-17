class Solution {
    public int helper(int [] nums,int i,int first,int[] dp){
        if(i==first){
            return nums[i];
        }
        if(i<first){
            return 0;
        }

        if(dp[i]!=-1){
            return dp[i];
        }

        int pick=nums[i]+helper(nums,i-2,first,dp);
        int notPick=0+helper(nums,i-1,first,dp);

        return dp[i]= Math.max(pick,notPick);

    }
    public int rob(int[] nums) {
        int n=nums.length;
        int [] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        if(n==1){
            return nums[0];
        }
        int first=helper(nums,n-2,0,dp);
         for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        int last=helper(nums,n-1,1,dp);

        return Math.max(first,last);
    }
}