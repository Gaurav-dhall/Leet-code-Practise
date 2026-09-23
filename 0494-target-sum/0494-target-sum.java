class Solution {
    public int f(int [] nums,int target,int i,int sum,int [][] dp){
        if(i==0){
         
             if(sum+nums[0]==target&&sum-nums[0]==target){
                return 2;
            }
            if(sum+nums[0]==target||sum-nums[0]==target){
                return 1;
            }
            return 0;
        }

        if(sum>=0&&dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int pos=f(nums,target,i-1,sum+nums[i],dp);
        int neg=f(nums,target,i-1,sum-nums[i],dp);

        if(sum>=0){
            dp[i][sum]= pos+neg;
        }

        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int [][] dp= new int[n][sum+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<sum+1;j++){
                dp[i][j]=-1;
            }
        }



       return f(nums,target,n-1,0,dp);
    }
}