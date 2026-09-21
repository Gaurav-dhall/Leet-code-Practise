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


        boolean [][] dp= new boolean[n][sum/2+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=true;
        }
        if(nums[0]==sum/2){

        dp[0][sum/2]=true;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<sum/2+1;j++){
                boolean not=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }

                dp[i][j]=take||not;
            }
        }

        return dp[n-1][sum/2];

        

       
    }
}