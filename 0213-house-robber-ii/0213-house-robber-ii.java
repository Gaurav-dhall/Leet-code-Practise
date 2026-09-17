class Solution {
 
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int [] dp = new int[n];
        dp[1]=nums[1];
        int neg=0;
        
        for(int i=2;i<nums.length;i++){
            int pick=nums[i]; 
            if(i>2){
                pick+=dp[i-2];
            }
        int notPick=0+dp[i-1];

        dp[i]=Math.max(pick,notPick);

        }

        int first=dp[n-1];

        int [] dp2 = new int[n];
        dp2[0]=nums[0];
        int neg2=0;
        
        for(int i=1;i<nums.length-1;i++){
            int pick=nums[i]; 
            if(i>1){
                pick+=dp2[i-2];
            }
        int notPick=0+dp2[i-1];

        dp2[i]=Math.max(pick,notPick);

        }
        int sec=dp2[n-2];

        return Math.max(first,sec);
    }
}