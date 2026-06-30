class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];
        Map <Integer,Integer> hash=new HashMap<>();
        int n= nums.length;
        for(int i=0;i<n;i++){
            int req=target-nums[i];
            if(hash.containsKey(req)){
                ans[0]=i;
                ans[1]=hash.get(req);
                break;
            }
            hash.put(nums[i],i);
            
        }
        return ans;

    }
}