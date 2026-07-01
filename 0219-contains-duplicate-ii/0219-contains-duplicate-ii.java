class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i=0;
        int j=0;
        int n=nums.length;
        Map<Integer,Integer> hash= new HashMap<>();

        while(j<n){

            if(hash.containsKey(nums[j])){
                return true;
            }
            if(j>=i+k){
                hash.put(nums[j],j);
                hash.remove(nums[i]);
                i++;
                
                j++;
            }
            else{
            hash.put(nums[j],j);
            j++;
            }
        }
        return false;
    }
}