class Solution {
    public int helper(int [] nums,int i,int [] dp){
        if(i==0){
            return nums[0];
        }

        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int pick=nums[i]+helper(nums,i-2,dp);
        int notPick=0+helper(nums,i-1,dp);

       dp[i]= Math.max(pick,notPick);
       return Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int [] dp = new int [n];

        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
       return helper(nums,n-1,dp);
    }
}