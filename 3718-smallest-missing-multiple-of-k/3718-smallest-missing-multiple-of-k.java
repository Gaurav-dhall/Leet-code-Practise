class Solution {
    public int missingMultiple(int[] nums, int k) {
        int [] hash = new int[101];
        for(Integer i:nums){
            hash[i]=1;
        }
        for(int i=1;i<105;i++){
                
             if(k*i>100||hash[k*i]==0){
                 return k*i;
             }
        }
        
        return 0;
    }
}