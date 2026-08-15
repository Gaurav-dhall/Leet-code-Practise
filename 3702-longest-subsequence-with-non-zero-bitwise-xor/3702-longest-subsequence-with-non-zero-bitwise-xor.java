class Solution {
    public int longestSubsequence(int[] nums) {
        
        boolean isZeroOnly=true;
        int xor=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                isZeroOnly=false;
            }
            xor=nums[i]^xor;
        }
        
        if(isZeroOnly){
            return 0;
        }
        
        if(xor==0){
            return nums.length-1;
        }
        return nums.length;
    }
}