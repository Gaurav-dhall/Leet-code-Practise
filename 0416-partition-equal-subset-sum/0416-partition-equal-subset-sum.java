class Solution {

    public int helper(int[] nums,int target,int index,int [][] dp){
        if(target==0){
            return 1;
        }
        if(index==0){
            if(target==nums[0]){
                return 1;
            }
            else{
                return 0;
            }
        }

        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int not=helper(nums,target,index-1,dp);
        int take=0;

        if(target>=nums[index]){
            take=helper(nums,target-nums[index],index-1,dp);
        }

        return dp[index][target]=take|not;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2==1){
            return false;
        }

        int [][] dp= new int[n][sum/2+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<dp[i].length;j++){
                dp[i][j]=-1;
            }
        }

       return helper(nums,sum/2,n-1,dp)==1?true:false;
    }
}