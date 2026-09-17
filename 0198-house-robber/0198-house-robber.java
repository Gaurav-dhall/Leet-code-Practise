class Solution {
    public int helper(int [] nums,int i,int n,int [] dp){
        if(i==n-1||i==n-2){
            return nums[i];
        }

        if(i>=0&&dp[i]!=-1){
            return dp[i];
        }

        int maxNum=Integer.MIN_VALUE;
        for(int k=2;k<=n-i-1;k++){
           maxNum=Math.max(maxNum,helper(nums,i+k,n,dp)) ;
        }

        if(i>=0){
            maxNum+=nums[i];
             dp[i]=maxNum;
        }

       

        return maxNum;
    }
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
     return helper(nums,-2,nums.length,dp);
    }
}