class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        int target=sum-x;

        if(target<0){
            return -1;
        }

        int l=0;
        int r=0;
        int winSum=0;
        int maxLen=Integer.MIN_VALUE;


        while(r<n&&l<n){
            while(r<n&&winSum+nums[r]<=target){
                winSum+=nums[r];
                r++;
            }

            if(winSum==target){
                maxLen=Math.max(maxLen,r-l);
            }
            

            if(l<n){
                winSum-=nums[l];
            l++;
            }
            
        }
        if(maxLen==Integer.MIN_VALUE){
            return -1;
        }

        return n-maxLen;
    }
}