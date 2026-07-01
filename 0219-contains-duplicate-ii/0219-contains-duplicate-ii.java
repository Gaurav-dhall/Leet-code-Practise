class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i=0;
        int j=0;
        int n=nums.length;
        Set<Integer> hash= new HashSet<>();

        while(j<n){

            if(hash.contains(nums[j])){
                return true;
            }
            if(j>=i+k){
                hash.add(nums[j]);
                hash.remove(nums[i]);
                i++;
                
                j++;
            }
            else{
            hash.add(nums[j]);
            j++;
            }
        }
        return false;
    }
}