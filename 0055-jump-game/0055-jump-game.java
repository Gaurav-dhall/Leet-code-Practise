class Solution {
    public boolean canJump(int[] nums) {
        int maxReach=0;
        if(nums[0]==0&&nums.length==1) return true;
        for(int i=0;i<=maxReach&&i<nums.length;i++){
            maxReach=Math.max(i+nums[i],maxReach);
            if(i==maxReach){
                return false;
            }

            if(maxReach>=nums.length-1){
                return true;
            }
        }

        return true;
    }
}