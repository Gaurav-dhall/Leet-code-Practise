class Solution {
    public int jump(int[] nums) {
        
       
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int count=0;

        int i=0;
        while(i<n){
            int landing=i+nums[i];
            if(landing>=n-1){
                    count++;
                    return count;
                }
             int farthest=0;
            int nextTo=0;

            for(int j=i+1;j<=landing;j++){
                
                if(j+nums[j]>farthest){
                    farthest=j+nums[j];
                    nextTo=j;
                }
            }

            i=nextTo;
            count++;

        }

        return count;
    }
}