class Solution {
    public int missingInteger(int[] nums) {
        
        int len=1;
      
        int sum=nums[0];

        int[] hash= new int[1300];

        for(int i=0;i<nums.length;i++){
            hash[nums[i]]++;
        }

        
       for(int i=1;i<nums.length;i++){
            if(nums[i-1]+1==nums[i]){
                len++;
                sum+=nums[i];
               
                continue;
              
            }
           
                break;
        
       }

        if(hash[sum]==0){
            return sum;
        }

       while(hash[sum]!=0){
        sum++;
       }

       return sum;
    }
}