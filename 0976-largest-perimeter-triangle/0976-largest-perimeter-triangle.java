class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for(int j=nums.length-1;j>=2;j--){
            if(nums[j]+nums[j-1]<=nums[j-2]||nums[j-1]+nums[j-2]<=nums[j]||nums[j]+nums[j-2]<=nums[j-1]){
                continue;
            }

            return nums[j]+nums[j-1]+nums[j-2];
        }

        return 0;
    }
}