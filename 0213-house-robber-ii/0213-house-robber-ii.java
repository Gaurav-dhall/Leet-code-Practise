class Solution {
 
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
      
        int prev=nums[1];
        int prev2=0;
        
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]; 
            if(i>2){
                pick+=prev2;
            }
        int notPick=0+prev;

        int curr=Math.max(pick,notPick);

        prev2=prev;
        prev=curr;

        }

        int first=prev;

      
        prev=nums[0];
       prev2=0;
        
        for(int i=1;i<nums.length-1;i++){
            int pick=nums[i]; 
            if(i>1){
                pick+=prev2;
            }
        int notPick=0+prev;

        int curr=Math.max(pick,notPick);

        prev2=prev;
        prev=curr;

        }
        int sec=prev;

        return Math.max(first,sec);
    }
}