class Solution {
    public int f(int [] nums,int target,int i,int sum){
        if(i==0){
         
             if(sum+nums[0]==target&&sum-nums[0]==target){
                return 2;
            }
            if(sum+nums[0]==target||sum-nums[0]==target){
                return 1;
            }
            return 0;
        }
        int pos=f(nums,target,i-1,sum+nums[i]);
        int neg=f(nums,target,i-1,sum-nums[i]);

        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;

       return f(nums,target,n-1,0);
    }
}