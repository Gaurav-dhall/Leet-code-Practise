class Solution {
    public int subArraysLessThanEqual(int [] nums,int goal){
        int l=0;
        int r=0;
        int sum=0;
        int count=0;

        int n=nums.length;
        if(goal<0){
            return 0;
        }

        while(r<n){
            sum+=nums[r];

            while(sum>goal){
                sum-=nums[l];
                l++;
                
            }
            count+=r-l+1;
            r++;
        }

        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       return subArraysLessThanEqual(nums,goal)-subArraysLessThanEqual(nums,goal-1);
    }
}