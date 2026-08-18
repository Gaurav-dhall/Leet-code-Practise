class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        
        if(nums[0]==nums[n-1]&&k!=n&&k!=1){
            return -1;
        }
        int[] hash =new int[51];
        int max=-1;
        for(Integer it: nums){
            hash[it]++;
            
        }
        
        for(Integer ite:nums){
            if(ite>max){
                int a=max;
                max=ite;
                if(k!=n&&hash[ite]!=1){
                    max=a;
                }
            }
        }
        
        if(k==n||k==1){
            return max;
        }
        if(hash[nums[0]]>1){
            if(hash[nums[n-1]]>1){
                return -1;
            }
            return nums[n-1];
        }
        
        if(hash[nums[n-1]]>1){
            return nums[0];
        }
        
        return Math.max(nums[0],nums[n-1]);
        
    }
}